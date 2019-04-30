package com.collab.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collab.dao.BlogCommentDAO;
import com.collab.model.Blog;
import com.collab.model.BlogComment;

@Repository("blogCommentDAO")
@Transactional
public class BlogCommentDAOImpl implements BlogCommentDAO

{

	@Autowired
	SessionFactory sessionFactory;
	
	
	@Override
	public boolean addBlogComment(BlogComment comment) 
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
	public boolean deleteBlogComment(BlogComment comment) 
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
	public List<BlogComment> listBlogComments(int blogId) 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from BlogComment where blogId=:myBlogId");
		query.setParameter("myBlogId",blogId);
		List<BlogComment> listComment=query.list();
		session.close();
		return listComment;
	}

	@Override
	public BlogComment getBlogComment(int commentId) 
	{
		Session session=sessionFactory.openSession();
		BlogComment comment=session.get(BlogComment.class, commentId);
		session.close();
		return comment;
	}

}
