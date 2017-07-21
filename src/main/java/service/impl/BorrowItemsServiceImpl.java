package service.impl;

import java.util.List;

import dao.BorrowItemDao;
import model.BorrowItem;
import service.BorrowItemsService;

public class BorrowItemsServiceImpl implements BorrowItemsService{
	
	private  BorrowItemDao borrowItemDao;
	
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
		return borrowItemDao.getBorrowItem(id, r_id);
	}

	
}