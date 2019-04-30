package com.collab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.collab.dao.BlogCommentDAO;
import com.collab.model.BlogComment;

@RestController
public class BlogCommentController
{
	
	@Autowired
	BlogCommentDAO blogCommentDAO;
	
	
	@PostMapping(value="/addBlogComment")
	public ResponseEntity<String> addBlogComment(@RequestBody BlogComment comment)
	{
	    comment.setCommentDate(new java.util.Date());
    	if(blogCommentDAO.addBlogComment(comment))
    	{
    		return new ResponseEntity<String>("Successful",HttpStatus.OK);
    	}
    	else
    	{
    	
    		return new ResponseEntity<String>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
	
	@GetMapping(value="/deleteBlogComment/{commentId}")
    public ResponseEntity<String> deleteBlogComment(@PathVariable("commentId")int commentId)
    {
    	BlogComment blogcomment=blogCommentDAO.getBlogComment(commentId);
    	
    	if(blogCommentDAO.deleteBlogComment(blogcomment))
    	{
    		return new ResponseEntity<String>("Successful",HttpStatus.OK);
    	}
    	else
    	{
    	
    		return new ResponseEntity<String>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    	
    	
    }
	
	@GetMapping(value="/getBlogComments/{blogId}")
    public ResponseEntity<List<BlogComment>> getBlogComments(@PathVariable ("blogId") int blogId)
    {
    	List<BlogComment> listBlogComments=blogCommentDAO.listBlogComments(blogId);
    	
    	if(listBlogComments.size()>0)
    	{
    		return new ResponseEntity<List<BlogComment>>(listBlogComments,HttpStatus.OK);
       	}
    	else
    	{
    		return new ResponseEntity<List<BlogComment>>(listBlogComments,HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
	
	@GetMapping(value="/getBlogComment/{commentId}")
    public ResponseEntity<BlogComment> getBlogComment(@PathVariable("commentId")int commentId)
    {
    	BlogComment blogComment=blogCommentDAO.getBlogComment(commentId);
    	
    	if(blogComment!=null)
    	{
    		return new ResponseEntity<BlogComment>(blogComment,HttpStatus.OK);
    	}
    	else
    	{
    		return new ResponseEntity<BlogComment>(blogComment,HttpStatus.INTERNAL_SERVER_ERROR);
    	}
}
}

