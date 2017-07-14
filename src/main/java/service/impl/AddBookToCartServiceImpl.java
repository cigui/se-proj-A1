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

	public List<BorrowItem> getAllBorrowItems() {
		return borrowItemDao.getAllBorrowItems();
	}

	public boolean AddBookToCart(BorrowItem borrowItem) {
		int id = borrowItem.getId();
		List<BorrowItem> userList = getBorrowItemById(id);

		int size = userList.size();
		for(int i = 0; i < size; i++){
			if((borrowItem.getId() == userList.get(i).getId()) &&(borrowItem.getR_id() == userList.get(i).getR_id())){
				return false;
			}
		}
		return true;
	}
}