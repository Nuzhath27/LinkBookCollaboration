package com.collab.testcases;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collab.dao.BlogCommentDAO;
import com.collab.model.Blog;
import com.collab.model.BlogComment;


public class BlogCommentDAOTestCase 
{

    static BlogCommentDAO blogCommentDAO;
	
	@BeforeClass
	public static void initialize()
	{
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.collab");
		
		context.refresh();
		
		blogCommentDAO=(BlogCommentDAO)context.getBean("blogCommentDAO");
	}
	
	@Ignore
	@Test
	public void addBlogCommentTest()
	{
		BlogComment comment=new BlogComment();
		
		comment.setBlogId(952);
		comment.setCommentText("Nice Blog");
		comment.setCommentDate(new java.util.Date());
		comment.setUsername("Kapil");
		
		assertTrue("Problem in adding the comment",blogCommentDAO.addBlogComment(comment));
		
		
	}
	
	
	@Test
	public void deleteBlogTest()
	{
		BlogComment comment=blogCommentDAO.getBlogComment(955);
		
		assertTrue("problem in deleting the blog",blogCommentDAO.deleteBlogComment(comment));
	}
	
}
