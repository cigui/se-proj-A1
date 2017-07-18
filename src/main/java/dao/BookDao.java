package dao;

import java.util.List;

import model.Book;

public interface BookDao {

	public Long save(Book book);

	public void delete(Book book);

	public void update(Book book);

	public Book getBookByIsbn(long isbn);
	
	public List<Book> getBookByTitle(String title);
	
	public List<Book> getBookByAuthor(String author);

	public List<Book> getAllBooks();
	
	public List<Book> getBookByScore();
	
	public List<Book> getBookByScoreLimits(int offset, int maxCount);
	
	public long getBooksCount();

}