package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the Experiences database table.
 * 
 */
@Entity
@Table(name="Experiences")
@NamedQuery(name="Experience.findAll", query="SELECT e FROM Experience e")
public class Experience implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ExperienceId")
	private int experienceId;

	@Column(name="Description")
	private String description;

	@Column(name="Designation")
	private String designation;

	@Column(name="EndDate")
	private Date endDate;

	@Column(name="StartDate")
	private Date startDate;

	//bi-directional many-to-one association to Candidate
	@ManyToOne
	@JoinColumn(name="CandidateId")
	private Candidate candidate;

	public Experience() {
	}

	public int getExperienceId() {
		return this.experienceId;
	}

	public void setExperienceId(int experienceId) {
		this.experienceId = experienceId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Candidate getCandidate() {
		return this.candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

}