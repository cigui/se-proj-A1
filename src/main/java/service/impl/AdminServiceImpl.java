package service.impl;

import java.util.List;

import dao.BookReleaseDao;
import dao.UserDao;
import model.BookRelease;
import model.User;
import service.AdminService;

public class AdminServiceImpl implements AdminService {
	
	private BookReleaseDao bookReleaseDao;
	private UserDao userDao;
	
	public Integer save(User user){
		return userDao.save(user);
	}

	public void delete(User user){
		userDao.delete(user);
	}

	public void update(User user){
		userDao.update(user);
	}

	public User getUserById(int id){
		User user = userDao.getUserById(id);
		return user;
	}
	
	public User getUserByEmail(String email){
		return userDao.getUserByEmail(email);
	}

	public List<User> getAllUsers(){
		return userDao.getAllUsers();
	}
    
	public Integer save(BookRelease bookRelease){
		return bookReleaseDao.save(bookRelease);
	}

	public void delete(BookRelease bookRelease){
		bookReleaseDao.delete(bookRelease);
	}

	public void update(BookRelease bookRelease){
		bookReleaseDao.update(bookRelease);
	}

	public List<BookRelease> getBookReleaseByStatus(int status){
		return bookReleaseDao.getBookReleaseByStatus(status);
	}

	public List<BookRelease> getAllBookReleases(){
		return bookReleaseDao.getAllBookReleases();
	}

	public void checkBook(BookRelease bookRelease,short status){
		if (status == 1)	{
			bookRelease.setStatus((short) 1);
			bookReleaseDao.update(bookRelease);
		}
		if (status == 0)	{
			bookRelease.setStatus((short) -1);
			bookReleaseDao.update(bookRelease);
		}
			
	    
	}
}
