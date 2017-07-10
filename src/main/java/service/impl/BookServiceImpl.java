package service.impl;

import java.util.ArrayList;
import java.util.List;

import dao.BookDao;
import model.Book;
import service.BookService;

public class BookServiceImpl implements BookService{
	
	private BookDao bookDao;

	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public Long save(Book book) {
		return bookDao.save(book);
	}

	public void delete(Book book) {
		bookDao.delete(book);
	}

	public void update(Book book) {
		bookDao.update(book);
	}

	public Book getBookByISBN(long ISBN) {
		return bookDao.getBookByIsbn(ISBN);
	}

	public List<Book> getBookByTitle(String title) {
		return bookDao.getBookByTitle(title);
	}

	public List<Book> getBookByAuthor(String author) {
		return bookDao.getBookByAuthor(author);
	}

	public List<Book> getAllBooks() {
		return bookDao.getAllBooks();
	}

	public List<Book> SearchBook(String keyword) {
		List<Book> resultList = new ArrayList<Book>();
		try{
			resultList.add(getBookByISBN(Long.parseLong(keyword)));
		}
		catch(NumberFormatException nf){
			//do nothing
		}
		resultList.addAll(getBookByTitle(keyword));
		resultList.addAll(getBookByAuthor(keyword));
		return resultList;
	}

	public void DisplayBooks() {
		// TODO Auto-generated method stub
		
	}

	public void DisplayBooksByCategory(String category) {
		// TODO Auto-generated method stub
		
	}
	
	public List<Book> getBookByScore(){
		return bookDao.getBookByScore();
	}


}