package com.codex.search.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "action")
public class Action implements Serializable {

	private static final long serialVersionUID = 4148221981176241992L;

	@Id
	@Column(name = "actionid")
	private String actionid;

	@Column(name = "actionname")
	private String actionname;

	@Column(name = "accountname")
	private String accountname;

	@Column(name = "projectname")
	private String projectname;
	
	
	public String getAccountname() {
		return accountname;
	}

	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@Column(name = "level")
	private Integer level;

	@Column(name = "addedby")
	private String addedby;

	@Column(name = "assignedto")
	private String assignedto;

	@Column(name = "createddate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createddate;

	@Column(name = "updateddate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateddate;

	@Column(name = "expclosedate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date expclosedate;

	@Column(name = "closeddate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date closeddate;

	@Column(name = "actionsource")
	private Integer actionsource;

	@Column(name = "status")
	private Integer status;

	@Column(name = "actioncomment")
	private String actioncomment;

	@Column(name = "escalationid")
	private Integer escalationid;

	@Column(name = "assignedtoname")
	private String assignedtoname;

	@ManyToOne
	@JoinColumn(name = "escalationid", referencedColumnName = "escalationid", insertable = false, updatable = false)
	@JsonIgnore
	private Escalations escalation;

	@ManyToOne
	@JoinColumn(name = "riskid", referencedColumnName = "riskid", insertable = false, updatable = false)
	@JsonIgnore
	private RiskManagement risk;

	@ManyToOne
	@JoinColumn(name = "other2id", referencedColumnName = "rag_Id", insertable = false, updatable = false)
	@JsonIgnore
	private MasterProjectRag masterProjectRag;

	/**
	 * @return the masterProjectRag
	 */
	public MasterProjectRag getMasterProjectRag() {
		return masterProjectRag;
	}

	/**
	 * @param masterProjectRag
	 *            the masterProjectRag to set
	 */
	public void setMasterProjectRag(MasterProjectRag masterProjectRag) {
		this.masterProjectRag = masterProjectRag;
	}

	/**
	 * @return the customerFeedback
	 */
	public CustomerFeedback getCustomerFeedback() {
		return customerFeedback;
	}

	/**
	 * @param customerFeedback
	 *            the customerFeedback to set
	 */
	public void setCustomerFeedback(CustomerFeedback customerFeedback) {
		this.customerFeedback = customerFeedback;
	}

	@ManyToOne
	@JoinColumn(name = "other1id", referencedColumnName = "id", insertable = false, updatable = false)
	@JsonIgnore
	private CustomerFeedback customerFeedback;

	@Column(name = "riskid")
	private Integer riskid;

	@Column(name = "momid")
	private Integer momid;

	@Column(name = "other1id")
	private Integer other1id;

	@Column(name = "other2id")
	private Integer other2id;

	@Column(name = "other3id")
	private Integer other3id;

	@Column(name = "codexgroupid")
	private Integer codexgroupid;

	@Column(name = "weeknum")
	private Integer weeknum;

	@Column(name = "month")
	private Integer month;

	@Column(name = "year")
	private Integer year;

	@JsonIgnore
	@Column(name = "isdeleted")
	private Boolean isdeleted;

	@Column(name = "raisedby")
	private String raisedby;

	@OneToMany(targetEntity = Comment.class, mappedBy = "action", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@OrderBy("commentDate ASC")
	private Set<Comment> comments;

	public String getActionid() {
		return actionid;
	}

	public void setActionid(String actionid) {
		this.actionid = actionid;
	}

	public String getActionname() {
		return actionname;
	}

	public void setActionname(String actionname) {
		this.actionname = actionname;
	}

	public String getAddedby() {
		return addedby;
	}

	public void setAddedby(String addedby) {
		this.addedby = addedby;
	}

	public String getAssignedto() {
		return assignedto;
	}

	public void setAssignedto(String assignedto) {
		this.assignedto = assignedto;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public Date getUpdateddate() {
		return updateddate;
	}

	public void setUpdateddate(Date updateddate) {
		this.updateddate = updateddate;
	}

	public Date getExpclosedate() {
		return expclosedate;
	}

	public void setExpclosedate(Date expclosedate) {
		this.expclosedate = expclosedate;
	}

	public Date getCloseddate() {
		return closeddate;
	}

	public void setCloseddate(Date closeddate) {
		this.closeddate = closeddate;
	}

	public Integer getActionsource() {
		return actionsource;
	}

	public void setActionsource(Integer actionsource) {
		this.actionsource = actionsource;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getActioncomment() {
		return actioncomment;
	}

	public void setActioncomment(String actioncomment) {
		this.actioncomment = actioncomment;
	}

	public Integer getEscalationid() {
		return escalationid;
	}

	public void setEscalationid(Integer escalationid) {
		this.escalationid = escalationid;
	}

	public Escalations getEscalation() {
		return escalation;
	}

	public void setEscalation(Escalations escalation) {
		this.escalation = escalation;
	}

	public Integer getRiskid() {
		return riskid;
	}

	public void setRiskid(Integer riskid) {
		this.riskid = riskid;
	}

	public Integer getMomid() {
		return momid;
	}

	public void setMomid(Integer momid) {
		this.momid = momid;
	}

	public Integer getOther1id() {
		return other1id;
	}

	public void setOther1id(Integer other1id) {
		this.other1id = other1id;
	}

	public Integer getOther2id() {
		return other2id;
	}

	public void setOther2id(Integer other2id) {
		this.other2id = other2id;
	}

	public Integer getOther3id() {
		return other3id;
	}

	public void setOther3id(Integer other3id) {
		this.other3id = other3id;
	}

	public Integer getCodexgroupid() {
		return codexgroupid;
	}

	public void setCodexgroupid(Integer codexgroupid) {
		this.codexgroupid = codexgroupid;
	}

	public Boolean getIsdeleted() {
		return isdeleted;
	}

	public void setIsdeleted(Boolean isdeleted) {
		this.isdeleted = isdeleted;
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

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	/**
	 * @return the risk
	 */
	public RiskManagement getRisk() {
		return risk;
	}

	/**
	 * @param risk
	 *            the risk to set
	 */
	public void setRisk(RiskManagement risk) {
		this.risk = risk;
	}

	/**
	 * @return the raisedby
	 */
	public String getRaisedby() {
		return raisedby;
	}

	/**
	 * @param raisedby
	 *            the raisedby to set
	 */
	public void setRaisedby(String raisedby) {
		this.raisedby = raisedby;
	}

	@Override
	public String toString() {
		return  actionid + "," + actionname + "," + addedby + ","
				+ assignedto + "," + createddate + "," + projectname + ","
				+ expclosedate + "," + closeddate + "," + actionsource + "," + status
				+ "," + actioncomment + "," + escalationid + "," + weeknum
				+ "," + month + "," + year + "," + escalation + "," + riskid
				+ "," + momid + "," + other1id + "," + other2id + "," + other3id
				+ "," + codexgroupid + "," + isdeleted + "," + comments;
	}

	public String getAssignedtoname() {
		return assignedtoname;
	}

	public void setAssignedtoname(String assignedtoname) {
		this.assignedtoname = assignedtoname;
	}

}
