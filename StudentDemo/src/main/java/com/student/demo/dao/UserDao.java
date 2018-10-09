package com.student.demo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.student.demo.pojo.User;

@Repository
public class UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public User getUserByUsernameAndPassword(String username,String password) {
		
	Session session = null;
   
	try {
		
		session = sessionFactory.openSession();
		
		Query query = session.createQuery("from User where username = :param1 and password = :param2");
		query.setParameter("param1", username);
		query.setParameter("param2", password);
		
		return (User) query.uniqueResult();
	
	}catch(Exception e) {
		return null;
		
	}finally {
		
		session.close();
		
	}

	
	}

	public List<User> findAllUsers() {
		
		Session session = null;
		   
		try {
			
			session = sessionFactory.openSession();
			
			Query query = session.createQuery("from User");
			
			return query.list();
		
		}catch(Exception e) {
			return null;
			
		}finally {
			
			session.close();
			
		}
		
		
	}

	public void saveUser(User user) {
		
		Session session = null;
		   
		try {
			
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			session.saveOrUpdate(user);
			
			session.getTransaction().commit();
			
		
		}catch(Exception e) {
			session.getTransaction().rollback();
			
		}finally {
			
			session.close();
			
		}
		
		
		
	}

	public User findUserById(Integer id) {
		
		Session session = null;
		   
		try {
			
			session = sessionFactory.openSession();
			
			
			User user = (User) session.get(User.class,id);
			
			return user;
			
		
		}catch(Exception e) {
			return null;
			
		}finally {
			
			session.close();
			
		}
		
		
	}

	
		
	}

