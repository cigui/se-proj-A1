package dao;

import java.util.List;

import model.BorrowItem;

public interface BorrowItemDao {

	public BorrowItem save(BorrowItem borrowItem);

	public void delete(BorrowItem borrowItem);

	public void update(BorrowItem borrowItem);

	public List<BorrowItem> getBorrowItemById(int id);

	public List<BorrowItem> getAllBorrowItems();
	
	public BorrowItem getBorrowItem(int id, int r_id);

}