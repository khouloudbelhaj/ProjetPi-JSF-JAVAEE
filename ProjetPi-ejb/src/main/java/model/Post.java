package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Posts database table.
 * 
 */
@Entity
@Table(name="Posts")
@NamedQuery(name="Post.findAll", query="SELECT p FROM Post p")
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PostId")
	private int postId;

	@Column(name="Content")
	private String content;

	@Column(name="NbrLikes")
	private int nbrLikes;

	@Column(name="PostDate")
	private String postDate;

	@Column(name="UrlImage")
	private String urlImage;

	@Column(name="UrlVideo")
	private String urlVideo;

	@Column(name="UserId")
	private int userId;

	public Post() {
	}

	public int getPostId() {
		return this.postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getNbrLikes() {
		return this.nbrLikes;
	}

	public void setNbrLikes(int nbrLikes) {
		this.nbrLikes = nbrLikes;
	}

	public String getPostDate() {
		return this.postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public String getUrlImage() {
		return this.urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public String getUrlVideo() {
		return this.urlVideo;
	}

	public void setUrlVideo(String urlVideo) {
		this.urlVideo = urlVideo;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}