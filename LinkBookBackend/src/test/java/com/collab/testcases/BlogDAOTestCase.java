package com.collab.testcases;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collab.dao.BlogDAO;
import com.collab.model.Blog;

public class BlogDAOTestCase 
{
    static BlogDAO blogDAO;
	
	@BeforeClass
	public static void initialize() 
	{
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.collab");
		context.refresh();
		
		blogDAO=(BlogDAO)context.getBean("blogDAO");
	}
	
	@Ignore
	@Test
	public void addBlogTest()
	{
		Blog blog=new Blog();
		blog.setBlogName("Politics");
		blog.setBlogContent("Elections in India");
		blog.setCreateDate(new java.util.Date());
		blog.setLikes(0);
		blog.setDislikes(0);
		blog.setStatus("NA");
		blog.setUsername("Lalita");
		
		assertTrue("Problem in adding the Blog",blogDAO.addBlog(blog));
	}
	
	@Ignore
	@Test
	public void updateBlogTest()
	{
		Blog blog=blogDAO.getBlog(952);
		blog.setBlogContent("This blog is to discuss about life with technology");
		assertTrue("problem in updating the blog",blogDAO.updateBlog(blog));
	}
	
	@Ignore
	@Test
	public void deleteBlogTest()
	{
		Blog blog=blogDAO.getBlog(954);
		
		assertTrue("problem in deleting the blog",blogDAO.deleteBlog(blog));
	}
	
	@Ignore
	@Test
	public void listBlogTest()
	{
			List<Blog> listBlogs=blogDAO.getAllBlogs();
			
			assertTrue("Problem in Listing Blog",listBlogs.size()>0);
			
			for(Blog blog:listBlogs)
			{
				System.out.print(blog.getBlogId()+"\t");
				System.out.print(blog.getBlogName()+"\t");
				System.out.print(blog.getBlogContent()+"\t");
				System.out.println(blog.getStatus());				
			}
	}
	
	@Ignore
	@Test
	public void approveBlogTest()
	{
		Blog blog=blogDAO.getBlog(955);
		
		assertTrue("Problem in approving the blog",blogDAO.approveBlog(blog));
	}
	
	@Ignore
	@Test
	public void rejectBlogTest()
	{
		Blog blog=blogDAO.getBlog(956);
		
		assertTrue("Problem in rejecting the blog",blogDAO.rejectBlog(blog));
	}
	
	@Ignore
	@Test
	public void incrementLikesTest()
	{
		Blog blog=blogDAO.getBlog(952);
		
		assertTrue("Problem in increment likes of a blog",blogDAO.incrementLikes(blog));
	}
	
	@Test
	public void incrementDisLikesTest()
	{
		Blog blog=blogDAO.getBlog(952);
		
		assertTrue("Problem in increment Dislikes of a blog",blogDAO.incrementDisLikes(blog));
	}
}