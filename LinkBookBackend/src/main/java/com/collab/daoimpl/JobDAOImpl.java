package com.collab.daoimpl;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collab.dao.JobDAO;
import com.collab.model.Job;

@Repository("jobDAO")
@Transactional
public class JobDAOImpl implements JobDAO 
{
    @Autowired
    SessionFactory sessionFactory;
    
    
	@Override
	public boolean addJobDetail(Job job) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(job);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception occured: Adding Job"+e);
			return false;
		}

	}

	@Override
	public boolean updateJobDetail(Job job) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(job);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception occured:updating Job"+e);
			return false;
		}
	}

	@Override
	public boolean deleteJobDetail(Job job) 
	{
		try
		{
			sessionFactory.getCurrentSession().remove(job);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception occured: Deleting Job"+e);
			return false;
		}
	}

	@Override
	public Job getJob(int jobId) 
	{
        Session session=sessionFactory.openSession();
        Job job=session.get(Job.class, jobId);
        session.close();
        return job;

	}

	@Override
	public List<Job> getAllJobs() 
	{
        Session session=sessionFactory.openSession();
        Query query=session.createQuery("from Job");
        List<Job> listJob=query.list();
        session.close();
        return listJob;

	}

}
