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

import com.collab.dao.ForumCommentDAO;
import com.collab.model.Blog;
import com.collab.model.BlogComment;
import com.collab.model.ForumComment;


@RestController
public class ForumCommentController 

{
    @Autowired
    ForumCommentDAO forumCommentDAO;
    
	
	@PostMapping(value="/addForumComment")
    public ResponseEntity<String> addForumComment(@RequestBody ForumComment comment)
    {
    	comment.setCommentDate(new java.util.Date());
    	if(forumCommentDAO.addForumComment(comment))
    	{
    		return new ResponseEntity<String>("Successful",HttpStatus.OK);
    	}
    	else
    	{
    	
    		return new ResponseEntity<String>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
	
	@GetMapping(value="/deleteForumComment/{commentId}")
    public ResponseEntity<String> deleteForumComment(@PathVariable("commentId")int commentId)
    {
    	ForumComment forumComment=forumCommentDAO.getForumComment(commentId);
    	
    	if(forumCommentDAO.deleteForumComment(forumComment))
    	{
    		return new ResponseEntity<String>("Successful",HttpStatus.OK);
    	}
    	else
    	{
    	
    		return new ResponseEntity<String>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    	
    }
	
	@GetMapping(value="/getForumComments/{forumId}")
    public ResponseEntity<List<ForumComment>> getForumComments(@PathVariable ("forumId") int forumId)
    {
    	List<ForumComment> listForumComments=forumCommentDAO.listForumComment(forumId);
    	
    	if(listForumComments.size()>0)
    	{
    		return new ResponseEntity<List<ForumComment>>(listForumComments,HttpStatus.OK);
       	}
    	else
    	{
    		return new ResponseEntity<List<ForumComment>>(listForumComments,HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
	
	@GetMapping(value="/getForumComment/{commentId}")
    public ResponseEntity<ForumComment> getForumComment(@PathVariable("commentId")int commentId)
    {
    	ForumComment forumComment=forumCommentDAO.getForumComment(commentId);
    	
    	if(forumComment!=null)
    	{
    		return new ResponseEntity<ForumComment>(forumComment,HttpStatus.OK);
    	}
    	else
    	{
    		return new ResponseEntity<ForumComment>(forumComment,HttpStatus.INTERNAL_SERVER_ERROR);
    	}
}
}
