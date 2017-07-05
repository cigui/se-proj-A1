package service;

import model.Book;
import java.util.List;

public interface BookService {
	
    public Integer save(Book book);

	public void delete(Book book);

	public void update(Book book);

	public Book getBookByISBN(long ISBN);
	
	public List<Book> getBookByTitle(String title);
	
	public List<Book> getBookByAuthor(String author);

	public List<Book> getAllBooks();
       
    public List<Book> SearchBook(String keyword);
    
    public void DisplayBooks();
    
    public void DisplayBooksByCategory(String category);

}
