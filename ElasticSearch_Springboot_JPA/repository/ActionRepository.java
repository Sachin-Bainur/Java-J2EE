package com.codex.search.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.codex.search.model.Action;

/**
 * @author kuldeep.kumar Repository interface for model MasterUser
 */
@Repository
public interface ActionRepository extends JpaRepository<Action, Integer> {

	/**
	 * Get user id
	 * 
	 * @param emailId
	 * @return
	 */
	@Query("select t from Action t where t.isdeleted!=1 and t.status!=2")
	public List<Action> getAllActions();
}
