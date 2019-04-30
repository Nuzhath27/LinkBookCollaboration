package com.collab.testcases;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collab.dao.ForumCommentDAO;
import com.collab.model.BlogComment;
import com.collab.model.ForumComment;

public class ForumCommentDAOTestCase 
{

    static ForumCommentDAO forumCommentDAO;
	
	@BeforeClass
	public static void initialize()
	{
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.collab");
		
		context.refresh();
		
		forumCommentDAO=(ForumCommentDAO)context.getBean("forumCommentDAO");
	}
	
	
	@Test
	public void addForumCommentTest()
	{
		ForumComment comment=new ForumComment();
	
		comment.setForumId(952);
		comment.setCommentText("Interesting forum");
		comment.setCommentDate(new java.util.Date());
		comment.setUsername("chandra");
		
		assertTrue("Problem in adding the comment",forumCommentDAO.addForumComment(comment));
		
		
	}
	
	@Test
	public void deleteForumCommentTest()
	{
		ForumComment comment=forumCommentDAO.getForumComment(953);
		
		assertTrue("problem in deleting the forum comment",forumCommentDAO.deleteForumComment(comment));
	}

}
