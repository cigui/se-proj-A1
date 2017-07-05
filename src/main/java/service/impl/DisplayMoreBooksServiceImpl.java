package service.impl;

import java.util.List;

import dao.BookDao;
import model.Book;
import service.DisplayMoreBooksService;

public class DisplayMoreBooksServiceImpl implements DisplayMoreBooksService{

	private BookDao bookDao;
	
	public BookDao getBookdao() {
		return bookDao;
	}

	public void setBookdao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public Integer save(Book book) {
		return bookDao.save(book);
	}

	@Override
	public void delete(Book book) {
		bookDao.delete(book);
		
	}

	@Override
	public void update(Book book) {
		bookDao.update(book);
	}

	@Override
	public Book getBookByISBN(int ISBN) {
		return bookDao.getBookByIsbn(ISBN);
	}

	@Override
	public List<Book> getBookByTitle(String title) {
		return bookDao.getBookByTitle(title);
	}

	@Override
	public List<Book> getBookByAuthor(String author) {
		return bookDao.getBookByAuthor(author);
	}

	@Override
	public List<Book> getAllBook() {
		return bookDao.getAllBooks();
	}

	@Override
	public void DisplayMoreBooks() {
		getAllBook();
	}	
}