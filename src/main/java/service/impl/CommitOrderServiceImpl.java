package service.impl;

import java.util.List;

import dao.BorrowItemDao;
import dao.BorrowHistoryDao;
import model.BorrowItem;
import service.CommitOrderService;

public class CommitOrderServiceImpl  implements CommitOrderService{
	
	private  BorrowItemDao borrowItemDao;
	private  BorrowHistoryDao borrowHistoryDao;
	
	public BorrowItemDao getBorrowItemDao() {
		return borrowItemDao;
	}

	public void setBorrowItemDao(BorrowItemDao borrowItemDao) {
		this.borrowItemDao = borrowItemDao;
	}
	
	public BorrowHistoryDao getBorrowHistoryDao() {
		return borrowHistoryDao;
	}

	public void setBorrowHistoryDao(BorrowHistoryDao borrowHistoryDao) {
		this.borrowHistoryDao = borrowHistoryDao;
	}


	@Override
	public Integer save(BorrowItem borrowItem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(BorrowItem borrowItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(BorrowItem borrowItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BorrowItem getBorrowItemById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BorrowItem> getAllBorrowItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean CommitOrder() {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}