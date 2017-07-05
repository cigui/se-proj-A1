package service;

import model.Book;

import java.util.List;
public interface SearchBookService {
    
    public Integer save(Book book);

	public void delete(Book book);

	public void update(Book book);

	public Book getBookByISBN(int ISBN);
	
	public List<Book> getBookByTitle(String title);
	
	public List<Book> getBookByAuthor(String author);

	public List<Book> getAllBooks();
       
    public List<Book> SearchBook(String keyword);
    
}