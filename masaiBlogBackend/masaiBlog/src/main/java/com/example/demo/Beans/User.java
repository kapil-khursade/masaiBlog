package com.example.demo.Beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.websocket.OnMessage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	@NonNull
	@Size(min=3, max=25, message="First Name Must Be 3 To 25 Characters")
	private String firstName;
	@NonNull
	@Size(min=3, max=25, message="Last Name Must Be 3 To 25 Characters")
	private String lastName;
	@NonNull
	@Email
	private String email;
	@Min(12)
	private int age;
	@Size(min=10, max=10, message="Mobile Number Must Be 10 Digits Only")
	private String mobile;
	private String gender;
	@Column(unique = true)
	@NonNull
	private String username;
	@Column(unique = true)
	@NonNull
	@Size(min=8, max=12, message="Password Must Be 8 To 10 Characters Only")
	private String password;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Blog> blogs = new ArrayList<Blog>();
}
