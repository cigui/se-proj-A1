package service.impl;

import java.util.List;

import dao.BorrowItemDao;
import model.BorrowItem;
import service.AddBookToCartService;

public class AddBookToCartServiceImpl implements AddBookToCartService{
	
	private  BorrowItemDao borrowItemDao;
	
	public BorrowItemDao getBorrowItemDao() {
		return borrowItemDao;
	}

	public void setBorrowItemDao(BorrowItemDao borrowItemDao) {
		this.borrowItemDao = borrowItemDao;
	}

	@Override
	public Integer save(BorrowItem borrowItem) {
		return borrowItemDao.save(borrowItem);
	}

	@Override
	public void delete(BorrowItem borrowItem) {
		borrowItemDao.delete(borrowItem);
		
	}

	@Override
	public void update(BorrowItem borrowItem) {
		borrowItemDao.update(borrowItem);
		
	}

	@Override
	public List<BorrowItem> getBorrowItemById(int id) {
		return borrowItemDao.getBorrowItemById(id);
	}

	@Override
	public List<BorrowItem> getAllBorrowItems() {
		return borrowItemDao.getAllBorrowItems();
	}

	@Override
	public boolean AddBookToCart(BorrowItem borrowItem) {
		int id = borrowItem.getId();
		List<BorrowItem> userList = getBorrowItemById(id);

		int size = userList.size();
		for(int i = 0; i < size; i++){
			if(borrowItem == userList.get(i)){
				return false;
			}
		}
		save(borrowItem);
		return true;
	}
}