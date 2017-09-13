package service.impl;

import java.util.List;

import dao.BookReleaseDao;
import dao.BorrowHistoryDao;
import dao.BorrowItemDao;
import dao.UserDao;
import model.BorrowItem;

import service.BorrowItemsService;

public class BorrowItemsServiceImpl implements BorrowItemsService{
	
	private BorrowHistoryDao borrowHistoryDao;
	private UserDao userDao;
	private BookReleaseDao bookReleaseDao;
	private  BorrowItemDao borrowItemDao;
	
	public BorrowHistoryDao getBorrowHistoryDao() {
		return borrowHistoryDao;
	}

	public void setBorrowHistoryDao(BorrowHistoryDao borrowHistoryDao) {
		this.borrowHistoryDao = borrowHistoryDao;
	}

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
	
	public BorrowItemDao getBorrowItemDao() {
		return borrowItemDao;
	}

	public void setBorrowItemDao(BorrowItemDao borrowItemDao) {
		this.borrowItemDao = borrowItemDao;
	}

	public BorrowItem save(BorrowItem borrowItem) {
		return borrowItemDao.save(borrowItem);
	}

	public void delete(BorrowItem borrowItem) {
		borrowItemDao.delete(borrowItem);
		
	}

	public void update(BorrowItem borrowItem) {
		borrowItemDao.update(borrowItem);
		
	}

	public List<BorrowItem> getBorrowItemById(int id) {
		return borrowItemDao.getBorrowItemById(id);
	}
	
	public BorrowItem getBorrowItem(int id, int r_id){
		return borrowItemDao.getSpecificItem(id, r_id);
	}

	
}