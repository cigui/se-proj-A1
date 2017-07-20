package service;

import model.BorrowItem;
import java.util.List;

public interface BorrowItemsService {
    public BorrowItem save(BorrowItem borrowItem);

	public void delete(BorrowItem borrowItem);

	public void update(BorrowItem borrowItem);

	public List<BorrowItem> getBorrowItemById(int id);
 
}

