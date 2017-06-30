package dao;

import java.util.List;

import model.BorrowHistory;

public interface BorrowHistoryDao {

	public Integer save(BorrowHistory borrowHistory);

	public void delete(BorrowHistory borrowHistory);

	public void update(BorrowHistory borrowHistory);

	public BorrowHistory getBorrowHistoryByH_id(int h_id);
	
	public BorrowHistory getBorrowHistoryById(int id);

	public List<BorrowHistory> getAllBorrowHistories();

}