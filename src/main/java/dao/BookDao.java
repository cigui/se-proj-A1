package dao;

import java.util.List;

import model.Book;

public interface BookDao {

	public Integer save(Book book);

	public void delete(Book book);

	public void update(Book book);

	public Book getBookByISBN(int ISBN);
	
	public Book getBookByTitle(int title);
	
	public Book getBookByAuthor(int author);

	public List<Book> getAllBooks();

}