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
//import interfaces.MessageServiceRemote;
//import model.Message;
//
//@Stateless
//@LocalBean
//public class MessageService implements MessageServiceRemote{
//
//	@PersistenceContext
//	EntityManager em;
//	@Override
//	public void addMessage(Message message) {
//		message.setDateSend(new Date());
//		em.persist(message);
//		
//	}
//
//	@Override
//	public void updateMessage(Message me) {
//		Query query=em.createQuery("update Message m set m.content=:content,m.dateSend=:date where m.messageId=:id");
//		query.setParameter("content", me.getContent());
//		query.setParameter("date", new Date());
//		query.setParameter("id", me.getMessageId());
//		query.executeUpdate();
//		//em.merge(me);
//		
//	}
//
//	@Override
//	public void deleteMessage(int id) {
//		/*Query query=em.createQuery("delete m from Messages m where m.MessageId=:id");
//		query.setParameter("id", id);
//		
//		query.executeUpdate();*/
//		Message m=em.find(Message.class, id);
//		em.remove(m);
//		
//	}
//
//	@Override
//	public List<Message> getMessagesByIds(int iduser, int idother) {
//		TypedQuery<Message> query=em.createQuery("select distinct m from Message m where m.userId=:iduser and m.destination=:idother or m.userId=:idother and m.destination=:iduser",Message.class);
//		query.setParameter("iduser",iduser);
//		query.setParameter("idother",idother);
//		
//		return query.getResultList();
//	}
//
//}
