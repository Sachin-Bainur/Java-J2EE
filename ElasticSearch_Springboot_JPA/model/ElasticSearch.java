package com.codex.search.model;

import java.io.Serializable;

/**
 * @author Sachin Bainur
 */

public class ElasticSearch implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String patterns;
	private Object obj;
	private String description;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPatterns() {
		return patterns;
	}
	public void setPatterns(String patterns) {
		this.patterns = patterns;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}

  
  
}
