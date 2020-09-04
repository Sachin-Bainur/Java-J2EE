package com.codex.search.service;

import java.util.List;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.search.SearchHits;

import com.codex.search.model.FailedSearch;

/**
 * 
 * @author Sachin Bainur
 * @copyright Copyright (c) CodeX. All Right Reserved.
 * @date 20-feb-2018
 */
public interface BotService {
	

	List<String> getAllQestions();

	String syncSearchData(TransportClient client, int id);

	void deleteAll(TransportClient client, Integer id);

	SearchHits getSearchResultByQuery(TransportClient client, String string);

	void storeFailedSearches(FailedSearch data);

}
