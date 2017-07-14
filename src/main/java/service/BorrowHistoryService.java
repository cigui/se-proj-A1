package service;

import model.BorrowHistory;

import java.util.List;

public interface BorrowHistoryService {
	public Integer save(BorrowHistory borrowHistory);

	public void delete(BorrowHistory borrowHistory);

	public void update(BorrowHistory borrowHistory);
	
	public List<BorrowHistory> getBorrowHistory(int id, int status);
}
