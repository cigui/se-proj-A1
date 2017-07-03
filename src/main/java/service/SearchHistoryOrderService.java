package service;

import model.BorrowHistory;

import java.util.List;
public interface SearchHistoryOrderService {
    

	public Integer save(BorrowHistory borrowHistory);

	public void delete(BorrowHistory borrowHistory);

	public void update(BorrowHistory borrowHistory);

	public BorrowHistory getBorrowHistoryByH_id(int h_id);
	
	public BorrowHistory getBorrowHistoryById(int id);

	public List<BorrowHistory> getAllBorrowHistories();
    
    public void SearchHistoryOrder(int id);
    

}