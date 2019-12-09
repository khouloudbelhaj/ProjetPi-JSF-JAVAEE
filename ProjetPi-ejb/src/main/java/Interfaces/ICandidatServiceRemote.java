package Interfaces;

import java.util.List;

import model.Candidate;

public interface ICandidatServiceRemote {

	void addCandidate(Candidate c);
	public List<Candidate> getCandidates(int id);
	public Object logIn(String username, String password);
	public void followCandidate(int followedId, int followerId);
	public void unfollowCandidate(int followedId, int followerId);
	public Object getCandidateById(int candidateId);
	public List<Candidate> searchCandidates(String criteria,int candidateId);
	public void applyForAJob(int offerId,int candidateId);
	public void cancelApplicaiton(int applicationId,int offerId,int candidateId);
	public void subscribe(int enterpriseId,int candidateId);
	public void unsubscribe(int enterpriseId,int candidateId);
}
