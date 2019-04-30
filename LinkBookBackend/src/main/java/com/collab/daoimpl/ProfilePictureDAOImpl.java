package com.collab.daoimpl;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collab.dao.ProfilePictureDAO;
import com.collab.model.ProfilePicture;



@Repository("profilePictureDAO")
@Transactional
public class ProfilePictureDAOImpl implements ProfilePictureDAO 
{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void save(ProfilePicture profilePicture) 
	{
		System.out.println("I am in Save Method- Profile Picture");
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(profilePicture);
		session.flush();
		System.out.println("Image Saved to Database");
		
	}

	@Override
	public ProfilePicture getProfilePicture(String username) 
	{
		Session session=sessionFactory.openSession();
		ProfilePicture profilePicture=(ProfilePicture)session.get(ProfilePicture.class,username);
		return profilePicture;
	}

}

