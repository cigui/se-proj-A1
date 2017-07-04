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
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public void delete(User user) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void update(User user) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public User getUserById(int id) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public User getUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public boolean isAdmin(User user) {
		// TODO 自动生成的方法存根
		return false;
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
	public boolean register(String nickname, String email, String password) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean dupEmail(String email, User user) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean uploadImage() {
		// TODO 自动生成的方法存根
		return false;
	}
	
}