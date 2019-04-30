package com.collab.testcases;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.collab.dao.ForumDAO;
import com.collab.model.Forum;

public class ForumDAOTestCase 
{

static ForumDAO forumDAO;
	
	@BeforeClass
	public static void initialize() 
	{
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.collab");
		context.refresh();
		
		forumDAO=(ForumDAO)context.getBean("forumDAO");
	}
	
	@Test
	public void addForumTestCase()
	{
		Forum forum=new Forum();
		
		forum.setForumName("politics");
		forum.setForumContent("Indian Elections");
		forum.setCreateDate(new java.util.Date());
		forum.setStatus("A");
		
		assertTrue("Problem in adding the Forum",forumDAO.addForum(forum));
				
	}
	
	@Test
	public void updateForumTest()
	{
		Forum forum=forumDAO.getForum(953);
		forum.setForumContent("This forum is regarding current 2019 elections");
		assertTrue("problem in updating the forum",forumDAO.updateForum(forum));
	}
	
	@Ignore
	@Test
	public void deleteForumTest()
	{
		Forum forum=forumDAO.getForum(952);
		
		assertTrue("problem in deleting the forum",forumDAO.deleteForum(forum));
	}
	
	@Ignore
	@Test
	public void listForumTest()
	{
			List<Forum> listForums=forumDAO.getAllForums();
			
			assertTrue("Problem in Listing Forum",listForums.size()>0);
			
			for(Forum forum:listForums)
			{
				System.out.print(forum.getForumId()+"\t");
				System.out.print(forum.getForumName()+"\t");
				System.out.print(forum.getForumContent()+"\t");
				System.out.println(forum.getStatus());				
			}

}
	@Ignore
	@Test
	public void approveForumTest()
	{
		Forum forum=forumDAO.getForum(953);
		
		assertTrue("Problem in approving the forum",forumDAO.approveForum(forum));
	}
	
	@Ignore
	@Test
	public void rejectForumTest()
	{
		Forum forum=forumDAO.getForum(953);
		
		assertTrue("Problem in rejecting the forum",forumDAO.rejectForum(forum));
	}
}
