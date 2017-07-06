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
	public Book getBookByISBN(long ISBN) {
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
	public List<Book> getAllBooks() {
		return bookDao.getAllBooks();
	}

	@Override
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

	@Override
	public void DisplayBooks() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DisplayBooksByCategory(String category) {
		// TODO Auto-generated method stub
		
	}


}