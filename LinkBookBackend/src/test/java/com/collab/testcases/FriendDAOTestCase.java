package com.collab.testcases;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collab.dao.FriendDAO;
import com.collab.model.Friend;
import com.collab.model.Job;


public class FriendDAOTestCase 
{

    static FriendDAO friendDAO;
 	
	@BeforeClass
	public static void initialize()
	{
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.collab");
		
		context.refresh();
		
		friendDAO=(FriendDAO)context.getBean("friendDAO");
	}
	
	@Ignore
	@Test
	public void sendFriendRequest()
	{ 
		Friend friend=new Friend();
		
		friend.setUsername("Priya");
		friend.setFriendusername("Pooja");
		
		assertTrue("Problem in sending friend request",friendDAO.sendFriendRequest(friend));
	}
	
	@Ignore
	@Test
	public void acceptFriendRequest()
	{
		
		assertTrue("Problem in accepting friend request",friendDAO.acceptFriendRequest(992));
	}
	
	@Ignore
	@Test
	public void deleteFriendRequest()
	{
		assertTrue("Problem in deleting friend request",friendDAO.deleteFriendRequest(994));
	}
	
	@Ignore
	@Test
	public void showFriendListTest()
	{
		List<Friend> friendList=friendDAO.showFriendList("Priya");
		assertTrue("Problem in Showing Friend List",friendList.size()>0);
		
		System.out.println("******FriendList******");
		
		for(Friend friend:friendList)
		{
			System.out.println(friend.getUsername()+"        ");
			System.out.println(friend.getFriendusername());
			
		}
	}
	
	@Ignore
	@Test
	public void showPendingFriendRequest()
	{
		List<Friend> friendList=friendDAO.showPendingFriendRequest("Priya");
		assertTrue("Problem in Showing pending Friend reuqest List",friendList.size()>0);
		
		System.out.println("******Pending FriendRequestList******");
		
		for(Friend friend:friendList)
		{
			System.out.println(friend.getUsername()+"        ");
			System.out.println(friend.getFriendusername());
			
		}
	}
}
