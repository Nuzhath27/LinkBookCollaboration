package com.collab.dao;

import java.util.List;

import com.collab.model.ForumComment;

public interface ForumCommentDAO 
{
	public boolean addForumComment(ForumComment comment);
	public boolean deleteForumComment(ForumComment comment);
	public List<ForumComment> listForumComment(int forumId);
	public ForumComment getForumComment(int commentId);
}
