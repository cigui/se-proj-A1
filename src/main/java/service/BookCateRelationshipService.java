package service;

import model.Book;
import model.Category;

import java.util.List;

public interface BookCateRelationshipService {
	
	public Integer save(Book book);

	public void delete(Book book);

	public void update(Book book);

	public Book getBookByIsbn(int isbn);
	
	public Book getBookByTitle(int title);
	
	public Book getBookByAuthor(int author);

	public List<Book> getAllBooks();
	
	public Integer save(Category category);

	public void delete(Category category);

	public void update(Category category);

	public Category getCategoryByCate_id(int cate_id);

	public List<Category> getAllCategories();
	
	public boolean BookCateRealtionship(Book book,Category category);
	 
   
    
}
