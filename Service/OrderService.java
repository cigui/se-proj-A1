package service;

import model.BorrowHistory;
import model.BorrowItem;

import java.util.List;
/*SearchHistoryOrder¡¢CommitOrderService¡¢AddBookToCartService*/
public interface OrderService {
    public Integer save(BorrowItem borrowItem);

	public void delete(BorrowItem borrowItem);

	public void update(BorrowItem borrowItem);

	public BorrowItem getBorrowItemById(int id);

	public List<BorrowItem> getAllBorrowItems();
    
    public Integer save(BorrowHistory borrowHistory);

	public void delete(BorrowHistory borrowHistory);

	public void update(BorrowHistory borrowHistory);

	public BorrowHistory getBorrowHistoryByH_id(int h_id);
	
	public BorrowHistory getBorrowHistoryById(int id);

	public List<BorrowHistory> getAllBorrowHistories();

	public Integer save(BorrowHistory borrowHistory);

	public void delete(BorrowHistory borrowHistory);

	public void update(BorrowHistory borrowHistory);

	public BorrowHistory getBorrowHistoryByH_id(int h_id);
	
	public BorrowHistory getBorrowHistoryById(int id);

	public List<BorrowHistory> getAllBorrowHistories();
    
    public void SearchHistoryOrder(String keyword);
    
    public boolean CommitOrder();
    
    public boolean AddBookToCart(BorrowItem borrowItem);

}


