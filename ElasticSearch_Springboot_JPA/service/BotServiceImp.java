package com.codex.search.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.codex.search.model.Action;
import com.codex.search.model.ClientPulseHistory;
import com.codex.search.model.ElasticSearch;
import com.codex.search.model.Escalations;
import com.codex.search.model.FailedSearch;
import com.codex.search.repository.ActionRepository;
import com.codex.search.repository.CodexLatestRepository;
import com.codex.search.repository.EscalationRepository;
import com.codex.search.repository.FailedSearchRepository;
import com.codex.search.repository.MasterBotQuestionsRepository;
import com.codex.search.util.StopWordsUtil;
import com.codex.search.util.Tokenizer;

/**
 * 
 * @author Sachin Bainur
 * @copyright Copyright (c) CodeX. All Right Reserved.
 * @date 20-feb-2018
 */

@Service
public class BotServiceImp implements BotService {

	private static final Logger LOGGER = Logger.getLogger(BotService.class);

	@Autowired
	MasterBotQuestionsRepository masterQuestionRepo;

	@Autowired
	EscalationRepository escalationRepository;

	@Autowired
	CodexLatestRepository codexLatestRepository;

	@Autowired
	ActionRepository actionRepository;

	@Autowired
	FailedSearchRepository failedSearchRepository;

	/**
	 * Created On: 7 feb 2018 Created By: Sachin Bainur
	 * 
	 * 
	 * 
	 */

	@Override
	public List<String> getAllQestions() {
		LOGGER.info("LAYER-BotServiceImp, METHOD-getAllQestions");
		return masterQuestionRepo.getAllQuestions();
	}

	@Override
	public String syncSearchData(TransportClient client, int id) {

		switch (id) {
		case 1:
			syncEscalation(client);
			break;
		case 2:
			syncIssues(client);
			break;
		case 3:
			syncActions(client);
			break;
		case 4:
			syncCustomerPulse(client);
			break;
		default:
			syncAllData(client);
			break;

		}

		return "OK";
	}

	private void syncActions(TransportClient client) {
		List<Action> actions = actionRepository.getAllActions();
		for (Action action : actions) {
			String projectName = codexLatestRepository.getCodexLatestNameById(action.getCodexgroupid());
			action.setProjectname(projectName);
			ElasticSearch es = new ElasticSearch();
			es.setObj(action);
			es.setPatterns(getMyPattern(action));
			es.setDescription(getDescription(action, false));
			client.prepareIndex(ElasticIndexes.INDEX_ACTION, Integer.toString(action.getCodexgroupid()), String.valueOf(action.getActionid()))
					.setSource(CommonUtil.toJson(es)).get();
		}

	}

	private void syncAllData(TransportClient client) {
		syncEscalation(client);
		syncIssues(client);
		syncActions(client);
		syncCustomerPulse(client);

	}

	private void syncCustomerPulse(TransportClient client) {
		List<ClientPulseHistory> clientPulseList = new ArrayList<>();
		String wsrURL = PropertyUtil.INSTANCE.getProperty("url.wsr.mgt");
		String wsrURLAppended = StringUtil.append(wsrURL, "getCustomerFeedbackByGroupIdsUsingInQuery");
		List<Integer> cids = codexLatestRepository.getAllCodexIds();
		if (!cids.isEmpty()) {
			clientPulseList = ServiceClient.INSTANCE.postForListObject(wsrURLAppended, cids, ClientPulseHistory.class);
			for (ClientPulseHistory clientPulse : clientPulseList) {
				ElasticSearch es = new ElasticSearch();
				es.setObj(clientPulse);
				es.setPatterns(getMyPattern(clientPulse));
				es.setDescription(getDescription(clientPulse, false));
				client.prepareIndex(ElasticIndexes.INDEX_CLIENTPULSE, Integer.toString(clientPulse.getCodexGroupId()),
						String.valueOf(clientPulse.getCustomerFeedbackId())).setSource(CommonUtil.toJson(es)).get();
			}
		}

	}

	private void syncIssues(TransportClient client) {
		List<Escalations> escalations = escalationRepository.getAllIssues();
		for (Escalations escalation : escalations) {
			//String projectName = codexLatestRepository.getCodexLatestNameById(escalation.getCodexgroupid());
			ElasticSearch es = new ElasticSearch();
			es.setObj(escalation);
			es.setPatterns(getMyPattern(escalation));
			es.setDescription(getDescription(escalation, true));
			client.prepareIndex(ElasticIndexes.INDEX_ISSUE, Integer.toString(escalation.getCodexgroupid()), String.valueOf(escalation.getEscalationid()))
					.setSource(CommonUtil.toJson(es)).get();
		}
	}

	private void syncEscalation(TransportClient client) {
		List<Escalations> escalations = escalationRepository.getAllEscalations();
		for (Escalations escalation : escalations) {
			//String projectName = codexLatestRepository.getCodexLatestNameById(escalation.getCodexgroupid());
			ElasticSearch es = new ElasticSearch();
			es.setObj(escalation);
			es.setPatterns(getMyPattern(escalation));
			es.setDescription(getDescription(escalation, false));
			client.prepareIndex(ElasticIndexes.INDEX_ESCALATION,  Integer.toString(escalation.getCodexgroupid()),
					String.valueOf(escalation.getEscalationid())).setSource(CommonUtil.toJson(es)).get();
		}
	}

