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

	@Override
	public Integer save(User user) {
		return userDao.save(user);
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
		
	}

	@Override
	public void update(User user) {
		userDao.update(user);
		
	}

	@Override
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

	@Override
	public User getUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public boolean isAdmin(User user) {
		//int of admin setted 2
		if(user.getRole() == 2){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
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



	@Override
	public boolean dupEmail(String email, User user) {
		if(getUserByEmail(email) != null){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean uploadImage() {
		// TODO with mongoDB
		return false;
	}

	@Override
	public boolean register(User user) {
		if(getUserByEmail(user.getEmail()) != null){
			return false;
		}
		//save check undone
		save(user);
		return true;
	}
	
}