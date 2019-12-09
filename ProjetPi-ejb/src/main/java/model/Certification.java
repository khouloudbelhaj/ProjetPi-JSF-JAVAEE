package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Certifications database table.
 * 
 */
@Entity
@Table(name="Certifications")
@NamedQuery(name="Certification.findAll", query="SELECT c FROM Certification c")
public class Certification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CertificationId")
	private int certificationId;

	@Column(name="CredentialIdentification")
	private String credentialIdentification;

	@Column(name="DateObtained")
	private String dateObtained;

	@Column(name="Designation")
	private String designation;

	@Column(name="ExpiryDate")
	private String expiryDate;

	//bi-directional many-to-one association to Candidate
	@ManyToOne
	@JoinColumn(name="CandidateId")
	private Candidate candidate;

	public Certification() {
	}

	public int getCertificationId() {
		return this.certificationId;
	}

	public void setCertificationId(int certificationId) {
		this.certificationId = certificationId;
	}

	public String getCredentialIdentification() {
		return this.credentialIdentification;
	}

	public void setCredentialIdentification(String credentialIdentification) {
		this.credentialIdentification = credentialIdentification;
	}

	public String getDateObtained() {
		return this.dateObtained;
	}

	public void setDateObtained(String dateObtained) {
		this.dateObtained = dateObtained;
	}

	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getExpiryDate() {
		return this.expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Candidate getCandidate() {
		return this.candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

}