package com.codex.search.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "comment")
public class Comment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5612844532866461430L;

	@Id
	@Column(name = "commentId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long commentId;

	@Column(name = "commentBy", nullable = false)
	private String commentBy;

	@Column(name = "ecomment")
	private String ecomment;

	@Column(name = "commentDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date commentDate;

	@Column(name = "updateDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;

	@Column(name = "reassign")
	private Boolean reassign;

	@Column(name = "close")
	private Boolean close;

	@Column(name = "assignedTo")
	private String assignedTo;

	@Column(name = "actionid", nullable = false)
	private String actionid;

	@ManyToOne
	@JoinColumn(name = "actionid", referencedColumnName = "actionid", insertable = false, updatable = false)
	@JsonIgnore
	private Action action;

	@JsonIgnore
	@Column(name = "deleteforme")
	private Boolean deleteforme;

	@JsonIgnore
	@Column(name = "deleteforboth")
	private Boolean deleteforboth;

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public String getCommentBy() {
		return commentBy;
	}

	public void setCommentBy(String commentBy) {
		this.commentBy = commentBy;
	}

	public String getEcomment() {
		return ecomment;
	}

	public void setEcomment(String ecomment) {
		this.ecomment = ecomment;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Boolean getReassign() {
		return reassign;
	}

	public void setReassign(Boolean reassign) {
		this.reassign = reassign;
	}

	public Boolean getClose() {
		return close;
	}

	public void setClose(Boolean close) {
		this.close = close;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getActionid() {
		return actionid;
	}

	public void setActionid(String actionid) {
		this.actionid = actionid;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public Boolean getDeleteforme() {
		return deleteforme;
	}

	public void setDeleteforme(Boolean deleteforme) {
		this.deleteforme = deleteforme;
	}

	public Boolean getDeleteforboth() {
		return deleteforboth;
	}

	public void setDeleteforboth(Boolean deleteforboth) {
		this.deleteforboth = deleteforboth;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", commentBy=" + commentBy + ", ecomment=" + ecomment
				+ ", commentDate=" + commentDate + ", reassign=" + reassign + ", close=" + close + ", assignedTo="
				+ assignedTo + ", actionid=" + actionid + ", action=" + action + ", deleteforme=" + deleteforme
				+ ", deleteforboth=" + deleteforboth + "]";
	}

}
