package Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Enumerations.EtatOffer;
import Interfaces.OfferServiceRemote;
import model.Candidate;
import model.Offer;
import model.Skill;
import model.User;

@Stateless
@LocalBean
public class OfferService implements OfferServiceRemote {
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Offer> getAllOffers() {
		List<Offer> u = em.createQuery("SELECT x FROM Offer x", Offer.class).getResultList();

		return u;
	}
	
	@Override
	public List<Offer> getOffersByUser() {
		//Query query1 = em.createQuery("SELECT o FROM Offer o");
	
		Query query1 = em.createQuery("SELECT o FROM Offer o INNER JOIN User u ON u.idCompany=o.company.companyId ");
		

		List<Offer> u= (List<Offer>) query1.getResultList();
		return u;
	}
	
	
	@Override
	public List<Offer> getOffersNotValidated() {
		
		Query q=  em.createQuery("SELECT o FROM Offer o where o.offer_Etat =:etat ", Offer.class);
		q.setParameter("etat", EtatOffer.Not_validated);		

		return q.getResultList();

	}
	@Override
	public List<Offer> getOfferAccepted()
	{
		
		Query q=  em.createQuery("SELECT o FROM Offer o where o.offer_Etat =:etat ", Offer.class);
		q.setParameter("etat", EtatOffer.Accepted);		

		return q.getResultList();

	}
	@Override
	public List<Offer> getOffersRefused() {
		
		Query q=  em.createQuery("SELECT o FROM Offer o where o.offer_Etat =:etat ", Offer.class);
		q.setParameter("etat", EtatOffer.Refused);		

		return q.getResultList();

	}
	
	@Override
	public void AcceptOffer(int id) {
		Offer u = em.find(Offer.class, id);
		u.setOffer_Etat(EtatOffer.Accepted);
		em.persist(u);
	}
	
	@Override
	public void ReffuseOffer(Offer o) {
//		Offer u = em.find(Offer.class,o.getOfferId());
//				//o.getOfferId());
//		
//		//u.setModifRefus(o.getModifRefus());
//		em.persist(u);
	}
	
	
	
	@Override
	public void ReffuseMotifOffer(Offer o) {
		Offer u = em.find(Offer.class,o.getOfferId());
		u.setModifRefus(o.getModifRefus());
		u.setOffer_Etat(EtatOffer.Refused);
		em.persist(u);
				//o.getOfferId());
		//u.setOffer_Etat(EtatOffer.Refused);
		
		
	}
	
	
	
	
	@Override
	public Map<Integer , List<Candidate>> getSkillsByOffer(int idoffer) {
		
		Query q=  em.createQuery("SELECT s FROM Skill s INNER JOIN Offer o ON s.offer.offerId=o.offerId and s.offer.offerId =:noffer");
		q.setParameter("noffer", idoffer);	
		
		

		List<Skill> s = q.getResultList();
		
		List<Candidate> allcandidate = em.createQuery("SELECT x FROM Candidate x", Candidate.class).getResultList();
		
		System.out.println(allcandidate);
		
		Map<Integer , List<Candidate>> hm = new HashMap<Integer , List<Candidate>>();
		List<Candidate> bestCandidate = new ArrayList<Candidate>();
		for (Candidate allc : allcandidate) {
			int x = 0;
			for (Skill skills : s) {
				
				System.out.println(allc.getFirstName());
				//System.out.println(allc.getSkills());
				
					if (allc.getCandidateId() == skills.getCandidate().getCandidateId()) {
						x++;}
					
					
				
			}
			if (x!=0) {
				bestCandidate.add(allc);
				hm.put(x,bestCandidate);
			}
		}
		
		
		
		
		return hm;

	}
	
	
	
	@Override
	public List<Candidate> getSkillsByOffer2(int idoffer) {
		
		Query q=  em.createQuery("SELECT s FROM Skill s INNER JOIN Offer o ON s.offer.offerId=o.offerId and s.offer.offerId =:noffer");
		q.setParameter("noffer", idoffer);	
		
		List<Candidate> toReturn = new ArrayList();

		List<Skill> s = q.getResultList();
		
		List<Candidate> allcandidate = em.createQuery("SELECT x FROM Candidate x", Candidate.class).getResultList();
		
		System.out.println(allcandidate);
		
		Map<Integer , List<Candidate>> hm = new LinkedHashMap<Integer , List<Candidate>>();
		List<Candidate> bestCandidate = new ArrayList();
		for (Candidate allc : allcandidate) {
			int x = 0;
			for (Skill skills : s) {
				
				//System.out.println(allc.getFirstName());
				//System.out.println(allc.getSkills());
				
					if (allc.getCandidateId() == skills.getCandidate().getCandidateId()) {
						x++;}
					
					
				
			}
			if (x!=0) {
				toReturn.add(allc);
				//hm.put(x,bestCandidate);
			}
		}
		
		
		
		
		return toReturn;

	}
	
	
	
	
//	@Override
//	public Map<Integer , List<Candidate>> getSkillsByOffer1(int idoffer) {
//		
//		Query q=  em.createQuery("SELECT s FROM Skill s INNER JOIN Offer o ON s.offer.offerId=o.offerId and s.offer.offerId =:noffer");
//		q.setParameter("noffer", idoffer);	
//		
//		
//
//		List<Skill> s = q.getResultList();
//		
//		List<Candidate> allcandidate = em.createQuery("SELECT x FROM Candidate x", Candidate.class).getResultList();
//		
//		System.out.println(allcandidate);
//		
//		Map<Integer , List<Candidate>> hm = new HashMap<Integer , List<Candidate>>();
//		
//		for (Candidate allc : allcandidate) {
//			int x = 0;
//			for (Skill skills : s) {
//				List<Candidate> bestCandidate = new ArrayList<Candidate>();
//				System.out.println(allc.getFirstName());
//				//System.out.println(allc.getSkills());
//				
//					if (allc.getCandidateId() == skills.getCandidate().getCandidateId()) {
//						x++;}
//					if (x!=0) {
//						bestCandidate.add(allc);
//						hm.put(x,bestCandidate);
//					}
//					
//				
//			}
//		}
//		
//		
//		
//		
//		return hm;
//
//	}
//	
	

}
