package com.collab.testcases;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collab.dao.UserDAO;
import com.collab.model.UserDetail;

public class UserDAOTestCase 
{

	static UserDAO userDAO;
	
	@Ignore
	@BeforeClass
	public static void initialize()
	{
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.collab");
		
		context.refresh();
		
		userDAO=(UserDAO)context.getBean("userDAO");
	}
	
    
	@Test
	public void registerUserTestCase()
	{
		UserDetail user=new UserDetail();
		
		user.setCustomerName("Priya Kapoor");
		user.setUsername("Priya");
		user.setPassword("p333");
		user.setEmailId("Priya@gmail.com");
		user.setIsOnline("On");
		user.setRole("Student");
		user.setStatus("A");
		
		assertTrue("Problem in registering the User",userDAO.registerUser(user));
		
	}
	
    
	@Test
	public void updateUserDetailTest()
	{
		UserDetail user=userDAO.getUser("Arjun");
		
		user.setEmailId("arjun12@hotmail.com");
		
		assertTrue("Problem in updating the User",userDAO.updateUserDetail(user));
		
	}
    
    @Ignore
    @Test
    public void makeOfflineTest()
    {
    	UserDetail user=userDAO.getUser("Pooja");
    	
    	assertTrue("Problem in makeOffline",userDAO.makeOffline(user));
    	
    	
    }
    
    @Ignore
    @Test
    public void makeOnLineTest()
    {
    	UserDetail user=userDAO.getUser("Pooja");
    	
    	assertTrue("Problem in makeOnline",userDAO.makeOnline(user));
    	
    	
    }
    
    @Ignore
    @Test
    public void approveUserTestCase()
    {
    	UserDetail user=userDAO.getUser("Arjun");
    	
    	assertTrue("Problem in Approving User",userDAO.approveUser(user));
    	
    }
    
    
    @Test
    public void rejectUserTestCase()
    {
    	UserDetail user=userDAO.getUser("Arjun");
    	
    	assertTrue("Problem in rejecting User",userDAO.rejectUser(user));
    	
    }
	
	
}
