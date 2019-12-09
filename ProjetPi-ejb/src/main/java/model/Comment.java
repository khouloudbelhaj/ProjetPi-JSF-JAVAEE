package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="Comments")
@NamedQuery(name="Comment.findAll", query="SELECT c FROM Comment c")
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="CommentId")
	private int commentId;

	@Column(name="Content")
	private String content;

	@Column(name="NbrLikes")
	private int nbrLikes;

	@Column(name="CommentDate")
	private Date commentDate;


	@Column(name="UserId")
	private int userId;
	
	@Column(name="PostId")
	private int postId;

	public Comment() {
	}
	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getNbrLikes() {
		return nbrLikes;
	}

	public void setNbrLikes(int nbrLikes) {
		this.nbrLikes = nbrLikes;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}


}
