package service.impl;

import java.util.List;

import dao.BorrowHistoryDao;
import model.BorrowHistory;
import service.BorrowHistoryService;

public class BorrowHistoryServiceImpl implements BorrowHistoryService {

	private BorrowHistoryDao borrowHistoryDao;

	public BorrowHistoryDao getBorrowHistoryDao() {
		return borrowHistoryDao;
	}

	public void setBorrowHistoryDao(BorrowHistoryDao borrowHistoryDao) {
		this.borrowHistoryDao = borrowHistoryDao;
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

	public List<BorrowHistory> getBorrowHistory(int id, int status) {
		return borrowHistoryDao.getBorrowHistoryByIdAndStatus(id,status);
	}
}