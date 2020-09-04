package com.codex.search.model;

import java.sql.Timestamp;
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
import javax.persistence.Table;

import com.brillio.codex.framework.util.DateUtils;

@Entity
@Table(name = "customer_feedback")
public class CustomerFeedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "wsr_id")
    private String wsrId;
    @Column(name = "customer_id")
    private String customerEmailId;
    @Column(name = "customer_feedback")
    private int feedBackColor;
    @Column(name = "customer_comments")
    private String customerComments;
    @Column(name = "is_opened")
    private int isOpened;
    @Column(name = "opened_date")
    private Timestamp openedDate;
    @Column(name = "is_clicked")
    private int isClicked;
    @Column(name = "clicked_date")
    private Timestamp clickedDate;
    @Column(name = "is_submit")
    private int isSubmitted;
    @Column(name = "submitted_date")
    private Timestamp submittedDate;
    @Column(name = "codexgroup_id")
    private int codexGroupId;

    @Column(name = "weeknumber")
    private int weekNumber;
    
    @Column(name = "year")
    private int year;
    
    
    @Column(name = "esc_id")
    private int escId;
    
    
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


	@OneToMany(targetEntity = Action.class, mappedBy = "customerFeedback", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Action> actions;
    
	/**
	 * @return the escId
	 */
	public int getEscId() {
		return escId;
	}

	/**
	 * @param escId the escId to set
	 */
	public void setEscId(int escId) {
		this.escId = escId;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(int month) {
		this.month = month;
	}


	@Column(name = "month_of_year")
    private int month;

    public int getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(int weekNumber) {
        this.weekNumber = weekNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWsrId() {
        return wsrId;
    }

    public void setWsrId(String wsrId) {
        this.wsrId = wsrId;
    }

    public String getCustomerEmailId() {
        return customerEmailId;
    }

    public void setCustomerEmailId(String customerEmailId) {
        this.customerEmailId = customerEmailId;
    }

    public int getFeedBackColor() {
        return feedBackColor;
    }

    public void setFeedBackColor(int feedBackColor) {
        this.feedBackColor = feedBackColor;
    }

    public String getCustomerComments() {
        return customerComments;
    }

    public void setCustomerComments(String customerComments) {
        this.customerComments = customerComments;
    }

    public int getIsOpened() {
        return isOpened;
    }

    public void setIsOpened(int isOpened) {
        this.isOpened = isOpened;
    }

    public Timestamp getOpenedDate() {
        return openedDate;
    }

    public void setOpenedDate(Timestamp openedDate) {
        this.openedDate = openedDate;
    }

    public int getIsClicked() {
        return isClicked;
    }

    public void setIsClicked(int isClicked) {
        this.isClicked = isClicked;
    }

    public Timestamp getClickedDate() {
        return clickedDate;
    }

    public void setClickedDate(Timestamp clickedDate) {
        this.clickedDate = clickedDate;
    }

    public int getIsSubmitted() {
        return isSubmitted;
    }

    public void setIsSubmitted(int isSubmitted) {
        this.isSubmitted = isSubmitted;
    }

    public Timestamp getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(Timestamp submittedDate) {
        this.submittedDate = submittedDate;
    }

    public int getCodexGroupId() {
        return codexGroupId;
    }

    public void setCodexGroupId(int codexGroupId) {
        this.codexGroupId = codexGroupId;
    }
   
    
	@PrePersist
	public void onCreate() {
		DateUtils d;
		try {
			d = DateUtils.getDateUtils();
			if(weekNumber==0) {
				weekNumber=d.getWeekNumber();
			}
			if(month==0) {
				month=d.getMonthInInteger();
			}
			if(year==0) {
				year=d.getYear();
			}
		} catch (Exception e) {
			/**
			 *LOGGER.info(e); 
			 */
			
		}
		
	}

}
