package model;

import java.io.Serializable;
import javax.persistence.*;

import Enumerations.Role;

import java.util.List;


/**
 * The persistent class for the Users database table.
 * 
 */
@Entity
@Table(name="Users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="UserId")
	private int userId;

	private boolean activated;

	@Column(name="LastName")
	private String lastName;

	@Column(name="Name")
	private String name;

	private String password;

	private String picture;

	private Role role;

	private int status;

	private String username;
	private String email;
	@Column(name="IdCompany")
	private int idCompany;
	
//
//	//bi-directional many-to-one association to Availability
//	@OneToMany(mappedBy="user")
//	private List<Availability> availabilities;
//
//	//bi-directional many-to-one association to Claim
//	@OneToMany(mappedBy="user")
//	private List<Claim> claims;
//
//	//bi-directional many-to-one association to Interview
//	@OneToMany(mappedBy="user")
//	private List<Interview> interviews;
//
//	//bi-directional many-to-one association to Payment
//	@OneToMany(mappedBy="user")
//	private List<Payment> payments;
	
	//bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name="CompanyId")
	private Company company;
	
	
	//@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="events")

	//private List<Event> events;
	//private List<Company> TestCompany;

	public User() {
	}

	
	
	
//	public User( String lastName, String name,String email, String password, String picture, Role role, int status,
//			String username, List<Availability> availabilities, List<Claim> claims, List<Interview> interviews,
//			List<Payment> payments, Company company) {
//		super();
//		this.activated = false;
//		this.lastName = lastName;
//		this.name = name;
//		this.email=email;
//		this.password = password;
//		this.picture = picture;
//		this.role = role;
//		this.status = status;
//		this.username = username;
//		//this.availabilities = availabilities;
//		//this.claims = claims;
//		//this.interviews = interviews;
//		//this.payments = payments;
//		//this.company = company;
//	}

	
	



	public User(String lastName, String name, String password, Role role,String email, String username, int idcompany) {
		super();
		this.activated = false;
		this.lastName = lastName;
		this.email=email;
		this.name = name;
		this.password = password;
		this.role = role;
		this.username = username;
		this.idCompany=idcompany;
	}
	
	public User(int userId,String lastName, String name, String password, Role role,String email) {
		
		this.userId=userId;
		this.lastName = lastName;
		this.email=email;
		this.name = name;
		this.password = password;
		this.role = role;
		
	}
	public User(int userId,int idCompany) {
		
		this.userId=userId;
	this.idCompany=idCompany;
		//this.company=company;
	}





	@Override
	public String toString() {
		return "User [userId=" + userId + ", activated=" + activated + ", lastName=" + lastName + ", name=" + name
				+ ", email=" + email
				+ ", password=" + password + ", picture=" + picture + ", role=" + role + ", status=" + status
				+ ", username=" + username ;
				
				/*+ ", availabilities=" + availabilities + ", claims=" + claims
				+ ", interviews=" + interviews + ", payments=" + payments + ", company=" + company + "]";*/
	}








	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean getActivated() {
		return this.activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}


	public Role getRole() {
		return role;
	}




	public void setRole(Role role) {
		this.role = role;
	}




	public int getIdCompany() {
		return idCompany;
	}




	public void setIdCompany(int idCompany) {
		this.idCompany = idCompany;
	}




	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

//	public List<Availability> getAvailabilities() {
//		return this.availabilities;
//	}
//
//	public void setAvailabilities(List<Availability> availabilities) {
//		this.availabilities = availabilities;
//	}
//
//	public Availability addAvailability(Availability availability) {
//		getAvailabilities().add(availability);
//		availability.setUser(this);
//
//		return availability;
//	}
//
//	public Availability removeAvailability(Availability availability) {
//		getAvailabilities().remove(availability);
//		availability.setUser(null);
//
//		return availability;
//	}
//
//	public List<Claim> getClaims() {
//		return this.claims;
//	}
//
//	public void setClaims(List<Claim> claims) {
//		this.claims = claims;
//	}
//
//	public Claim addClaim(Claim claim) {
//		getClaims().add(claim);
//		claim.setUser(this);
//
//		return claim;
//	}
//
//	public Claim removeClaim(Claim claim) {
//		getClaims().remove(claim);
//		claim.setUser(null);
//
//		return claim;
//	}
//
//	public List<Interview> getInterviews() {
//		return this.interviews;
//	}
//
//	public void setInterviews(List<Interview> interviews) {
//		this.interviews = interviews;
//	}
//
//	public Interview addInterview(Interview interview) {
//		getInterviews().add(interview);
//		interview.setUser(this);
//
//		return interview;
//	}
//
//	public Interview removeInterview(Interview interview) {
//		getInterviews().remove(interview);
//		interview.setUser(null);
//
//		return interview;
//	}
//
//	public List<Payment> getPayments() {
//		return this.payments;
//	}
//
//	public void setPayments(List<Payment> payments) {
//		this.payments = payments;
//	}
//
//	public Payment addPayment(Payment payment) {
//		getPayments().add(payment);
//		payment.setUser(this);
//
//		return payment;
//	}
//
//	public Payment removePayment(Payment payment) {
//		getPayments().remove(payment);
//		payment.setUser(null);
//
//		return payment;
//	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}
	
	

}