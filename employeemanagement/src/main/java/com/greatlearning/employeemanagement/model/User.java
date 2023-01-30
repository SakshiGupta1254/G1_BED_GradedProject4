//package com.greatlearning.employeemanagement.model;
//
//import java.util.HashSet;
//import java.util.Objects;
//import java.util.Set;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.Table;
//
//@Entity
//@Table(name="users")
//public class User {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "user_id")
//    private long id;
//	private String username;
//	private String password;
//    private String emailAddress;
//    
//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(
//	           name = "users_roles",
//	           joinColumns = @JoinColumn(name = "user_id"),
//	           inverseJoinColumns = @JoinColumn(name = "role_id")
//	           )
//    private Set<Role> roles = new HashSet<>();
//
//
//    public User(String username, String password, String emailAddress){
//        this.username = username;
//        this.password = password;
//        this.emailAddress = emailAddress;
//    }
//    
//    public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public String getEmailAddress() {
//		return emailAddress;
//	}
//
//	public void setEmailAddress(String emailAddress) {
//		this.emailAddress = emailAddress;
//	}
//
//	public long getId() {
//		return id;
//	}
//
//	public Set<Role> getRoles() {
//		return roles;
//	}
//
//	//scaffolding code
//    public void addRole(Role role) {
//    	this.roles.add(role);
//    	role.getUsers().add(this);
//    }
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(emailAddress, username);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		User other = (User) obj;
//		return Objects.equals(emailAddress, other.emailAddress) && Objects.equals(username, other.username);
//	}
//
//	@Override
//	public String toString() {
//		return "User [id=" + id + ", username=" + username + ", password=" + password + ", emailAddress=" + emailAddress
//				+ "]";
//	}
//}
package com.greatlearning.employeemanagement.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;


@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int id;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
	           name = "users_roles",
	           joinColumns = @JoinColumn(name = "user_id"),
	           inverseJoinColumns = @JoinColumn(name = "role_id")
	           )
	private List<Role> roles = new ArrayList<>();
	private String username;
	private String password;
	private String emailAddress;
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	//scaffolding code
	public void addRole(Role role) {
	 this.roles.add(role);
	 role.getUsers().add(this);
	 }
	public User(String username, String password, String emailAddress){
	this.username = username;
	this.password = password;
	this.emailAddress= emailAddress;
	}
}

