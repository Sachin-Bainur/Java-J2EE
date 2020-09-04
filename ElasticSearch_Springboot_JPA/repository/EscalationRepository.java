package com.codex.search.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.codex.search.model.Escalations;

/**
 * @author kuldeep.kumar Repository interface for model MasterUser
 */
@Repository
public interface EscalationRepository extends JpaRepository<Escalations, Integer> {

	/**
	 * Get user id
	 * 
	 * @param emailId
	 * @return
	 */
	@Query("select t from Escalations t where t.level = 1 and t.status!=2 and (t.escalationreason not like '%#rag%' or t.escalationreason not like '%#internalissue%')")
	public List<Escalations> getAllEscalations();
	
	@Query("select t from Escalations t where t.level = 1 and t.status!=2 and (t.escalationreason like '%#rag%' or t.escalationreason like '%#internalissue%') ")
	public List<Escalations> getAllIssues();

	
}
