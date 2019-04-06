package com.websystique.springboot.dao;


import java.util.*;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
 
import com.websystique.springboot.model.User; 
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{
 
	@Autowired
	private SessionFactory sessionFactory;
 
	public void setSessionFactory(SessionFactory sf) { 
		this.sessionFactory = sf;
	}
 
	public List<User> getAllUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User>  userList = session.createQuery("from User").list();
		return userList;
	}
 
	public User getUser(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, id);
		return user;
	}
 
	public User addUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(user);
		return user;
	}
 
	public void updateUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(user);
	}
 
	public void deleteUser(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		User p = (User) session.load(User.class, id);
		if (null != p) {
			session.delete(p);
		}
	} 
	public void deleteAllUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		
		session.createQuery("delete from User").executeUpdate();

	} 

	public boolean isUserExist(User user)
	{
		
		Predicate<User> equalsName = u -> u.getName().equals(user.getName());

		List<User> listEqualsName = getAllUsers().stream().parallel().filter(equalsName).collect(Collectors.toList());

		if(listEqualsName.size()>0)
			return true;
		else
			return false;


	}
}