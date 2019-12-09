package Service;

import java.util.*;

import javax.ejb.*;
import javax.persistence.*;
import javax.persistence.PersistenceContext;

import Interfaces.UserServiceRemote;
import Utilities.CryptPasswordMD5;
import model.*;


@Stateless
@LocalBean

public class UserService implements UserServiceRemote {
	
	//Mail mail;
	private CryptPasswordMD5 cryptPasswordMD5 = new CryptPasswordMD5();

	@PersistenceContext
	EntityManager em;
	
	@Override
	public int registerE(User e) {
		em.persist(e);
		e.setPassword(cryptPasswordMD5.cryptWithMD5(e.getPassword()));
		return e.getUserId();

	}
	
	@Override
	public void activate(int id) {
		User u = em.find(User.class, id);
		u.setActivated(true);
		em.persist(u);
	}

	@Override
	public User findUserById(int id) {
		User e = em.find(User.class, id);
		return e;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> u = em.createQuery("SELECT x FROM User x", User.class).getResultList();

		return u;
	}
	
	@Override
	public void updateUser(User e) { 
		User u = em.find(User.class, e.getUserId());
		u.setLastName(e.getLastName());
		u.setName(e.getName());
		u.setPassword(cryptPasswordMD5.cryptWithMD5(e.getPassword()));
		u.setEmail(e.getEmail());
		u.setRole(e.getRole());
		u.setIdCompany(e.getIdCompany());
		em.persist(u);

	}

	
	@Override
	public void affectUserCompany(User e) { 
		User u = em.find(User.class, e.getUserId());
		//u.setCompany(e.getCompany());
		u.setIdCompany(e.getIdCompany());
		em.persist(u);

	}
	
	
	@Override
	public void deleteUser(int idUser) {
		User u = em.find(User.class, idUser);
	
		em.remove(u);
	}
	
	

	@Override
	
	public User getUserByEmailOrUsernameAndPassword(String email, String password,String username) {
		TypedQuery<User> query = em.createQuery("select e from User e WHERE e.email=:email or e.username=:username and e.password=:password ", User.class); 
		query.setParameter("email", email); 
		query.setParameter("username", username); 
		query.setParameter("password", cryptPasswordMD5.cryptWithMD5(password)); 
		User user = null; 
		try {
			user = query.getSingleResult(); 
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		return user;
	}
	
	

	@Override
	
	public User getUserByEmailandUsername(String email,String username) {
		TypedQuery<User> query = em.createQuery("select e from User e WHERE e.email=:email and e.username=:username ", User.class); 
		query.setParameter("email", email); 
		query.setParameter("username", username); 
		
		User user = null; 
		try {
			user = query.getSingleResult(); 
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		return user;
	}
	
	
	
public void updatePassword(User user,String newpw) { 
	User u  = em.find(User.class, user.getUserId()); 

	u.setPassword(cryptPasswordMD5.cryptWithMD5(newpw));

}
	
	@Override
	public List<User> getNotActivatedUsers() {
		List<User> u = em.createQuery("SELECT x FROM User x where x.activated=FALSE", User.class).getResultList();

		return u;
	}
}
