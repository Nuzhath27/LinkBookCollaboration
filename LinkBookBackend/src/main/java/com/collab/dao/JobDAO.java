package com.collab.dao;

import java.util.List;

import com.collab.model.Job;

public interface JobDAO 
{
	public boolean addJobDetail(Job job);
	public boolean updateJobDetail(Job job);
	public boolean deleteJobDetail(Job job);
	public Job getJob(int jobId);
	public List<Job> getAllJobs();
	
}
