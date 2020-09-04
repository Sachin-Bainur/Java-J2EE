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

/**
 * @author manjunath.m Created On: 7 March 2018 This is used as an entity class
 *         for the database table master_project_rag
 */
@Entity
@Table(name = "master_project_rag")
public class MasterProjectRag implements Serializable  {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2122259253891152646L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rag_Id")
    int id;

    @Column(name = "project_Health")
    int projectHealth;

    @Column(name = "reason")
    String reason;

    @Column(name = "comments")
    String comments;

    @Column(name = "creation_time_stamp")
    @Temporal(TemporalType.TIMESTAMP)
    Date creationTimeStamp;

    @Column(name = "system_generated")
    Integer systemGenerated;

    @Column(name = "Master_Codex_codex_id")
    int masterCodexCodexId;

    @Column(name = "autocopy_flag")
    int flag;

    @Column(name = "Master_Project_project_id")
    int masterProjectProjectId;
    
    @Column(name = "status")
    private int status;
    
    
    
	@Column(name = "weekofyear")
    private Integer weekNo;

    @Column(name = "currentyear")
    private Integer yearNo;

    @Column(name = "monthofyear")
    private Integer monthNo;
    
    
    @OneToMany(targetEntity = Action.class, mappedBy = "masterProjectRag", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   	private Set<Action> actions;

    
    /**
	 * @return the actions
	 */
	public Set<Action> getActions() {
		return actions;
	}

	/**
	 * @param actions the actions to set
	 */
	public void setActions(Set<Action> actions) {
		this.actions = actions;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

    public Integer getWeekNo() {
		return weekNo;
	}

	public void setWeekNo(Integer weekNo) {
		this.weekNo = weekNo;
	}

	public Integer getYearNo() {
		return yearNo;
	}

	public void setYearNo(Integer yearNo) {
		this.yearNo = yearNo;
	}

	public Integer getMonthNo() {
		return monthNo;
	}

	public void setMonthNo(Integer monthNo) {
		this.monthNo = monthNo;
	}

	/**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the projectHealth
     */
    public int getProjectHealth() {
        return projectHealth;
    }

    /**
     * @param projectHealth
     *            the projectHealth to set
     */
    public void setProjectHealth(int projectHealth) {
        this.projectHealth = projectHealth;
    }

    /**
     * @return the reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * @param reason
     *            the reason to set
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * @return the comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * @param comments
     *            the comments to set
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * @return the creationTimeStamp
     */
    public Date getCreationTimeStamp() {
        return creationTimeStamp;
    }

    /**
     * @param creationTimeStamp
     *            the creationTimeStamp to set
     */
    public void setCreationTimeStamp(Date creationTimeStamp) {
        this.creationTimeStamp = creationTimeStamp;
    }

    /**
     * @return the systemGenerated
     */
    public Integer getSystemGenerated() {
        return systemGenerated;
    }

    /**
     * @param systemGenerated
     *            the systemGenerated to set
     */
    public void setSystemGenerated(Integer systemGenerated) {
        this.systemGenerated = systemGenerated;
    }

    /**
     * @return the masterCodexCodexId
     */
    public int getMasterCodexCodexId() {
        return masterCodexCodexId;
    }

    /**
     * @param masterCodexCodexId
     *            the masterCodexCodexId to set
     */
    public void setMasterCodexCodexId(int masterCodexCodexId) {
        this.masterCodexCodexId = masterCodexCodexId;
    }

    /**
     * @return the flag
     */
    public int getFlag() {
        return flag;
    }

    /**
     * @param flag
     *            the flag to set
     */
    public void setFlag(int flag) {
        this.flag = flag;
    }

    /**
     * @return the masterProjectProjectId
     */
    public int getMasterProjectProjectId() {
        return masterProjectProjectId;
    }

    /**
     * @param masterProjectProjectId
     *            the masterProjectProjectId to set
     */
    public void setMasterProjectProjectId(int masterProjectProjectId) {
        this.masterProjectProjectId = masterProjectProjectId;
    }
    
    @PrePersist
    @PreUpdate
    public void onCreate() {
           DateUtils d;
           try {
                  d = DateUtils.getDateUtils();
                  if(weekNo==null) {
                	  weekNo=d.getWeekNumber();
                  }
                  if(monthNo==null) {
                	  monthNo=d.getMonthInInteger();
                  }
                  if(yearNo==null) {
                	  yearNo=d.getYear();
                  }
           } catch (Exception e) {
                  //LOGGER.info(e);
           }
           
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MasterProjectRag [id=" + id + ", projectHealth=" + projectHealth + ", reason=" + reason + ", comments="
				+ comments + ", creationTimeStamp=" + creationTimeStamp + ", systemGenerated=" + systemGenerated
				+ ", masterCodexCodexId=" + masterCodexCodexId + ", flag=" + flag + ", masterProjectProjectId="
				+ masterProjectProjectId + ", weekNo=" + weekNo + ", yearNo=" + yearNo + ", monthNo=" + monthNo + "]";
	}


}
