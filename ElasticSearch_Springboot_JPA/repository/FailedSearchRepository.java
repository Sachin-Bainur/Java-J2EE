package com.codex.search.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codex.search.model.FailedSearch;

/**
 * @author Sachin Bainur
 */
@Repository
public interface FailedSearchRepository extends JpaRepository<FailedSearch, Integer> {

	
}
