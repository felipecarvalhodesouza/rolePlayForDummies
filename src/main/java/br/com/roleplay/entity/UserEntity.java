package br.com.roleplay.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
 
@Table(name="user")
@Entity	
@NamedQuery(name = "UserEntity.findUser",
		    query= "SELECT u FROM UserEntity u WHERE u.nickname = :nickname AND u.password = :password")
public class UserEntity implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue
	@Column(name="id")
	private String id;
 
	@Column(name="nickname")
	private String nickname;
 
	@Column(name="password")
	private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}