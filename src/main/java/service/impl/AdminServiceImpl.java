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
	
	public BookReleaseDao getBookReleaseDao() {
		return bookReleaseDao;
	}
	
	public void setBookReleaseDao(BookReleaseDao bookReleaseDao){
		this.bookReleaseDao = bookReleaseDao;
	}
	
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

	public List<BookRelease> getBookReleaseByStatus(){
		return bookReleaseDao.getBookReleaseByStatus();
	}

	public List<BookRelease> getAllBookReleases(){
		return bookReleaseDao.getAllBookReleases();
	}

	public void checkBook(int r_id,short status){
		BookRelease bookRelease = bookReleaseDao.getBookReleaseByR_id(r_id);
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
