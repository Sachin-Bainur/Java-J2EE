package com.codex.search.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Sachin Bainur
 */

@Entity
@Table(name = "failed_searches")
public class FailedSearch implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date searchedOn;

	@Column(name = "searchedby")
	private String searchedBy;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getSearchedOn() {
		return searchedOn;
	}

	public void setSearchedOn(Date searchedOn) {
		this.searchedOn = searchedOn;
	}

	public String getSearchedBy() {
		return searchedBy;
	}

	public void setSearchedBy(String searchedBy) {
		this.searchedBy = searchedBy;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	@Column(name = "seachstring")
	private String searchString;

}
