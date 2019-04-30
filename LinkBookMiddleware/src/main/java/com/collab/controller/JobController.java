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

import com.collab.dao.JobDAO;
import com.collab.model.Blog;
import com.collab.model.Job;

@RestController
public class JobController 
{
	@Autowired
    JobDAO jobDAO;
	
	@PostMapping(value="/addJob")
	public ResponseEntity<String> addJobDetail(@RequestBody Job job)
	{
		if(jobDAO.addJobDetail(job))
		{
			return new ResponseEntity<String>("Successful",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
	
	    @PostMapping(value="/updateJob")
		public ResponseEntity<String> updateJobDetail(@RequestBody Job job)
		{
			if(jobDAO.updateJobDetail(job))
			{
				return new ResponseEntity<String>("Successful",HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<String>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}
		
	    @GetMapping(value="/deleteJob/{jobId}")
	    public ResponseEntity<String> deleteJobDetail(@PathVariable("jobId")int jobId)
	    {
	    	Job job=jobDAO.getJob(jobId);
	    	
	    	if(jobDAO.deleteJobDetail(job))
	    	{
	    		return new ResponseEntity<String>("Successful",HttpStatus.OK);
	    	}
	    	else
	    	{
	    	
	    		return new ResponseEntity<String>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
	    	}
	    	
	   }
	    
	    @GetMapping(value="/getJob/{jobId}")
	    public ResponseEntity<Job> getJob(@PathVariable("jobId")int jobId)
	    {
	    	Job job=jobDAO.getJob(jobId);
	    	
	    	if(job!=null)
	    	{
	    		return new ResponseEntity<Job>(job,HttpStatus.OK);
	    	}
	    	else
	    	{
	    		return new ResponseEntity<Job>(job,HttpStatus.INTERNAL_SERVER_ERROR);
	    	}
	    	
	   }
	    
	    @GetMapping(value="/getJobDetails")
	    public ResponseEntity<List<Job>> getJobDetails()
	    {
	    	List<Job> listJobs=jobDAO.getAllJobs();
	    	
	    	if(listJobs.size()>0)
	    	{
	    		return new ResponseEntity<List<Job>>(listJobs,HttpStatus.OK);
	       	}
	    	else
	    	{
	    		return new ResponseEntity<List<Job>>(listJobs,HttpStatus.INTERNAL_SERVER_ERROR);
	    	}
	    }
	    
	    
}
