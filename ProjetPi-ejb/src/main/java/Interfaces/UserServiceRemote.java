package Interfaces;

import java.util.*;

import javax.ejb.Remote;

import model.User;

@Remote

public interface UserServiceRemote {
	
	public int registerE(User e);
	public void activate(int id);
	public List<User> getAllUsers();
	public User findUserById(int id) ;
	public void updateUser(User e);
	public void deleteUser(int idUser);
	//public User getUserByEmailAndPassword(String email, String password);
	public User getUserByEmailOrUsernameAndPassword(String email, String password,String username);
	public List<User> getNotActivatedUsers();
	public void affectUserCompany(User e);
	public User getUserByEmailandUsername(String email,String username);
	public void updatePassword(User user,String newpw);
}
