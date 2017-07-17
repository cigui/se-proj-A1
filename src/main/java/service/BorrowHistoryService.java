package service;

import model.BorrowHistory;

import java.util.List;

public interface BorrowHistoryService {
	public Integer save(BorrowHistory borrowHistory);

	public void delete(BorrowHistory borrowHistory);

	public void update(BorrowHistory borrowHistory);
	
	public BorrowHistory getBorrowHistoryByH_id(int id);
	
	public List<BorrowHistory> getBorrowHistory(int id, int status);
}
