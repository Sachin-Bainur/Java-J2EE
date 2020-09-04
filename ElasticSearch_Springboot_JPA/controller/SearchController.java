package com.codex.search.controller;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.codex.search.model.FailedSearch;
import com.codex.search.service.BotService;

/*
 * Created By:Sachin Bainur
 * Date:23-April-2019
 * Elastic Search CURD Operations
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class SearchController extends RestExceptionHandler {

	TransportClient client;
	@Autowired
	BotService botservice;

	@SuppressWarnings("resource")
	public SearchController() throws UnknownHostException {
		client = new PreBuiltTransportClient(Settings.EMPTY)
				.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("http://localhost:9200 (may change for you)"), port_number));

	}

	/**
	 * 
	 * @param id
	 *            (0-For Sync All Data ,1-For Esc Syc ,2-For Issue Sync)
	 * @return String
	 * @throws IOException
	 */
	@GetMapping("/syncSearchData/{id}")
	public String syncSearchData(@PathVariable final int id) throws IOException {
		return botservice.syncSearchData(client, id);
	}

	/**
	 * @description search
	 * @param query
	 * @return
	 */
	@RequestMapping(value = "/searchByQuery", method = RequestMethod.POST, headers = "Accept=application/json")
	public SearchHits searchByQuery(@RequestBody Map<String, String> data) {
		if (StringUtil.isEmpty(data.get("query")))
			return null;
		return botservice.getSearchResultByQuery(client, data.get("query"));
	}

	/**
	 * @description Delete Index
	 * @param id
	 * @return
	 */
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable final Integer id) {
		botservice.deleteAll(client, id);
		return "ok";
	}

	/**
	 * @description Get All Features
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getAllFeature", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<String> getAllQuestions() {
		return botservice.getAllQestions();
	}

	/**
	 * @description Get All Features
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/storeFailedSearches", method = RequestMethod.POST, headers = "Accept=application/json")
	public void storeFailedSearches(@RequestBody FailedSearch data) {
		botservice.storeFailedSearches(data);
	}
}
