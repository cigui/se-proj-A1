package service;

import model.BorrowItem;

import java.util.List;

public interface AddBookToCartService {
    public BorrowItem save(BorrowItem borrowItem);

	public void delete(BorrowItem borrowItem);

	public void update(BorrowItem borrowItem);

	public List<BorrowItem> getBorrowItemById(int id);

	public List<BorrowItem> getAllBorrowItems();
    
    public boolean AddBookToCart(BorrowItem borrowItem);

}





