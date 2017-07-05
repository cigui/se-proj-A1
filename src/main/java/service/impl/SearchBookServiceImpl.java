package service.impl;

import java.util.ArrayList;
import java.util.List;

import dao.BookDao;
import model.Book;
import service.SearchBookService;

public class SearchBookServiceImpl implements SearchBookService{
	
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
	public List<Book> getAllBooks() {
		return bookDao.getAllBooks();
	}

	@Override
	public List<Book> SearchBook(String keyword) {
		List<Book> resultList = new ArrayList<Book>();
		resultList.add(getBookByISBN(Integer.parseInt(keyword)));
		resultList.addAll(getBookByTitle(keyword));
		resultList.addAll(getBookByAuthor(keyword));
		return resultList;
	}


}