//package Service;
//
//import java.util.Date;
//import java.util.List;
//
//import javax.ejb.LocalBean;
//import javax.ejb.Stateless;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
//import javax.persistence.TypedQuery;
//
//import interfaces.NotificationServiceRemote;
//import model.Message;
//import model.Notification;
//import model.User;
//
//@Stateless
//@LocalBean
//public class NotificationService implements NotificationServiceRemote{
//	@PersistenceContext
//	EntityManager em;
//
//	@Override
//	public void addNotif(User s,User r) {
//		Notification notif=new Notification();
//		notif.setDateNotification(new Date());
//		notif.setSender(s.getUserId());
//		notif.setReceiver(r.getUserId());
//		notif.setContent(s.getUsername()+"would like to contact you");
//		notif.setTypeNotification("unaccepted");
//		em.persist(notif);
//		
//	}
//
//	@Override
//	public void BecomeFriend(Notification notif) {
//		Query query=em.createQuery("update Notification m set m.typeNotification=:content where m.notificationId=:id");
//		query.setParameter("content", "accepted");
//		query.setParameter("id", notif.getNotificationId());
//		query.executeUpdate();
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public List<Notification> getNotifsById(int rec) {
//		TypedQuery<Notification> query=em.createQuery("select distinct m from Notification m where m.sender=:iduser",Notification.class);
//		query.setParameter("iduser",rec);
//		
//		return query.getResultList();
//	}
//
//	@Override
//	public List<Notification> getNotifsByIds(int sen, int rec) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}
