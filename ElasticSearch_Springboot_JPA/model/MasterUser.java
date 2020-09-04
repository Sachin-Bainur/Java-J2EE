package com.codex.search.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author kuldeep.kumar
 */
@Entity
@Table(name = "master_user")
public class MasterUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1914112157559619010L;

	@Id
	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "emp_email_id")
	private String empEmailId;

	@Column(name = "emp_name")
	private String empName;

	@Column(name = "emp_first_name")
	private String empFirstName;

	@Column(name = "emp_phone_number")
	private String empPhoneNumber;

	@Column(name = "default_view")
	private Integer deafaultView;

	@Column(name = "emp_last_name")
	private String empLastName;

	@Column(name = "emp_other_name")
	private String empOtherName;
	
	@Column(name = "dashboard_default_view")
    private Integer dashboardDefaultView;



	@Column(name = "defaultRole")
	private String defaultRole;
	
	@Column(name = "searchValue")
	private String searchValue;
	
	@Column(name = "inactive")
	private String inactive;
	
	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @return the empEmailId
	 */
	public String getEmpEmailId() {
		return empEmailId;
	}

	/**
	 * @param empEmailId
	 *            the empEmailId to set
	 */
	public void setEmpEmailId(String empEmailId) {
		this.empEmailId = empEmailId;
	}

	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param empName
	 *            the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * @return the empFirstName
	 */
	public String getEmpFirstName() {
		return empFirstName;
	}

	/**
	 * @param empFirstName
	 *            the empFirstName to set
	 */
	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	/**
	 * @return the empPhoneNumber
	 */
	public String getEmpPhoneNumber() {
		return empPhoneNumber;
	}

	/**
	 * @param empPhoneNumber
	 *            the empPhoneNumber to set
	 */
	public void setEmpPhoneNumber(String empPhoneNumber) {
		this.empPhoneNumber = empPhoneNumber;
	}

	/**
	 * @return the deafaultView
	 */
	public Integer getDeafaultView() {
		return deafaultView;
	}

	/**
	 * @param deafaultView
	 *            the deafaultView to set
	 */
	public void setDeafaultView(Integer deafaultView) {
		this.deafaultView = deafaultView;
	}

	
	public String getEmpOtherName() {
		return empOtherName;
	}

	/**
	 * @param empOtherName
	 *            the empOtherName to set
	 */
	public void setEmpOtherName(String empOtherName) {
		this.empOtherName = empOtherName;
	}

	/**
	 * @return the empLastName
	 */
	public String getEmpLastName() {
		return empLastName;
	}

	/**
	 * @param empLastName
	 *            the empLastName to set
	 */
	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}

  /**
   * @return the dashboardDefaultView
   */
  public Integer getDashboardDefaultView() {
    return dashboardDefaultView;
  }

  /**
   * @param dashboardDefaultView the dashboardDefaultView to set
   */
  public void setDashboardDefaultView(Integer dashboardDefaultView) {
    this.dashboardDefaultView = dashboardDefaultView;
  }

public String getDefaultRole() {
	return defaultRole;
}

public void setDefaultRole(String defaultRole) {
	this.defaultRole = defaultRole;
}

public String getSearchValue() {
	return searchValue;
}

public void setSearchValue(String searchValue) {
	this.searchValue = searchValue;
}

@Override
public String toString() {
	return "MasterUser [userId=" + userId + ", empEmailId=" + empEmailId + ", empName=" + empName + ", empFirstName="
			+ empFirstName + ", empPhoneNumber=" + empPhoneNumber + ", deafaultView=" + deafaultView + ", empLastName="
			+ empLastName + ", empOtherName=" + empOtherName + ", dashboardDefaultView=" + dashboardDefaultView
			+ "]";
}

public String getInactive() {
	return inactive;
}

public void setInactive(String inactive) {
	this.inactive = inactive;
}

  
  
}
