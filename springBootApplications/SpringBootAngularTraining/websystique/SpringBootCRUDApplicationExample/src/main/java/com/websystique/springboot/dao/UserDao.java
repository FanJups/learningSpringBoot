package com.websystique.springboot.dao;
 
import java.util.List;
 
import com.websystique.springboot.model.User;  
 
public interface UserDao {
	public List<User> getAllUsers() ; 
 
	public User getUser(Integer id) ;
 
	public User addUser(User user);
 
	public void updateUser(User user) ;
 
	public void deleteUser(Integer id) ;

	public void deleteAllUsers();

	public boolean isUserExist(User user);
}