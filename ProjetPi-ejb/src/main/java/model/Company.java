package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the Companies database table.
 * 
 */
@Entity
@Table(name="Companies")
@NamedQuery(name="Company.findAll", query="SELECT c FROM Company c")
public class Company implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CompanyId")
	private int companyId;

	@Column(name="Company_Description")
	private String company_Description;

	@Column(name="Company_Email")
	private String company_Email;

	@Column(name="Company_Logo")
	private String company_Logo;

	@Column(name="Company_Name")
	private String company_Name;

	@Column(name="Company_Number")
	private int company_Number;

	@Column(name="Company_Website")
	private String company_Website;

	@Column(name="NumberOfEmployees")
	private int numberOfEmployees;

	//bi-directional many-to-one association to Offer
	@OneToMany(mappedBy="company", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<Offer> offers;
	
	@ManyToMany(mappedBy="subscriptions",fetch=FetchType.EAGER)
	private Set <Candidate> subscribers;

	
	

	public Company() {
	}

	
	public Set<Candidate> getSubscribers() {
		return subscribers;
	}


	public void setSubscribers(Set<Candidate> subscribers) {
		this.subscribers = subscribers;
	}


	public int getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompany_Description() {
		return this.company_Description;
	}

	public void setCompany_Description(String company_Description) {
		this.company_Description = company_Description;
	}

	public String getCompany_Email() {
		return this.company_Email;
	}

	public void setCompany_Email(String company_Email) {
		this.company_Email = company_Email;
	}

	public String getCompany_Logo() {
		return this.company_Logo;
	}

	public void setCompany_Logo(String company_Logo) {
		this.company_Logo = company_Logo;
	}

	public String getCompany_Name() {
		return this.company_Name;
	}

	public void setCompany_Name(String company_Name) {
		this.company_Name = company_Name;
	}

	public int getCompany_Number() {
		return this.company_Number;
	}

	public void setCompany_Number(int company_Number) {
		this.company_Number = company_Number;
	}

	public String getCompany_Website() {
		return this.company_Website;
	}

	public void setCompany_Website(String company_Website) {
		this.company_Website = company_Website;
	}

	public int getNumberOfEmployees() {
		return this.numberOfEmployees;
	}

	public void setNumberOfEmployees(int numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	public Set<Offer> getOffers() {
		return this.offers;
	}

	public void setOffers(Set<Offer> offers) {
		this.offers = offers;
	}

	public Offer addOffer(Offer offer) {
		getOffers().add(offer);
		offer.setCompany(this);

		return offer;
	}

	public Offer removeOffer(Offer offer) {
		getOffers().remove(offer);
		offer.setCompany(null);

		return offer;
	}

}