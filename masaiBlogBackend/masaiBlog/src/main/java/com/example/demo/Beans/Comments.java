package com.example.demo.Beans;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer commentId;
	private String comment;
	private LocalDateTime timestamp;
	
	@ManyToOne
	@JsonIgnore
	private Blog blog;
}
