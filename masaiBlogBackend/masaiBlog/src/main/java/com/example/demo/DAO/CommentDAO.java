package com.example.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Beans.Comments;

public interface CommentDAO extends JpaRepository<Comments, Integer>{

}
