package service.impl;

import java.io.File;
import java.util.List;

<<<<<<< HEAD

=======
import dao.BookReleaseDao;
>>>>>>> f879bb089ae7ec98af7d7605fa27c63de735418a
import dao.UserDao;
import model.BookRelease;
import model.User;
import service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	private BookReleaseDao bookReleaseDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public BookReleaseDao getBookReleaseDao() {
		return bookReleaseDao;
	}

	public void setBookReleaseDao(BookReleaseDao bookReleaseDao) {
		this.bookReleaseDao = bookReleaseDao;
	}

	public Integer save(User user) {
		return userDao.save(user);
	}

	public void delete(User user) {
		userDao.delete(user);
	}

	public void update(User user) {
		userDao.update(user);
	}

	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

	public User getUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}

	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	public boolean isAdmin(User user) {
		// int of admin setted 2
		if (user.getRole() == 2) {
			return true;
		} else {
			return false;
		}
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

	public boolean dupEmail(String email, User user) {

		if (getUserByEmail(email) != null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean uploadImage(int id, File image, String contentType, String fileName) {
		return userDao.uploadPicture(id, image, contentType, fileName);
	}

	public boolean register(User user) {
		if(getUserByEmail(user.getEmail()) != null){
			return false;
		}
		int userId = userDao.save(user);
		user.setId(userId);
		return true;
	}

<<<<<<< HEAD
	public void banUser(int id) {
		// TODO Auto-generated method stub
		
	}

	public void unbanUser(int id) {
		// TODO Auto-generated method stub
		
	}

	public void checkBook(BookRelease bookRelease) {
		
		
	}
	
=======
	@Override
	public void manageUser(int id, int status) {
		User u = getUserById(id);
		if (!isAdmin(u)) {
			if (status == 0) {
				u.setRole(-1);
				update(u);
			} else if (status == 1) {
				u.setRole(1);
				update(u);
			}
		}
	}

	@Override
	public void checkBookRelease(BookRelease bookRelease, int status) {
		if (status == 1) {
			bookRelease.setStatus(1);
			bookReleaseDao.update(bookRelease);
		} else if (status == 0) {
			bookRelease.setStatus(-1);
			bookReleaseDao.update(bookRelease);
		}
	}

>>>>>>> f879bb089ae7ec98af7d7605fa27c63de735418a
}