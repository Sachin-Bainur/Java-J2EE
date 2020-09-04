package com.codex.search.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "escalation_new")
public class Escalations implements Serializable {

	private static final long serialVersionUID = 3494685060538231396L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "escalationid")
	private Integer escalationid;

	@Column(name = "level")
	private Integer level;

	@Column(name = "projectname")
	private String projectname;

	@Column(name = "accountname")
	private String accountname;

	@Column(name = "practice")
	private String practice;

	@Column(name = "criticality")
	private String criticality;

	@Column(name = "escalationsubject")
	private String escalationsubject;

	@Column(name = "escalationsummary")
	private String escalationsummary;

	@Column(name = "escalationreason")
	private String escalationreason;

	@Column(name = "assignedto")
	private String assignedTo;

	@Column(name = "status")
	private Integer status;

	@Column(name = "escalationdate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date escalationdate;

	@Column(name = "reporteddate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date reporteddate;

	@Column(name = "updateddate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateddate;

	@Column(name = "updatedby")
	private String updatedby;

	@Column(name = "closeddate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date closeddate;

	@Column(name = "loggedby")
	private String loggedby;

	@Column(name = "raisedby")
	private String raisedby;

	@Column(name = "codexgroupid")
	private Integer codexgroupid;

	@OneToMany(targetEntity = Action.class, mappedBy = "escalation", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Action> actions;

	@Column(name = "weeknum")
	private Integer weeknum;

	@Column(name = "month")
	private Integer month;

	@Column(name = "year")
	private Integer year;

	@JsonIgnore
	@Column(name = "isdeleted")
	private Boolean isdeleted;

	@Column(name = "onbehalfof")
	private String onBehalfOf;

	@Column(name = "closurecomment")
	private String closureComments;

	@Column(name = "health_display_flag")
	private Integer healthDisplayFlag;

	public Integer getEscalationid() {
		return escalationid;
	}

	public void setEscalationid(Integer escalationid) {
		this.escalationid = escalationid;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public String getAccountname() {
		return accountname;
	}

	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}

	public String getPractice() {
		return practice;
	}

	public void setPractice(String practice) {
		this.practice = practice;
	}

	public String getCriticality() {
		return criticality;
	}

	public void setCriticality(String criticality) {
		this.criticality = criticality;
	}

	public String getEscalationsubject() {
		return escalationsubject;
	}

	public void setEscalationsubject(String escalationsubject) {
		this.escalationsubject = escalationsubject;
	}

	public String getEscalationsummary() {
		return escalationsummary;
	}

	public void setEscalationsummary(String escalationsummary) {
		this.escalationsummary = escalationsummary;
	}

	public String getEscalationreason() {
		return escalationreason;
	}

	public void setEscalationreason(String escalationreason) {
		this.escalationreason = escalationreason;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getEscalationdate() {
		return escalationdate;
	}

	public void setEscalationdate(Date escalationdate) {
		this.escalationdate = escalationdate;
	}

	public Date getUpdateddate() {
		return updateddate;
	}

	public void setUpdateddate(Date updateddate) {
		this.updateddate = updateddate;
	}

	public Date getCloseddate() {
		return closeddate;
	}

	public void setCloseddate(Date closeddate) {
		this.closeddate = closeddate;
	}

	public String getLoggedby() {
		return loggedby;
	}

	public void setLoggedby(String loggedby) {
		this.loggedby = loggedby;
	}

	public Integer getHealthDisplayFlag() {
		return healthDisplayFlag;
	}

	public void setHealthDisplayFlag(Integer healthDisplayFlag) {
		this.healthDisplayFlag = healthDisplayFlag;
	}

	public String getRaisedby() {
		return raisedby;
	}

	public void setRaisedby(String raisedby) {
		this.raisedby = raisedby;
	}

	public Integer getCodexgroupid() {
		return codexgroupid;
	}

	public void setCodexgroupid(Integer codexgroupid) {
		this.codexgroupid = codexgroupid;
	}

	public Set<Action> getActions() {
		return actions;
	}

	public void setActions(Set<Action> actions) {
		this.actions = actions;
	}

	public Integer getWeeknum() {
		return weeknum;
	}

	public void setWeeknum(Integer weeknum) {
		this.weeknum = weeknum;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Boolean getIsdeleted() {
		return isdeleted;
	}

	public void setIsdeleted(Boolean isdeleted) {
		this.isdeleted = isdeleted;
	}

	public String getOnBehalfOf() {
		return onBehalfOf;
	}

	public void setOnBehalfOf(String onBehalfOf) {
		this.onBehalfOf = onBehalfOf;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}

	public Date getReporteddate() {
		return reporteddate;
	}

	public void setReporteddate(Date reporteddate) {
		this.reporteddate = reporteddate;
	}

	public String getClosureComments() {
		return closureComments;
	}

	public void setClosureComments(String closureComments) {
		this.closureComments = closureComments;
	}

	@Override
	public String toString() {
		return escalationid + "," + level + "," + projectname + "," + accountname + "," + practice + "," + criticality
				+ "," + escalationsubject + "," + escalationsummary + "," + escalationreason + "," + assignedTo + ","
				+ status + "," + escalationdate + "," + updateddate + "," + updatedby + "," + closeddate + ","
				+ loggedby + "," + raisedby + "," + codexgroupid + "," + actions + "," + weeknum + "," + month + ","
				+ year + "," + isdeleted + "," + onBehalfOf;
	}

}
