package com.websystique.springboot.service;
 
import java.util.List;
 
import javax.transaction.Transactional;
 
import com.websystique.springboot.dao.UserDao;
import com.websystique.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
 
 
@Service("userService")
public class UserService {
 
	@Autowired
	UserDao userDao;
 
	@Transactional
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}
 
	@Transactional
	public User getUser(Integer id) {
		return userDao.getUser(id); 
	}
 
	@Transactional
	public User addUser(User user) {
		
		return userDao.addUser(user);
	}
 
	@Transactional
	public User updateUser(User user) {
		userDao.updateUser(user);
		return user;
	}
 
	@Transactional
	public void deleteUser(Integer id) {
		userDao.deleteUser(id);
	}

	@Transactional
	public void deleteAllUsers() {
		userDao.deleteAllUsers();
	}

	@Transactional
	public boolean isUserExist(User user) {
		return userDao.isUserExist(user); 
	}
}