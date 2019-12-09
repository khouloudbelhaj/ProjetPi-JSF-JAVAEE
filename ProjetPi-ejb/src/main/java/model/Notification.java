package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the Notifications database table.
 * 
 */
@Entity
@Table(name="Notifications")
@NamedQuery(name="Notification.findAll", query="SELECT n FROM Notification n")
public class Notification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NotificationId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int notificationId;

	@Column(name="Content")
	private String content;

	@Column(name="DateNotification")
	private Date dateNotification;

	@Column(name="Receiver")
	private int receiver;

	@Column(name="Sender")
	private int sender;

	@Column(name="TypeNotification")
	private String typeNotification;

	public Notification() {
	}

	public Notification(int notificationId, String content, Date dateNotification, int receiver, int sender,
			String typeNotification) {
		super();
		this.notificationId = notificationId;
		this.content = content;
		this.dateNotification = dateNotification;
		this.receiver = receiver;
		this.sender = sender;
		this.typeNotification = typeNotification;
	}

	public int getNotificationId() {
		return this.notificationId;
	}

	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDateNotification() {
		return this.dateNotification;
	}

	public void setDateNotification(Date dateNotification) {
		this.dateNotification = dateNotification;
	}

	public int getReceiver() {
		return this.receiver;
	}

	public void setReceiver(int receiver) {
		this.receiver = receiver;
	}

	public int getSender() {
		return this.sender;
	}

	public void setSender(int sender) {
		this.sender = sender;
	}

	public String getTypeNotification() {
		return this.typeNotification;
	}

	public void setTypeNotification(String typeNotification) {
		this.typeNotification = typeNotification;
	}

}