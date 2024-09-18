package com.movie.project.MovieTicket.entity;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;



@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customer_id;
	
	@Column(nullable = false)
	private String Name;
	@Column(nullable = false)
	private String Email;
	@Column(nullable = false)
	private String Password;
	
//	@OneToOne(cascade=CascadeType.ALL)
//    @JoinColumn(name="user_id")
//	 private User user;
	
	
	public Customer(Long customer_id, String name, String email, String password) {
		super();
		this.customer_id = customer_id;
		Name = name;
		Email = email;
		Password = password;
	}
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
//	public User getUser() {
//		return user;
//	}
//	public void setUser(User user) {
//		this.user = user;
//	}
	public Long getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
}

