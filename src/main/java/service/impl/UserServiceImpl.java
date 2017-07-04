package service.impl;

import java.util.List;

import dao.UserDao;
import model.User;
import service.UserService;

public class UserServiceImpl implements UserService{
	
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public Integer save(User user) {
		return null;
	}

	public void delete(User user) {
		
	}

	public void update(User user) {
		
	}

	public User getUserById(int id) {
		return null;
	}

	public User getUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}

	public List<User> getAllUsers() {
		return null;
	}

	public boolean isAdmin(User user) {
		return false;
	}

	public boolean login(String email, String password) {
		User u = userDao.getUserByEmail(email);
		if (u != null) {
			String TruePwd = u.getPassword();
			if (TruePwd.equals(password)) {
				return true;
			}
		}
		return false;
	}

	public boolean register(String nickname, String email, String password) {
		return false;
	}

	public boolean dupEmail(String email, User user) {
		return false;
	}

	public boolean uploadImage() {
		return false;
	}
	
}