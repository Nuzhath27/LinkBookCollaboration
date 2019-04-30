package com.collab.dao;

import com.collab.model.ProfilePicture;

public interface ProfilePictureDAO 
{
	public void save(ProfilePicture profilePicture);
	public ProfilePicture getProfilePicture(String username);
}