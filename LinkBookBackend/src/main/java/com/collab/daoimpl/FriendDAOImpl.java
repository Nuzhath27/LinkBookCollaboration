package com.collab.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collab.dao.FriendDAO;
import com.collab.model.Friend;
import com.collab.model.UserDetail;

@Repository("friendDAO")
@Transactional
public class FriendDAOImpl implements FriendDAO
{

	@Autowired
    SessionFactory sessionFactory;

	@Override
	public List<Friend> showFriendList(String username) 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Friend where (username=:uname or friendusername=:frndusername) and status='A'");
		query.setParameter("uname",username);
		query.setParameter("frndusername",username);
		List<Friend> listFriends=(List<Friend>)query.list();
		session.close();
		return listFriends;
	}

	@Override
	public List<Friend> showPendingFriendRequest(String username) 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Friend where friendusername=:frndusername and status='P'");
		query.setParameter("uname",username);
		query.setParameter("frndusername",username);
		List<Friend> listFriends=(List<Friend>)query.list();
		session.close();
		return listFriends;
	}

	@Override
	public List<UserDetail> showSuggestedFriend(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean sendFriendRequest(Friend friend) 
	{
		try
		{
			friend.setStatus("P");
			sessionFactory.getCurrentSession().save(friend);
			return true;
		}
		catch(Exception e)
		{
		return false;
	}
	}

	@Override
	public boolean acceptFriendRequest(int friendId) 
	{
		try
		{
			Session session=sessionFactory.openSession();
			Friend friend=session.get(Friend.class,friendId);
			session.close();
			friend.setStatus("A");
			sessionFactory.getCurrentSession().update(friend);
			return true;
		}
		catch(Exception e)
		{
		return false;
	}
	}
	@Override
	public boolean deleteFriendRequest(int friendId) 
	{
		try
		{
			Session session=sessionFactory.openSession();
			Friend friend=session.get(Friend.class,friendId);
			session.close();
			friend.setStatus("A");
			sessionFactory.getCurrentSession().delete(friend);
			return true;
		}
		catch(Exception e)
		{
		return false;
	}
	}
	
}