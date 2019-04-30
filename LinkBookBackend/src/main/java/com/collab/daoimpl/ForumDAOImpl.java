package com.collab.daoimpl;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collab.dao.ForumDAO;
import com.collab.model.Forum;

@Repository("forumDAO")
@Transactional
public class ForumDAOImpl implements ForumDAO 
{

	@Autowired
    SessionFactory sessionFactory;
	
	@Override
	public boolean addForum(Forum forum)
	{
		try
		{
			sessionFactory.getCurrentSession().save(forum);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception occured: Adding forum"+e);
	        return false;
		}
	}

	@Override
	public boolean deleteForum(Forum forum) 
	{
		try
		{
			sessionFactory.getCurrentSession().remove(forum);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception occured:Deleting Forum"+e);
	        return false;
		}
	}

	@Override
	public boolean updateForum(Forum forum) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(forum);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception occured: updating forum"+e);
	        return false;
		}
	}

	@Override
	public Forum getForum(int forumId) 
	{
		Session session=sessionFactory.openSession();
		Forum forum=session.get(Forum.class, forumId);
		session.close();
		return forum;
	}

	@Override
	public List<Forum> getAllForums() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Forum");
		@SuppressWarnings("unchecked")
		List<Forum> listForum=(List<Forum>)query.list();
		session.close();
		return listForum;
	}

	@Override
	public boolean approveForum(Forum forum) 
	{
		try
		{
			forum.setStatus("A");
			sessionFactory.getCurrentSession().update(forum);
			return true;			
		}
		catch(Exception e)
		{
			System.out.println("Exception occured:Approving Forum:"+e);
		    return false;
		}
	}

	@Override
	public boolean rejectForum(Forum forum) 
	{
		try
		{
			forum.setStatus("NA");
			sessionFactory.getCurrentSession().update(forum);
			return true;			
		}
		catch(Exception e)
		{
			System.out.println("Exception occured:Rejecting Forum:"+e);
		    return false;
		}
	}

}
