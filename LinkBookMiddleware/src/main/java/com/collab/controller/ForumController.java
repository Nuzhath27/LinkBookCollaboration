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

import com.collab.dao.ForumDAO;
import com.collab.model.Blog;
import com.collab.model.Forum;

@RestController
public class ForumController 
{
	@Autowired
	ForumDAO forumDAO;
	
	@PostMapping(value="/addForum")
    public ResponseEntity<String> addForum(@RequestBody Forum forum)
    {
    	forum.setCreateDate(new java.util.Date());
    	if(forumDAO.addForum(forum))
    	{
    		return new ResponseEntity<String>("Successful",HttpStatus.OK);
    	}
    	else
    	{
    	
    		return new ResponseEntity<String>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
	
	@PostMapping(value="/updateForum")
    public ResponseEntity<String> updateForum(@RequestBody Forum forum)
    {
    	forum.setCreateDate(new java.util.Date());
    	if(forumDAO.updateForum(forum))
    	{
    		return new ResponseEntity<String>("Successful",HttpStatus.OK);
    	}
    	else
    	{
    	
    		return new ResponseEntity<String>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
	
	
	@GetMapping(value="/deleteForum/{forumId}")
    public ResponseEntity<String> deleteForum(@PathVariable("forumId")int forumId)
    {
    	Forum forum=forumDAO.getForum(forumId);
    	
    	if(forumDAO.deleteForum(forum))
    	{
    		return new ResponseEntity<String>("Successful",HttpStatus.OK);
    	}
    	else
    	{
    	
    		return new ResponseEntity<String>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    	
    	
    }
	
	@GetMapping(value="/approveForum/{forumId}")
    public ResponseEntity<String> approveForum(@PathVariable("forumId")int forumId)
    {
		Forum forum=forumDAO.getForum(forumId);
    	
		if(forumDAO.approveForum(forum))
    	{
    		return new ResponseEntity<String>("Successful",HttpStatus.OK);
    	}
    	else
    	{
    	
    		return new ResponseEntity<String>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
    
    @GetMapping(value="/rejectForum/{forumId}")
    public ResponseEntity<String> rejectForum(@PathVariable("forumId")int forumId)
    {
    	Forum forum=forumDAO.getForum(forumId);
    	
    	if(forumDAO.rejectForum(forum))
    	{
    		return new ResponseEntity<String>("Successful",HttpStatus.OK);
    	}
    	else
    	{
    	    return new ResponseEntity<String>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
    
    @GetMapping(value="/getForum/{forumId}")
    public ResponseEntity<Forum> getForum(@PathVariable("forumId")int forumId)
    {
    	Forum forum=forumDAO.getForum(forumId);
    	
    	if(forum!=null)
    	{
    		return new ResponseEntity<Forum>(forum,HttpStatus.OK);
    	}
    	else
    	{
    		return new ResponseEntity<Forum>(forum,HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    	
    	
    }
    
    @GetMapping(value="/getForumDetails")
    public ResponseEntity<List<Forum>> getForumDetails()
    {
    	List<Forum> listForums=forumDAO.getAllForums();
    	
    	if(listForums.size()>0)
    	{
    		return new ResponseEntity<List<Forum>>(listForums,HttpStatus.OK);
       	}
    	else
    	{
    		return new ResponseEntity<List<Forum>>(listForums,HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
}
