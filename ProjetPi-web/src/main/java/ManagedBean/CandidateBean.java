package ManagedBean;

import java.awt.print.Book;
import java.io.IOException;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;


import Service.CandidatService;
import Service.EnterpriseService;
import model.Candidate;
import model.Company;

@ManagedBean
@SessionScoped
public class CandidateBean implements Serializable {
	private String address;

	private String bio;
	private Date dateOfBirthday;
	private String email;
	private String firstName;
	private int gender;
	private String imageUrl;
	private String criteria;
	private String skillDesignation;
	private float skillRating;
	private int skillId;
	private Candidate viewingCandidate=null;
	private Company viewingCompany=null;
	

	public static Candidate LOGGEDIN_CANDIDATE=null;
	
	@EJB
	CandidatService service;
	@EJB
	EnterpriseService enterpriseService;
	
	public Candidate getLOGGEDIN_CANDIDATE() {
		return LOGGEDIN_CANDIDATE;
	}

	public void setLOGGEDIN_CANDIDATE(Candidate lOGGEDIN_CANDIDATE) {
		LOGGEDIN_CANDIDATE = lOGGEDIN_CANDIDATE;
	}

	
	
	public String getCriteria() {
		return criteria;
	}

	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}

	public Candidate getViewingCandidate() {
		return viewingCandidate;
	}

	public void setViewingCandidate(Candidate viewingCandidate) {
		viewingCandidate = viewingCandidate;
	}
	
	

	public Company getViewingCompany() {
		return viewingCompany;
	}

	public void setViewingCompany(Company viewingCompany) {
		this.viewingCompany = viewingCompany;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public Date getDateOfBirthday() {
		return dateOfBirthday;
	}

	public void setDateOfBirthday(Date dateOfBirthday) {
		this.dateOfBirthday = dateOfBirthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	

	public String getSkillDesignation() {
		return skillDesignation;
	}

	public void setSkillDesignation(String skillDesignation) {
		this.skillDesignation = skillDesignation;
	}

	public float getSkillRating() {
		return skillRating;
	}

	public void setSkillRating(float skillRating) {
		this.skillRating = skillRating;
	}

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}


	private String lastName;
	private String password;
	private String phoneNumber;
	private String profession;
	private String username;
	private List<Candidate> candidates;
	private List<Company> companies;


	public List<Candidate> getCandidates() {
		return candidates;
	}

	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}

	
	
	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	
	@PostConstruct
	public void getAllCandidates() {
		candidates = service.getCandidates(-1);
	}

	public String ajouterCandidat() throws ParseException {
		Candidate cl = new Candidate();

		cl.setAddress(address);
		cl.setBio(bio);
		cl.setDateOfBirthday(dateOfBirthday);
		cl.setEmail(email);
		cl.setFirstName(firstName);
		cl.setLastName(lastName);
		cl.setGender(gender);
		cl.setImageUrl(imageUrl);
		cl.setProfession(profession);
		cl.setPassword(password);
		cl.setUsername(username);
		service.addCandidate(cl);
		return "/resources/AjoutCandidat?faces-redirect=true";

	}

	public String logIn() {
		if (service.logIn(this.username, this.password) != null) {
			LOGGEDIN_CANDIDATE = (Candidate) service.logIn(this.username, this.password);
			System.out.println("logged in");
			candidates = service.getCandidates(LOGGEDIN_CANDIDATE.getCandidateId());
			return "/resources/CandidateProfile?faces-redirect=true";
			
		}
		System.out.println("incorrect password");
		return "/resources/AjoutCandidat?faces-redirect=true";
	}
	
	public String logOut() {
		LOGGEDIN_CANDIDATE=null;
		candidates = service.getCandidates(-1);
		return "/resources/loginCandidate?faces-redirect=true";
	}
	
	public void followCandidate(Candidate c)
	{
		System.out.println("logged in candidate= "+LOGGEDIN_CANDIDATE.getCandidateId());
		service.followCandidate(c.getCandidateId(), LOGGEDIN_CANDIDATE.getCandidateId());
		loadCandidate();
	}
	public void unfollowCandidate(Candidate c)
	{
		System.out.println("unfollow invoked");
		service.unfollowCandidate(c.getCandidateId(), LOGGEDIN_CANDIDATE.getCandidateId());
		loadCandidate();
	}
	
	public String beforeEditingSkill(int skillId)
	{
		this.skillId=skillId;
		return "/resources/editSkill?faces-redirect=true";
	}
	public String editSkillAction()
	{
		service.editSkill(skillId, skillDesignation, skillRating);
		loadCandidate();
		System.out.println("hello from edit action");
		return "/resources/CandidateProfile?faces-redirect=true";
	}
	public void onProfileLoad()
	{
		loadCandidate();
	}
	
	public boolean loadCandidate()
	{
		if(LOGGEDIN_CANDIDATE==null)
		{
			return false;
		}
		else {
			LOGGEDIN_CANDIDATE=(Candidate)service.getCandidateById(LOGGEDIN_CANDIDATE.getCandidateId());
			return true;
		}
	}
	public int getNumberOfFollowers(int candidateId)
	{
		Candidate c = (Candidate)service.getCandidateById(candidateId);
		return c.getCandidates1().size();
	}
	
	public String redirectLogin() {
		if(LOGGEDIN_CANDIDATE==null)
		{
		 return "/resources/loginCandidate";
		}
		return null;
	}
	public String redirectLoggedIn() {
		if(LOGGEDIN_CANDIDATE==null)
			return null;
		return "/resources/CandidateProfile?faces-redirect=true";
		
	}
	
	public String ViewCandidate(Candidate c)
	{
		this.viewingCandidate=(Candidate)service.getCandidateById(c.getCandidateId());
		return "/resources/ViewProfile?faces-redirect=true";
	}
	
	public void searchCandidates () {
		candidates=service.searchCandidates(criteria,LOGGEDIN_CANDIDATE.getCandidateId());
	}
	public void enterpriseList()
	{
		companies=enterpriseService.getAllEnterprises();
	}
	
	public String ViewEnterprise(int companyId)
	{
		viewingCompany=enterpriseService.getEnterprise(companyId);
		return "/resources/ViewEnterprise?faces-redirect=true";
		
	}
	
	public void applyForAJob(int offerId)
	{
		service.applyForAJob(offerId, LOGGEDIN_CANDIDATE.getCandidateId());
		loadCandidate();
	}
	
	public void cancelApplication(String applicationId,int offerId)
	{
		service.cancelApplicaiton(Integer.parseInt(applicationId),offerId,LOGGEDIN_CANDIDATE.getCandidateId());
		loadCandidate();
		System.out.println("cancel method invoked");
	}
	
	public void subscribe()
	{
		service.subscribe(this.viewingCompany.getCompanyId(), LOGGEDIN_CANDIDATE.getCandidateId());
		loadCandidate();
		loadCompany();
	}
	
	public void unsubscribe() {
		service.unsubscribe(this.viewingCompany.getCompanyId(), LOGGEDIN_CANDIDATE.getCandidateId());
		loadCandidate();
		loadCompany();
	}
	
	public void loadCompany()
	{
		viewingCompany=enterpriseService.getEnterprise(viewingCompany.getCompanyId());
		
	}
}
