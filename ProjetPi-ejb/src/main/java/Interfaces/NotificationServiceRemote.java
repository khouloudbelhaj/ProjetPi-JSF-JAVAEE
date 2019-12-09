package Interfaces;

import java.util.List;

import javax.ejb.Remote;

import model.Message;
import model.Notification;
import model.User;

@Remote
public interface NotificationServiceRemote {
	public void addNotif(User s,User r);
	public void BecomeFriend(Notification notif);
	public List<Notification> getNotifsById(int rec);
	public List<Notification> getNotifsByIds(int sen,int rec);

}
