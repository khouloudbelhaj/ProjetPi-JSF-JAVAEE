package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the Candidates database table.
 * 
 */
@Entity
@Table(name="Candidates")
//@NamedQuery(name="Candidate.findAll", query="SELECT c FROM Candidate c")
public class Candidate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CandidateId")
	private int candidateId;

	@Column(name="Address")
	private String address;

	private String bio;
	@Temporal(TemporalType.DATE)
	@Column(name="DateOfBirthday")
	private Date dateOfBirthday;

	@Column(name="Email")
	private String email;

	@Column(name="FirstName")
	private String firstName;

	@Column(name="Gender")
	private int gender;

	@Column(name="ImageUrl")
	private String imageUrl;

	@Column(name="LastName")
	private String lastName;

	private String password;

	@Column(name="PhoneNumber")
	private String phoneNumber;

	private String profession;

	private String username;

	//bi-directional many-to-many association to Candidate
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
		name="contact"
		, joinColumns={
			@JoinColumn(name="ContactId")
			}
		, inverseJoinColumns={
			@JoinColumn(name="CandidateId")
			}
		)
	private Set<Candidate> candidates1;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
		name="Candidate_Of_Company"
		, joinColumns={
			@JoinColumn(name="CandidateId")
			}
		, inverseJoinColumns={
			@JoinColumn(name="CompanyId")
			}
		)
	private Set<Company> subscriptions;

	//bi-directional many-to-many association to Candidate
	/*@ManyToMany(mappedBy="candidates1")
	private List<Candidate> candidates2;*/

	//bi-directional many-to-one association to Certification
	@OneToMany(mappedBy="candidate", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<Certification> certifications;


	//bi-directional many-to-one association to Experience
	@OneToMany(mappedBy="candidate", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<Experience> experiences;

	//bi-directional many-to-one association to Skill
	@OneToMany(mappedBy="candidate", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<Skill> skills;
	
	@OneToMany(mappedBy="candidate", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<Application> applications;
	

	
	//bi-directional many-to-one association to Contact
	
	public Candidate() {
	}

	public int getCandidateId() {
		return this.candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBio() {
		return this.bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public Date getDateOfBirthday() {
		return this.dateOfBirthday;
	}

	public void setDateOfBirthday(Date dateOfBirthday) {
		this.dateOfBirthday = dateOfBirthday;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getGender() {
		return this.gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getProfession() {
		return this.profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<Candidate> getCandidates1() {
		return this.candidates1;
	}

	public void setCandidates1(Set<Candidate> candidates1) {
		this.candidates1 = candidates1;
	}

//	public List<Candidate> getCandidates2() {
//		return this.candidates2;
//	}
//
//	public void setCandidates2(List<Candidate> candidates2) {
//		this.candidates2 = candidates2;
//	}

	public Set<Certification> getCertifications() {
		return this.certifications;
	}

	public void setCertifications(Set<Certification> certifications) {
		this.certifications = certifications;
	}

	public Certification addCertification(Certification certification) {
		getCertifications().add(certification);
		certification.setCandidate(this);

		return certification;
	}

	public Certification removeCertification(Certification certification) {
		getCertifications().remove(certification);
		certification.setCandidate(null);

		return certification;
	}



	public Set<Experience> getExperiences() {
		return this.experiences;
	}

	public void setExperiences(Set<Experience> experiences) {
		this.experiences = experiences;
	}

	public Experience addExperience(Experience experience) {
		getExperiences().add(experience);
		experience.setCandidate(this);

		return experience;
	}

	public Experience removeExperience(Experience experience) {
		getExperiences().remove(experience);
		experience.setCandidate(null);

		return experience;
	}

	public Set<Skill> getSkills() {
		return this.skills;
	}

	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}

	public Skill addSkill(Skill skill) {
		getSkills().add(skill);
		skill.setCandidate(this);

		return skill;
	}

	public Skill removeSkill(Skill skill) {
		getSkills().remove(skill);
		skill.setCandidate(null);

		return skill;
	}

	public Set<Company> getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(Set<Company> subscriptions) {
		this.subscriptions = subscriptions;
	}

	public Set<Application> getApplications() {
		return applications;
	}

	public void setApplications(Set<Application> applications) {
		this.applications = applications;
	}
	
	

//	public Candidate(String address, String bio, Date dateOfBirthday, String email, String firstName, int gender,
//			String imageUrl, String lastName, String password, String phoneNumber, String profession, String username) {
//		super();
//		this.address = address;
//		this.bio = bio;
//		this.dateOfBirthday = dateOfBirthday;
//		this.email = email;
//		this.firstName = firstName;
//		this.gender = gender;
//		this.imageUrl = imageUrl;
//		this.lastName = lastName;
//		this.password = password;
//		this.phoneNumber = phoneNumber;
//		this.profession = profession;
//		this.username = username;
//	}

	

}