	private String getMyPattern(Object obj) {
		if (obj instanceof Escalations) {
			Escalations escalation = (Escalations) obj;
			return escalation.getEscalationid() + "," + escalation.getLoggedby() + "," + escalation.getProjectname()
					+ "," + escalation.getLoggedby() + "," + escalation.getAccountname();
		} else if (obj instanceof Action) {
			Action action = (Action) obj;
			return action.getActionid() + "," + action.getRaisedby() + "," + action.getAssignedtoname() + ","
					+ action.getProjectname();
		} else if (obj instanceof ClientPulseHistory) {
			ClientPulseHistory cpHistory = (ClientPulseHistory) obj;
			String color = "";
			switch (cpHistory.getFeedBackColor()) {
			case 1:
				color = "amber,yellow";
				break;
			case 2:
				color = "red";
				break;
			default:
				color = "green";
			}
			return cpHistory.getCustomerFeedbackId() + "," + cpHistory.getClientName() + ","
					+ cpHistory.getCodexGroupName() + "," + "customer Feedback, client pulse, pulse," + color;
		} else
			return "";

	}

	private String getDescription(Object obj, boolean issueflag) {
		if (obj instanceof Escalations) {
			Escalations escalation = (Escalations) obj;
			String type = issueflag ? "Issue" : "Escalation";
			return type + " with Id:" + escalation.getEscalationid() + " Created On " + escalation.getEscalationdate()
					+ " Logged by: " + escalation.getLoggedby() + " Raised due to: " + escalation.getRaisedby()
					+ " Description:" + escalation.getEscalationsummary() + " Account:" + escalation.getAccountname();
		} else if (obj instanceof Action) {
			Action action = (Action) obj;
			return "Action Id:" + action.getActionid() + " Created On: " + action.getCreateddate() + " Raised by: "
					+ action.getRaisedby() + " Assigned to: " + action.getAssignedtoname() + " Description:"
					+ action.getActionname();
		} else if (obj instanceof ClientPulseHistory) {
			ClientPulseHistory cp = (ClientPulseHistory) obj;
			String color = "";
			switch (cp.getFeedBackColor()) {
			case 1:
				color = "Amber";
				break;
			case 2:
				color = "Red";
				break;
			default:
				color = "Green";
			}
			return "Client Pulse Id:" + cp.getCustomerFeedbackId() + " Created On: " + cp.getSubmittedDate()
					+ " Submitted by: " + cp.getClientName() + "  Account: " + cp.getCustomerName() + " Color:" + color;
		} else
			return "";
	}

	@Override
	public void deleteAll(TransportClient client, Integer id) {
		switch (id) {
		case 1:
			deleteEscalation(client);
			break;
		case 2:
			deleteIssues(client);
			break;
		case 3:
			deleteActions(client);
			break;
		default:
			deleteAllData(client);
			break;

		}

	}

	private void deleteAllData(TransportClient client) {
		deleteEscalation(client);
		deleteIssues(client);
		deleteActions(client);

	}

	private void deleteActions(TransportClient client) {
		List<Action> actions = actionRepository.getAllActions();
		for (Action action : actions) {
			String projectName = codexLatestRepository.getCodexLatestNameById(action.getCodexgroupid());
			client.prepareDelete(ElasticIndexes.INDEX_ACTION, projectName, String.valueOf(action.getActionid())).get();
		}

	}

	private void deleteIssues(TransportClient client) {
		List<Escalations> issues = escalationRepository.getAllIssues();
		for (Escalations issue : issues) {
			String projectName = codexLatestRepository.getCodexLatestNameById(issue.getCodexgroupid());
			client.prepareDelete(ElasticIndexes.INDEX_ISSUE, projectName, String.valueOf(issue.getEscalationid()))
					.get();
		}

	}

	private void deleteEscalation(TransportClient client) {
		List<Escalations> escalations = escalationRepository.getAllEscalations();
		for (Escalations escalation : escalations) {
			String projectName = codexLatestRepository.getCodexLatestNameById(escalation.getCodexgroupid());
			client.prepareDelete(ElasticIndexes.INDEX_ESCALATION, projectName,
					String.valueOf(escalation.getEscalationid())).get();
		}

	}

	boolean isKeyPresent(Map<String, String> data, String key) {
		return data.get(key) != null && !"".equals(data.get(key));
	}

	@Override
	public SearchHits getSearchResultByQuery(TransportClient client, String query) {
		query = StopWordsUtil.removeStopWords(query);
		String[] allFeatures = client.admin().indices().prepareGetIndex().setFeatures().get().getIndices();
		String indices[] = Tokenizer.getFeatureTokens(query, allFeatures);
		return elasticSearch(client, indices, query);
	}

	private SearchHits elasticSearch(TransportClient client, String[] indices, String query) {
		SearchRequestBuilder srcGetResponse = client.prepareSearch().setIndices(indices);
		SearchResponse getResponse = null;
		if (query.toLowerCase().split("[ .,!?]").length > 1 || indices.length > 1)
			srcGetResponse = srcGetResponse
					.setQuery(QueryBuilders.multiMatchQuery(query.toLowerCase() + "*", "patterns"));

		getResponse = srcGetResponse.setSize(500).execute().actionGet();
		return getResponse.getHits();
	}

	@Override
	public void storeFailedSearches(FailedSearch data) {
		failedSearchRepository.save(data);
	}

}
