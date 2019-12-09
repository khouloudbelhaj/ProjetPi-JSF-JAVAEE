package Interfaces;

import java.util.List;
import java.util.Map;

import javax.ejb.Remote;

import model.Candidate;
import model.Offer;
import model.Skill;

@Remote
public interface OfferServiceRemote {

	public List<Offer> getAllOffers();
	public List<Offer> getOffersByUser();
	public List<Offer> getOffersNotValidated() ;
	public void AcceptOffer(int id);
	public void ReffuseOffer(Offer o);
	public void ReffuseMotifOffer(Offer o);
	public Map<Integer , List<Candidate>> getSkillsByOffer(int idoffer);
	public List<Offer> getOfferAccepted();
	public List<Offer> getOffersRefused();
	public List<Candidate> getSkillsByOffer2(int idoffer);
	
}
