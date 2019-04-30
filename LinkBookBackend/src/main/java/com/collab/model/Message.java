package com.collab.model;

public class Message 
{
	private int id;
	private String message;
	
	//Getter and Setter Methods
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	//Default Constructor
	public Message() {}
	
	//Overloaded Constructor
	public Message(int id,String message)
	{
		this.id=id;
		this.message=message;
	}	
}

