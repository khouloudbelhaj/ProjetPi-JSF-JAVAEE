package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the Messages database table.
 * 
 */
@Entity
@Table(name="Messages")
@NamedQuery(name="Message.findAll", query="SELECT m FROM Message m")
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MessageId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int messageId;

	@Column(name="Content")
	private String content;

	@Column(name="DateSend")
	private Date dateSend;

	@Column(name="Destination")
	private int destination;

	@Column(name="UserId")
	private int userId;

	public Message() {
	}
	

	public Message(String content, Date dateSend, int destination, int userId) {
		super();
		this.content = content;
		this.dateSend = dateSend;
		this.destination = destination;
		this.userId = userId;
	}
	public Message(String content, Date dateSend, int destination, int userId, int messageId) {
		
		this.content = content;
		this.dateSend = dateSend;
		this.destination = destination;
		this.userId = userId;
		this.messageId=messageId;
	}
    

	public int getMessageId() {
		return this.messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDateSend() {
		return this.dateSend;
	}

	public void setDateSend(Date dateSend) {
		this.dateSend = dateSend;
	}

	public int getDestination() {
		return this.destination;
	}

	public void setDestination(int destination) {
		this.destination = destination;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}