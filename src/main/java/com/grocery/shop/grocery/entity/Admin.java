package com.grocery.shop.grocery.entity;


import java.util.Date;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "admin")
public class Admin {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private Long id;
	
	@NotNull(message = "Name is required.")
	@Column(name = "name", nullable = false)
    private String name;
	
	@NotNull(message = "Email is required.")
	@Size(min = 11, max = 100, message = "Email must be between 11 and 100 characters.")
	@Column(name = "email", nullable = false, unique = true)
    private String email;
	
	@NotNull(message = "Password is required.")
	@Column(name = "password", nullable = false)
    private String password;

	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "added_date", nullable = false)
    private Date createDate;

	public Admin() {
	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}