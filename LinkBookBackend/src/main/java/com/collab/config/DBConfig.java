package com.collab.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.collab.model.Blog;
import com.collab.model.BlogComment;
import com.collab.model.Forum;
import com.collab.model.ForumComment;
import com.collab.model.Friend;
import com.collab.model.Job;
import com.collab.model.ProfilePicture;
import com.collab.model.UserDetail;

@Configuration
@ComponentScan("com.collab")
@EnableTransactionManagement
public class DBConfig 
{
	
	public DataSource getDataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("collab");
		dataSource.setPassword("pass123");
		System.out.println("--DataSource object Created-----");
		return dataSource;
	}
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		Properties hibernateProp=new Properties();
		hibernateProp.put("hibernate.hbmddl2.auto","update");
		hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
		
		LocalSessionFactoryBuilder factoryBuilder=new LocalSessionFactoryBuilder(getDataSource());
		factoryBuilder.addProperties(hibernateProp);
		
		factoryBuilder.addAnnotatedClass(Blog.class);
		factoryBuilder.addAnnotatedClass(UserDetail.class);
		factoryBuilder.addAnnotatedClass(Job.class);
		factoryBuilder.addAnnotatedClass(BlogComment.class);
		factoryBuilder.addAnnotatedClass(Forum.class);
		factoryBuilder.addAnnotatedClass(ForumComment.class);
		factoryBuilder.addAnnotatedClass(Friend.class);
		factoryBuilder.addAnnotatedClass(ProfilePicture.class);
		
		SessionFactory sessionFactory=factoryBuilder.buildSessionFactory();
		System.out.println("--SessionFactory Object Created -----");
		return sessionFactory;
	}
	
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("--TranactionManager object Created -----");
		return new HibernateTransactionManager(sessionFactory);
	}

}
