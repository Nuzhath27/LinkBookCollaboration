package com.collab.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collab.dao.UserDAO;
import com.collab.model.UserDetail;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO
{

	@Autowired
	SessionFactory sessionFactory;
	
	
	@Override
	public boolean registerUser(UserDetail user) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception occured adding User"+e);
			return false;
		}
	}

	@Override
	public boolean updateUserDetail(UserDetail user) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception occured updating User"+e);
			return false;
		}
	}

	@Override
	public UserDetail getUser(String username) 
	{
		Session session=sessionFactory.openSession();
		UserDetail user=session.get(UserDetail.class,username);
		session.close();
		return user;
	}

	@Override
	public boolean makeOffline(UserDetail user) 
	{
		try
		{
			user.setIsOnline("Off");
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception occured to makeOffline"+e);
			return false;
		}
	}

	@Override
	public boolean makeOnline(UserDetail user) 
	{
		try
		{
			user.setIsOnline("On");
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception occured to makeOnline"+e);
			return false;
		}
	}

	@Override
	public boolean approveUser(UserDetail user) 
	{
		try
		{
			user.setStatus("A");
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception occured: Approve User"+e);
			return false;
		}
	}

	@Override
	public boolean rejectUser(UserDetail user) 
	{
		try
		{
			user.setStatus("R");
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception occured:Reject User"+e);
			return false;
		}
	}

}
