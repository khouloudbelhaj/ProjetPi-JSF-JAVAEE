package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Skills database table.
 * 
 */
@Entity
@Table(name="Skills")
@NamedQuery(name="Skill.findAll", query="SELECT s FROM Skill s")
public class Skill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SkillId")
	private int skillId;

	@Column(name="Designation")
	private String designation;

	private float rating;

	//bi-directional many-to-one association to Candidate
	@ManyToOne
	@JoinColumn(name="CandidateId")
	private Candidate candidate;

	public Skill() {
	}

	public int getSkillId() {
		return this.skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public float getRating() {
		return this.rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public Candidate getCandidate() {
		return this.candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

}