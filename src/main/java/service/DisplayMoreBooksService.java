package service;

import model.Book;

import java.util.List;

public interface DisplayMoreBooksService {
 
    public Integer save(Book book);

	public void delete(Book book);

	public void update(Book book);

	public Book getBookByISBN(int ISBN);
	
	public List<Book> getBookByTitle(String title);
	
	public List<Book> getBookByAuthor(String author);

	public List<Book> getAllBook();
    
    public void DisplayMoreBooks();
    
}










