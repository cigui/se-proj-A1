package service.impl;

import java.util.List;

import dao.BookReleaseDao;
import dao.BorrowHistoryDao;
import dao.BorrowItemDao;
import dao.UserDao;
import model.BookRelease;
import model.BorrowHistory;
import model.User;
import service.BorrowHistoryService;

public class BorrowHistoryServiceImpl implements BorrowHistoryService {

	private BorrowHistoryDao borrowHistoryDao;
	private UserDao userDao;
	private BookReleaseDao bookReleaseDao;
	private BorrowItemDao borrowItemDao;

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

	public Integer save(BorrowHistory borrowHistory) {
		return borrowHistoryDao.save(borrowHistory);
	}

	public void delete(BorrowHistory borrowHistory) {
		borrowHistoryDao.delete(borrowHistory);

	}

	public void update(BorrowHistory borrowHistory) {
		borrowHistoryDao.update(borrowHistory);

	}

	public BorrowHistory getBorrowHistoryByH_id(int id) {
		return borrowHistoryDao.getBorrowHistoryByH_id(id);
	}

	public List<BorrowHistory> getBorrowHistory(int id, int status) {
		return borrowHistoryDao.getBorrowHistoryByIdAndStatus(id, status);
	}

	public String borrow(int id, int r_id, String location) {
		try {
			
			/* 检查收货地址是否为空 */
			if (location.trim().equals("")) {
				return "location";
			}
			
			BookRelease bookRelease = bookReleaseDao.getBookReleaseByR_id(r_id);
			User user = userDao.getUserById(id);
			User from = userDao.getUserById(bookRelease.getId());
			
			/* 判断图书是否合法 */
			if (bookRelease.getStatus() != 1) {
				return "borrowed";
			}

			/* 判断积分是否不足 */
			if (bookRelease.getPrice() > user.getPoints()) {
				return "points";
			}

			/* 更改书本状态 */
			bookRelease.setStatus((short) 2);
			bookReleaseDao.update(bookRelease);
			/* 转移积分 */
			user.setPoints(user.getPoints() - bookRelease.getPrice());
			from.setPoints(from.getPoints() + bookRelease.getPrice());
			userDao.update(user);
			userDao.update(from);
			
			/* 存入历史记录 */
			BorrowHistory borrowHistory = new BorrowHistory(0, location, id, r_id);
			borrowHistoryDao.save(borrowHistory);
			
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

}