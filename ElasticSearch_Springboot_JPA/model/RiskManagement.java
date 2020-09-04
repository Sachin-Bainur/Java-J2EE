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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.brillio.codex.framework.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "riskmanagement")
public class RiskManagement implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -8492934874438367372L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "riskid")
	private Integer riskId;

	@Column(name = "riskcreateddate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date riskCreatedDate;

	@Column(name = "riskdescription")
	private String riskDescription;

	@Column(name = "riskprobablity")
	private String riskProbablity;

	@Column(name = "riskimpact")
	private String riskImpact;

	@Column(name = "status")
	private Integer status;

	@Column(name = "expectedcd")
	@Temporal(TemporalType.TIMESTAMP)
	private Date expectedcd;

	@Column(name = "updateddate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;

	@Column(name = "closeddate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date closedDate;

	@Column(name = "projectname")
	private String projectName;

	@Column(name = "customername")
	private String customerName;

	@Column(name = "raisedby")
	private String raisedBy;
	
	@Column(name = "editedby")
	private String editedBy;
	
	@Column(name = "riskwillimpact")
	private String riskWillImpact;
	
	@Column(name = "riskexposurerating")
	private String riskExposureRating;

	@Column(name = "codexgroupid")
	private Integer codexgroupId;

	@OneToMany(targetEntity = Action.class, mappedBy = "risk", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Action> actions;

	@Column(name = "weeknum")
	private Integer weeknum;
	
	@Column(name = "month")
	private Integer month;

	@Column(name = "year")
	private Integer year;

	@JsonIgnore
	@Column(name = "isdeleted")
	private Boolean isDeleted;

	@Column(name = "riskcriticality")
	private String riskCriticality;
	
	@Column(name = "risktitle")
	private String riskTitle;
	
	@Column(name = "closurecomments")
	private String closurecomments;
	
	@PrePersist
	@PreUpdate
	public void onCreate() {
		DateUtils d;
		try {
			d = DateUtils.getDateUtils();
			if(weeknum==null) {
				weeknum=d.getWeekNumber();
			}
			if(month==null) {
				month=d.getMonthInInteger();
			}
			if(year==null) {
				year=d.getYear();
			}
		} catch (Exception e) {
			//LOGGER.info(e);
		}
		
	}


	public Integer getRiskId() {
		return riskId;
	}


	public void setRiskId(Integer riskId) {
		this.riskId = riskId;
	}


	public Date getRiskCreatedDate() {
		return riskCreatedDate;
	}


	public void setRiskCreatedDate(Date riskCreatedDate) {
		this.riskCreatedDate = riskCreatedDate;
	}


	public String getRiskDescription() {
		return riskDescription;
	}


	public void setRiskDescription(String riskDescription) {
		this.riskDescription = riskDescription;
	}


	public String getRiskProbablity() {
		return riskProbablity;
	}


	public void setRiskProbablity(String riskProbablity) {
		this.riskProbablity = riskProbablity;
	}


	public String getRiskImpact() {
		return riskImpact;
	}


	public void setRiskImpact(String riskImpact) {
		this.riskImpact = riskImpact;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public Date getExpectedcd() {
		return expectedcd;
	}


	public void setExpectedcd(Date expectedcd) {
		this.expectedcd = expectedcd;
	}


	public Date getUpdateDate() {
		return updateDate;
	}


	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}


	public Date getClosedDate() {
		return closedDate;
	}


	public void setClosedDate(Date closedDate) {
		this.closedDate = closedDate;
	}


	public String getProjectName() {
		return projectName;
	}


	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getRaisedBy() {
		return raisedBy;
	}


	public void setRaisedBy(String raisedBy) {
		this.raisedBy = raisedBy;
	}


	public String getEditedBy() {
		return editedBy;
	}


	public void setEditedBy(String editedBy) {
		this.editedBy = editedBy;
	}


	public String getRiskWillImpact() {
		return riskWillImpact;
	}


	public void setRiskWillImpact(String riskWillImpact) {
		this.riskWillImpact = riskWillImpact;
	}


	public String getRiskExposureRating() {
		return riskExposureRating;
	}


	public void setRiskExposureRating(String riskExposureRating) {
		this.riskExposureRating = riskExposureRating;
	}


	public Integer getCodexgroupId() {
		return codexgroupId;
	}


	public void setCodexgroupId(Integer codexgroupId) {
		this.codexgroupId = codexgroupId;
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


	public Boolean getIsDeleted() {
		return isDeleted;
	}


	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}


	public String getRiskCriticality() {
		return riskCriticality;
	}


	public void setRiskCriticality(String riskCriticality) {
		this.riskCriticality = riskCriticality;
	}


	public String getRiskTitle() {
		return riskTitle;
	}


	public void setRiskTitle(String riskTitle) {
		this.riskTitle = riskTitle;
	}


	public String getClosurecomments() {
		return closurecomments;
	}


	public void setClosurecomments(String closurecomments) {
		this.closurecomments = closurecomments;
	}


	
	
	
}
