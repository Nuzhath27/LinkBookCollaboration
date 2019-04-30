package com.collab.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collab.dao.ForumCommentDAO;
import com.collab.model.ForumComment;

@Repository("forumCommentDAO")
@Transactional
public class ForumCommentDAOImpl implements ForumCommentDAO 
{

	@Autowired
	SessionFactory sessionFactory;
	
	
	@Override
	public boolean addForumComment(ForumComment comment) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(comment);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception arised: Adding the comment"+e);
			return false;
		}
	}

	@Override
	public boolean deleteForumComment(ForumComment comment) 
	{
		try
		{
			sessionFactory.getCurrentSession().remove(comment);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception arised: deleting the comment"+e);
			return false;
		}
	}

	@Override
	public List<ForumComment> listForumComment(int forumId) 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from ForumComment where forumId=:myForumId");
		query.setParameter("myForumId",forumId);
		List<ForumComment> listComment=query.list();
		session.close();
		return listComment;
	}

	@Override
	public ForumComment getForumComment(int commentId) 
	{
		Session session=sessionFactory.openSession();
		ForumComment comment=session.get(ForumComment.class, commentId);
		session.close();
		return comment;
	}

}
