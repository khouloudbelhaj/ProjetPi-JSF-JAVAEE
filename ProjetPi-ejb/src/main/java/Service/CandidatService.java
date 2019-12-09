package Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Interfaces.ICandidatServiceRemote;
import model.Application;
import model.Candidate;
import model.Certification;
import model.Company;
import model.Experience;
import model.Offer;
import model.Skill;

@Stateless
@LocalBean
public class CandidatService implements ICandidatServiceRemote {

	@PersistenceContext(unitName = "new")
	EntityManager em;

	@Override
	public void addCandidate(Candidate c) {
		em.persist(c);
	}

	@Override
	public List<Candidate> getCandidates(int id) {
		if (id == -1)
			return em.createQuery("select c from Candidate c", Candidate.class).getResultList();
		List<Candidate> lc = em.createQuery("select c from Candidate c where not candidateId =  " + id, Candidate.class)
				.getResultList();
		if (lc.isEmpty()) {
			return null;
		}
		return lc;
	}

	@Override
	public Object logIn(String username, String password) {

		List<Candidate> lc = em.createQuery(
				"select c from Candidate c where username= '" + username + "' and password= '" + password + "'",
				Candidate.class).getResultList();
		if (lc.isEmpty()) {
			return null;
		}
		return lc.get(0);
	}

	@Override
	public void followCandidate(int followedId, int followerId) {
		Candidate follower = em.find(Candidate.class, followerId);
		Candidate followed = em.find(Candidate.class, followedId);
		follower.getCandidates1().add(followed);
	}

	@Override
	public void unfollowCandidate(int followedId, int followerId) {
		Candidate follower = em.find(Candidate.class, followerId);
		Candidate followed = em.find(Candidate.class, followedId);
		follower.getCandidates1().remove(followed);

	}

	@Override
	public Object getCandidateById(int candidateId) {
		Candidate c = em.find(Candidate.class, candidateId);

		if (c == null)
			return null;
		return c;

	}

	@Override
	public List<Candidate> searchCandidates(String criteria,int candidateId) {
		List<Candidate> toReturn = new ArrayList<>();
		List<Candidate> lc = em.createQuery("select c from Candidate c where not candidateId = "+candidateId+" and (firstName like '%" + criteria
				+ "%' or lastName like '%" + criteria + "%')").getResultList();
		if (!lc.isEmpty()) {
			toReturn.addAll(lc);

		}

		lc.clear();
		lc = em.createQuery("select c from Candidate c where not candidateId = "+candidateId).getResultList();
		for (int i = 0; i < lc.size(); i++) {
			for (Skill s : lc.get(i).getSkills()) {
				if (s.getDesignation().equals(criteria))
					toReturn.add(lc.get(i));
			}
			for (Certification s : lc.get(i).getCertifications()) {
				if (s.getDesignation().equals(criteria))
					toReturn.add(lc.get(i));
			}
			for (Experience s : lc.get(i).getExperiences()) {
				if (s.getDesignation().equals(criteria))
					toReturn.add(lc.get(i));
			}
		}
		return toReturn;
	}

	@Override
	public void applyForAJob(int offerId, int candidateId) {
		Offer o = em.find(Offer.class, offerId);
		Candidate c = em.find(Candidate.class, candidateId);
		Application a = new Application();
		a.setApplication_Date(new Date(System.currentTimeMillis()));
		a.setApplication_Description("I need this job");
		a.setApplication_Status("pending");
		a.setOffer(o);
		a.setCandidate(c);
		c.getApplications().add(a);
	}

	@Override
	public void cancelApplicaiton(int applicationId,int offerId,int candidateId) {
		
		Application a =em.find(Application.class, applicationId);
		Candidate c = em.find(Candidate.class, candidateId);
		Offer o = em.find(Offer.class, offerId);
		c.getApplications().remove(a);
		//o.getApplications().remove(a);
		em.remove(a);
	}

	@Override
	public void subscribe(int enterpriseId, int candidateId) {
		Candidate c = em.find(Candidate.class, candidateId);
		Company co = em.find(Company.class, enterpriseId);
		co.getSubscribers().add(c);
		c.getSubscriptions().add(co);
	}

	@Override
	public void unsubscribe(int enterpriseId, int candidateId) {
		Candidate c = em.find(Candidate.class, candidateId);
		Company co = em.find(Company.class, enterpriseId);
		c.getSubscriptions().remove(co);
		co.getSubscribers().remove(c);
		
	}
}
