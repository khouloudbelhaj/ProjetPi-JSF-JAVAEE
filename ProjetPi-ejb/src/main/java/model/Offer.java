package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import java.util.Set;


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

	@Column(name="Offer_Contract_Type")
	private String offer_Contract_Type;

	@Column(name="Offer_DatePublished")
	private String offer_DatePublished;

	@Column(name="Offer_description")
	private String offer_description;

	@Column(name="Offer_Level_Of_Expertise")
	private String offer_Level_Of_Expertise;

	@Column(name="Offer_Title")
	private String offer_Title;

	@Column(name="Offre_Duration")
	private String offre_Duration;

	@Column(name="Offre_Location")
	private String offre_Location;

	@Column(name="Offre_Salary")
	private float offre_Salary;

	@Column(name="Validity")
	private boolean validity;

	@Column(name="Vues")
	private int vues;
	
	@OneToMany(mappedBy="offer", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<Application> applications;
	


	//bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name="CompanyId")
	private Company company;

	public Offer() {
	}

	public int getOfferId() {
		return this.offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}
	
	

	public Set<Application> getApplications() {
		return applications;
	}

	public void setApplications(Set<Application> applications) {
		this.applications = applications;
	}

	public String getOffer_Contract_Type() {
		return this.offer_Contract_Type;
	}

	public void setOffer_Contract_Type(String offer_Contract_Type) {
		this.offer_Contract_Type = offer_Contract_Type;
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

	public String getOffer_Level_Of_Expertise() {
		return this.offer_Level_Of_Expertise;
	}

	public void setOffer_Level_Of_Expertise(String offer_Level_Of_Expertise) {
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

	public float getOffre_Salary() {
		return this.offre_Salary;
	}

	public void setOffre_Salary(float offre_Salary) {
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


	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}