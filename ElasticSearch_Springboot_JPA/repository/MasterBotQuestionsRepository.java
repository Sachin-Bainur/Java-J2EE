package com.codex.search.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.codex.search.model.MasterBotQuestions;

/**
 * 
 * @author Sachin Bainur
 * @copyright Copyright (c) CodeX. All Right Reserved.
 * @date 20-feb-2018
 */

@Repository
public interface MasterBotQuestionsRepository extends JpaRepository<MasterBotQuestions, Long> {

	@Query("SELECT m.question FROM MasterBotQuestions m")
	List<String> getAllQuestions();

}
