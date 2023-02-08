package com.example.demo.Services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.Beans.Blog;
import com.example.demo.Beans.Comments;
import com.example.demo.Beans.Output;
import com.example.demo.Beans.User;
import com.example.demo.Exceptions.MasaiBlogException;

public interface MasaiBlogServices {

	public ResponseEntity<Output> registerUser(User user)throws MasaiBlogException;
	public ResponseEntity<User> loginUser(String username, String password)throws MasaiBlogException;
	public ResponseEntity<Output> publishBlog(Blog blog)throws MasaiBlogException;
	public ResponseEntity<Output> commentsOnOthersBlog(Integer userId,Integer blogId, Comments comment)throws MasaiBlogException;
	public ResponseEntity<List<Blog>> viewAllBlogs()throws MasaiBlogException;
	public ResponseEntity<List<Blog>> viewBlogsByCategory(String category)throws MasaiBlogException;
	public ResponseEntity<Output> deleteSlefBlog(Integer userId, Integer blogId)throws MasaiBlogException;
	public ResponseEntity<Output> deleteSlefBlogComment(Integer userId, Integer blogId, Integer commentId)throws MasaiBlogException;
}


