package model;

import java.io.Serializable;
import javax.persistence.*;

import Enumerations.*;

import java.util.List;


/**
 * The persistent class for the Offers database table.
 * 
 */
@Entity
@Table(name="Offers")
@NamedQuery(name="Offer.findAll", query="SELECT o FROM Offer o")
public class Offer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="OfferId")
	private int offerId;

	@Column(name="ModifRefus")
	private String modifRefus;

	@Column(name="Offer_Contract_Type")
	private OfferContractType offer_Contract_Type;

	@Column(name="Offer_DatePublished")
	private String offer_DatePublished;

	@Column(name="Offer_description")
	private String offer_description;

	@Column(name="Offer_Etat")
	private EtatOffer offer_Etat;

	@Column(name="Offer_Level_Of_Expertise")
	private Levels offer_Level_Of_Expertise;

	@Column(name="Offer_Title")
	private String offer_Title;

	@Column(name="Offre_Duration")
	private String offre_Duration;

	@Column(name="Offre_Location")
	private String offre_Location;

	@Column(name="Offre_Salary")
	private String offre_Salary;

	@Column(name="Validity")
	private boolean validity;

	@Column(name="Vues")
	private int vues;

	//bi-directional many-to-many association to Candidate
	@ManyToMany
	@JoinTable(
		name="OffresOfCandidate"
		, joinColumns={
			@JoinColumn(name="Candidate")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Offres")
			}
		)
	private List<Candidate> candidates;

	//bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name="CompanyId")
	private Company company;

//	//bi-directional many-to-one association to Skill
//	@OneToMany(mappedBy="offer")
//	private List<Skill> skills;

	public Offer() {
	}

	public int getOfferId() {
		return this.offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public String getModifRefus() {
		return this.modifRefus;
	}

	public void setModifRefus(String modifRefus) {
		this.modifRefus = modifRefus;
	}

	

	public String getOffer_DatePublished() {
		return this.offer_DatePublished;
	}

	public void setOffer_DatePublished(String offer_DatePublished) {
		this.offer_DatePublished = offer_DatePublished;
	}

	public String getOffer_description() {
		return this.offer_description;
	}

	public void setOffer_description(String offer_description) {
		this.offer_description = offer_description;
	}


	

	public OfferContractType getOffer_Contract_Type() {
		return offer_Contract_Type;
	}

	public void setOffer_Contract_Type(OfferContractType offer_Contract_Type) {
		this.offer_Contract_Type = offer_Contract_Type;
	}

	public EtatOffer getOffer_Etat() {
		return offer_Etat;
	}

	public void setOffer_Etat(EtatOffer offer_Etat) {
		this.offer_Etat = offer_Etat;
	}

	public Levels getOffer_Level_Of_Expertise() {
		return offer_Level_Of_Expertise;
	}

	public void setOffer_Level_Of_Expertise(Levels offer_Level_Of_Expertise) {
		this.offer_Level_Of_Expertise = offer_Level_Of_Expertise;
	}

	public String getOffer_Title() {
		return this.offer_Title;
	}

	public void setOffer_Title(String offer_Title) {
		this.offer_Title = offer_Title;
	}

	public String getOffre_Duration() {
		return this.offre_Duration;
	}

	public void setOffre_Duration(String offre_Duration) {
		this.offre_Duration = offre_Duration;
	}

	public String getOffre_Location() {
		return this.offre_Location;
	}

	public void setOffre_Location(String offre_Location) {
		this.offre_Location = offre_Location;
	}

	public String getOffre_Salary() {
		return this.offre_Salary;
	}

	public void setOffre_Salary(String offre_Salary) {
		this.offre_Salary = offre_Salary;
	}

	public boolean getValidity() {
		return this.validity;
	}

	public void setValidity(boolean validity) {
		this.validity = validity;
	}

	public int getVues() {
		return this.vues;
	}

	public void setVues(int vues) {
		this.vues = vues;
	}

	public List<Candidate> getCandidates() {
		return this.candidates;
	}

	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
//
//	public List<Skill> getSkills() {
//		return this.skills;
//	}
//
//	public void setSkills(List<Skill> skills) {
//		this.skills = skills;
//	}
//
//	public Skill addSkill(Skill skill) {
//		getSkills().add(skill);
//		skill.setOffer(this);
//
//		return skill;
//	}
//
//	public Skill removeSkill(Skill skill) {
//		getSkills().remove(skill);
//		skill.setOffer(null);
//
//		return skill;
//	}

	@Override
	public String toString() {
		return "Offer [offerId=" + offerId + ", modifRefus=" + modifRefus + ", offer_Contract_Type="
				+ offer_Contract_Type + ", offer_DatePublished=" + offer_DatePublished + ", offer_description="
				+ offer_description + ", offer_Etat=" + offer_Etat + ", offer_Level_Of_Expertise="
				+ offer_Level_Of_Expertise + ", offer_Title=" + offer_Title + ", offre_Duration=" + offre_Duration
				+ ", offre_Location=" + offre_Location + ", offre_Salary=" + offre_Salary + ", validity=" + validity
				+ ", vues=" + vues + ", company=" + company + "]";
	}

	public Offer(int offerId, String modifRefus) {
		super();
		this.offerId = offerId;
		this.modifRefus = modifRefus;
	}

	

}