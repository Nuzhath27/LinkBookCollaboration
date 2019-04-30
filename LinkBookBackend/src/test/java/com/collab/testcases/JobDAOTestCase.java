package com.collab.testcases;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collab.dao.JobDAO;
import com.collab.model.Blog;
import com.collab.model.Job;


public class JobDAOTestCase 
{

    static JobDAO jobDAO;
 	
	@BeforeClass
	public static void initialize()
	{
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.collab");
		
		context.refresh();
		
		jobDAO=(JobDAO)context.getBean("jobDAO");
	}
	
	@Ignore
	@Test
	public void addJobTestCase()
	{
		Job job=new Job();
		
		job.setDesignation("Software Developer");
		job.setJobDesc("CoreJava and JSP,Servlets");
		job.setQualification("BE or Btech");
		job.setStatus("P");
		job.setLastDate(new java.util.Date());
		
		assertTrue("Problem in Adding Job",jobDAO.addJobDetail(job));
		
	}
	
	@Ignore
	@Test
	public void updateJobTestCase()
	{
		Job job=jobDAO.getJob(952);
		
		job.setJobDesc("Tally and Computer Knowledge must");
		
		assertTrue("Problem in updating the Job",jobDAO.updateJobDetail(job));
	}

	@Ignore
	@Test
	public void deleteJobTestCase()
	{
		Job job=jobDAO.getJob(952);
				
		assertTrue("Problem in deleting the Job",jobDAO.deleteJobDetail(job));
	}
	
	@Ignore
	@Test
	public void listJobTest()
	{
			List<Job> listJobs=jobDAO.getAllJobs();
			
			assertTrue("Problem in Listing Job",listJobs.size()>0);
			
			for(Job job:listJobs)
			{
				System.out.print(job.getJobId()+"::");
				System.out.print(job.getDesignation()+":");
				System.out.print(job.getJobDesc());
				System.out.println(job.getStatus());				
			}
}
}
