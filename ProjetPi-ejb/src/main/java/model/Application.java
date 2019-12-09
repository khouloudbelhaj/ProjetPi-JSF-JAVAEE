package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;


/**
 * The persistent class for the Applications database table.
 * 
 */
@Entity
@Table(name="Applications")
@NamedQuery(name="Application.findAll", query="SELECT a FROM Application a")
public class Application implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ApplicationId")
	private int applicationId;

	@Column(name="Application_Date")
	private Date application_Date;

	@Column(name="Application_Description")
	private String application_Description;

	@Column(name="Application_Status")
	private String application_Status;
	

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="CandidateId")
	private Candidate candidate;

	@ManyToOne(fetch=FetchType.EAGER)
	private Offer offer;

	public Application() {
	}

	
	public int getApplicationId() {
		return this.applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public Date getApplication_Date() {
		return this.application_Date;
	}

	public void setApplication_Date(Date application_Date) {
		this.application_Date = application_Date;
	}

	public String getApplication_Description() {
		return this.application_Description;
	}

	public void setApplication_Description(String application_Description) {
		this.application_Description = application_Description;
	}

	public String getApplication_Status() {
		return this.application_Status;
	}

	public void setApplication_Status(String application_Status) {
		this.application_Status = application_Status;
	}



	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}



	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	
	

}