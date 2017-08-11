package service;

import model.Book;
import java.util.List;

public interface BookService {
	
    public Long save(Book book);

	public void delete(Book book);

	public void update(Book book);

	public Book getBookByISBN(long ISBN);
	
	public List<Book> getBookByTitle(String title);
	
	public List<Book> getBookByAuthor(String author);

	public List<Book> getAllBooks();
       
    public List<Book> SearchBook(String keyword);
    
    public List<Book> getBookByScore();
    
    public List<Book> getRecommendedBooks(int page);
    
    public int getMaxPage();

    public List<Book> getBooksByCategory(Integer cate);
    
    public List<Book> getBooksByCategoryLimits(int cate, int start, int length);
    
    public int countBooksInCategory(int cate);
}
