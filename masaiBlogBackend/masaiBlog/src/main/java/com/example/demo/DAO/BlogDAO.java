package com.example.demo.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Beans.Blog;

public interface BlogDAO extends JpaRepository<Blog, Integer>{

	public List<Blog> findByCategory(String category);
}
