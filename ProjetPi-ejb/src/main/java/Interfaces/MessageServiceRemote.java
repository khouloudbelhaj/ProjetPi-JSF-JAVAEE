package Interfaces;

import java.util.List;

import javax.ejb.Remote;

import model.Message;

@Remote
public interface MessageServiceRemote {
	public void addMessage(Message message);
	public void deleteMessage(int id);
	public List<Message> getMessagesByIds(int iduser,int idother);
	public void updateMessage(Message me);
}
