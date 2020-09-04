/**
 * 
 */
package com.codex.search.model;

import java.util.Date;

/**
 * @author kuldeep.kumar
 *
 */

public class ClientPulseHistory {

    private Integer codexGroupId;
    private Integer customerFeedbackId;
    private String codexGroupName;
    private String customerName;
    private String empName;
    private Integer feedBackColor;
    private String customerComments;
    private String customerEmailId;
    private Date submittedDate;
    private String clientName;
    private Integer escId;

    /**
     * @return the codexGroupId
     */
    public Integer getCodexGroupId() {
        return codexGroupId;
    }

    /**
     * @param codexGroupId
     *            the codexGroupId to set
     */
    public void setCodexGroupId(Integer codexGroupId) {
        this.codexGroupId = codexGroupId;
    }

    /**
     * @return the customerFeedbackId
     */
    public Integer getCustomerFeedbackId() {
        return customerFeedbackId;
    }

    /**
     * @param customerFeedbackId
     *            the customerFeedbackId to set
     */
    public void setCustomerFeedbackId(Integer customerFeedbackId) {
        this.customerFeedbackId = customerFeedbackId;
    }

    /**
     * @return the codexGroupName
     */
    public String getCodexGroupName() {
        return codexGroupName;
    }

    /**
     * @param codexGroupName
     *            the codexGroupName to set
     */
    public void setCodexGroupName(String codexGroupName) {
        this.codexGroupName = codexGroupName;
    }

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName
     *            the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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
     * @return the feedBackColor
     */
    public Integer getFeedBackColor() {
        return feedBackColor;
    }

    /**
     * @param feedBackColor
     *            the feedBackColor to set
     */
    public void setFeedBackColor(Integer feedBackColor) {
        this.feedBackColor = feedBackColor;
    }

    /**
     * @return the customerComments
     */
    public String getCustomerComments() {
        return customerComments;
    }

    /**
     * @param customerComments
     *            the customerComments to set
     */
    public void setCustomerComments(String customerComments) {
        this.customerComments = customerComments;
    }

    /**
     * @return the customerEmailId
     */
    public String getCustomerEmailId() {
        return customerEmailId;
    }

    /**
     * @param customerEmailId
     *            the customerEmailId to set
     */
    public void setCustomerEmailId(String customerEmailId) {
        this.customerEmailId = customerEmailId;
    }

    /**
     * @return the submittedDate
     */
    public Date getSubmittedDate() {
        return submittedDate;
    }

    /**
     * @param submittedDate
     *            the submittedDate to set
     */
    public void setSubmittedDate(Date submittedDate) {
        this.submittedDate = submittedDate;
    }

	/**
	 * @return the clientName
	 */
	public String getClientName() {
		return clientName;
	}

	/**
	 * @param clientName the clientName to set
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	/**
	 * @return the escId
	 */
	public Integer getEscId() {
		return escId;
	}

	/**
	 * @param escId the escId to set
	 */
	public void setEscId(Integer escId) {
		this.escId = escId;
	}

}
