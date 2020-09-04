package com.codex.search.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.codex.search.model.CodexLatest;

@Repository
public interface CodexLatestRepository extends JpaRepository<CodexLatest, Integer> {

	@Query("select t.codexGroupName from CodexLatest t where t.codexGroupId = ?1")
	public String getCodexLatestNameById(Integer codexGroupId);
	
	@Query("select t.codexGroupName from CodexLatest t")
	public List<String> getAllProjectNames();
	
	@Query("select t.codexGroupId from CodexLatest t")
	public List<Integer> getAllCodexIds();

}
