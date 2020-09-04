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

@Entity
@Table(name = "codexgroup_latest")
public class CodexLatest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7423592005649166498L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codexgroupid")
	int codexGroupId;

	@Column(name = "codexgroupname")
	String codexGroupName;

	@Column(name = "displayprojectname")
	String displayProjectName;

	@Column(name = "numberofprojects")
	int numberOfProject;

	@Column(name = "status")
	int status;

	@Column(name = "createddate")
	@Temporal(TemporalType.TIMESTAMP)
	Date createDate;

	@Column(name = "updateddate")
	@Temporal(TemporalType.TIMESTAMP)
	Date updateDate;

	@Column(name = "cidstatus")
	int cidStatus;

	@Column(name = "cidclosedate", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	Date cidCloseDate;

	@Column(name = "STATUSOFPROJECT")
	String statusOfProject;

	@Column(name = "CUSTOMERNAME")
	String customerName;

	@Column(name = "STARTDATE")
	@Temporal(TemporalType.TIMESTAMP)
	Date startDate;

	@Column(name = "ENDDATE")
	@Temporal(TemporalType.TIMESTAMP)
	Date endDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SOWDATE")
	Date sowDate;

	@Column(name = "PROJECTALLOCATIONCATEGORY")
	String projectAllocationCategory;

	@Column(name = "COMMENTS")
	String comments;

	@Column(name = "DELIVERYMODEL")
	String deliveryModel;

	@Column(name = "SUBSIDIARY")
	String subsidiary;

	@Column(name = "GEO")
	String geo;

	@Column(name = "PROJECTCURRENCY")
	String projectCurrency;

	@Column(name = "PROJECTLOCATION")
	String projectLocation;

	@Column(name = "CURRENCY")
	String currency;

	@Column(name = "PROJECTVALUE")
	String projectValue;

	@Column(name = "PROJECTTYPE")
	String projectType;

	@Column(name = "WORKLOCATION")
	String workLocation;

	@Column(name = "TANDMMONTHLY")
	String sTandMmonthly;

	@Column(name = "BEANVARIABLE")
	String beanVariable;

	@Column(name = "BILLINGSCHEDULE")
	String billingSchedule;

	@Column(name = "EXCHANGERATE")
	int exchangeRate;
	@Column(name = "EMAILFLAG")
	int emailFlag;
	@Column(name = "ESTIMATEDREVENUE")
	int estimatedRevenue;
	@Column(name = "pm_id")
	int projectMangerID;

	@Column(name = "dm_id")
	int delieveryMangerID;

	@Column(name = "cp_id")
	int clientPartnerID;
	@Column(name = "ph_id")
	int practiceHeadId;
	
	   @Column(name = "practice")
	    private String practice;

	    @Column(name = "region")
	    private String region;
	    
	    @Column(name = "pm_name")
	    private String pmName;
	    
	    @Column(name = "dm_name")
	    private String dmName;
	    
	public int getCodexGroupId() {
		return codexGroupId;
	}

	public void setCodexGroupId(int codexGroupId) {
		this.codexGroupId = codexGroupId;
	}

	public String getCodexGroupName() {
		return codexGroupName;
	}

	public void setCodexGroupName(String codexGroupName) {
		this.codexGroupName = codexGroupName;
	}

	public String getDisplayProjectName() {
		return displayProjectName;
	}

	public void setDisplayProjectName(String displayProjectName) {
		this.displayProjectName = displayProjectName;
	}

	public int getNumberOfProject() {
		return numberOfProject;
	}

	public void setNumberOfProject(int numberOfProject) {
		this.numberOfProject = numberOfProject;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public int getCidStatus() {
		return cidStatus;
	}

	public void setCidStatus(int cidStatus) {
		this.cidStatus = cidStatus;
	}

	public Date getCidCloseDate() {
		return cidCloseDate;
	}

	public void setCidCloseDate(Date cidCloseDate) {
		this.cidCloseDate = cidCloseDate;
	}

	public String getStatusOfProject() {
		return statusOfProject;
	}

	public void setStatusOfProject(String statusOfProject) {
		this.statusOfProject = statusOfProject;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getSowDate() {
		return sowDate;
	}

	public void setSowDate(Date sowDate) {
		this.sowDate = sowDate;
	}

	public String getProjectAllocationCategory() {
		return projectAllocationCategory;
	}

	/**
	 * @return the pmName
	 */
	public String getPmName() {
		return pmName;
	}

	/**
	 * @param pmName the pmName to set
	 */
	public void setPmName(String pmName) {
		this.pmName = pmName;
	}

	/**
	 * @return the dmName
	 */
	public String getDmName() {
		return dmName;
	}

	/**
	 * @param dmName the dmName to set
	 */
	public void setDmName(String dmName) {
		this.dmName = dmName;
	}

	public void setProjectAllocationCategory(String projectAllocationCategory) {
		this.projectAllocationCategory = projectAllocationCategory;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getDeliveryModel() {
		return deliveryModel;
	}

	public void setDeliveryModel(String deliveryModel) {
		this.deliveryModel = deliveryModel;
	}

	public String getSubsidiary() {
		return subsidiary;
	}

	public void setSubsidiary(String subsidiary) {
		this.subsidiary = subsidiary;
	}

	public String getGeo() {
		return geo;
	}

	public void setGeo(String geo) {
		this.geo = geo;
	}

	public String getProjectCurrency() {
		return projectCurrency;
	}

	public void setProjectCurrency(String projectCurrency) {
		this.projectCurrency = projectCurrency;
	}

	public String getProjectLocation() {
		return projectLocation;
	}

	public void setProjectLocation(String projectLocation) {
		this.projectLocation = projectLocation;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getProjectValue() {
		return projectValue;
	}

	public void setProjectValue(String projectValue) {
		this.projectValue = projectValue;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public String getWorkLocation() {
		return workLocation;
	}

	public void setWorkLocation(String workLocation) {
		this.workLocation = workLocation;
	}

	public String getsTandMmonthly() {
		return sTandMmonthly;
	}

	public void setsTandMmonthly(String sTandMmonthly) {
		this.sTandMmonthly = sTandMmonthly;
	}

	public String getBeanVariable() {
		return beanVariable;
	}

	public void setBeanVariable(String beanVariable) {
		this.beanVariable = beanVariable;
	}

	public String getBillingSchedule() {
		return billingSchedule;
	}

	public void setBillingSchedule(String billingSchedule) {
		this.billingSchedule = billingSchedule;
	}

	public int getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(int exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public int getEmailFlag() {
		return emailFlag;
	}

	public void setEmailFlag(int emailFlag) {
		this.emailFlag = emailFlag;
	}

	public int getEstimatedRevenue() {
		return estimatedRevenue;
	}

	public void setEstimatedRevenue(int estimatedRevenue) {
		this.estimatedRevenue = estimatedRevenue;
	}

	public int getProjectMangerID() {
		return projectMangerID;
	}

	public void setProjectMangerID(int projectMangerID) {
		this.projectMangerID = projectMangerID;
	}

	public int getDelieveryMangerID() {
		return delieveryMangerID;
	}

	public void setDelieveryMangerID(int delieveryMangerID) {
		this.delieveryMangerID = delieveryMangerID;
	}

	public int getClientPartnerID() {
		return clientPartnerID;
	}

	public void setClientPartnerID(int clientPartnerID) {
		this.clientPartnerID = clientPartnerID;
	}

	public int getPracticeHeadId() {
		return practiceHeadId;
	}

	public void setPracticeHeadId(int practiceHeadId) {
		this.practiceHeadId = practiceHeadId;
	}

	/**
	 * @return the practice
	 */
	public String getPractice() {
		return practice;
	}

	/**
	 * @param practice the practice to set
	 */
	public void setPractice(String practice) {
		this.practice = practice;
	}

	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CodexLatest [codexGroupId=" + codexGroupId + ", codexGroupName=" + codexGroupName
				+ ", displayProjectName=" + displayProjectName + ", numberOfProject=" + numberOfProject + ", status="
				+ status + ", createDate=" + createDate + ", updateDate=" + updateDate + ", cidStatus=" + cidStatus
				+ ", cidCloseDate=" + cidCloseDate + ", statusOfProject=" + statusOfProject + ", customerName="
				+ customerName + ", startDate=" + startDate + ", endDate=" + endDate + ", sowDate=" + sowDate
				+ ", projectAllocationCategory=" + projectAllocationCategory + ", comments=" + comments
				+ ", DeliveryModel=" + deliveryModel + ", subsidiary=" + subsidiary + ", geo=" + geo
				+ ", projectCurrency=" + projectCurrency + ", projectLocation=" + projectLocation + ", currency="
				+ currency + ", projectValue=" + projectValue + ", projectType=" + projectType + ", workLocation="
				+ workLocation + ", sTandMmonthly=" + sTandMmonthly + ", beanVariable=" + beanVariable
				+ ", billingSchedule=" + billingSchedule + ", exchangeRate=" + exchangeRate + ", emailFlag=" + emailFlag
				+ ", estimatedRevenue=" + estimatedRevenue + ", projectMangerID=" + projectMangerID
				+ ", delieveryMangerID=" + delieveryMangerID + ", clientPartnerID=" + clientPartnerID
				+ ", practiceHeadId=" + practiceHeadId + "]";
	}

}