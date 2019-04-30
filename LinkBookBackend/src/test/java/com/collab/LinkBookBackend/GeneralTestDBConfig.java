package com.collab.LinkBookBackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GeneralTestDBConfig {

	public static void main(String[] args) 
	{

		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.collab");
		
		context.refresh();

	}

}
