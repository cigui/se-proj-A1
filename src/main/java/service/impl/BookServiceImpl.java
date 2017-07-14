package service.impl;

import java.util.ArrayList;
import java.util.List;

import dao.BookCateRelationshipDao;
import dao.BookDao;
import model.Book;
import service.BookService;

public class BookServiceImpl implements BookService{
	
	private BookDao bookDao;
	private BookCateRelationshipDao bookCateRelationshipDao;

	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public BookCateRelationshipDao getBookCateRelationshipDao() {
		return bookCateRelationshipDao;
	}

	public void setBookCateRelationshipDao(BookCateRelationshipDao bookCateRelationshipDao) {
		this.bookCateRelationshipDao = bookCateRelationshipDao;
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
	
	public List<Book> getBookByScore(){
		return bookDao.getBookByScore();
	}

	public List<Book> getBooksByCategory(int cate) {
		List<Long> isbns = bookCateRelationshipDao.getBooksIsbnByCate_id(cate);
		List<Book> books = new ArrayList<Book>();
		for (int i = 0; i < isbns.size(); i++) {
			books.add(bookDao.getBookByIsbn(isbns.get(i)));
		}
		return books;
	}

	public List<Book> getBooksByCategoryLimits(int cate, int start, int length) {
		List<Long> isbns = bookCateRelationshipDao.getBooksIsbnByCate_idLimits(cate, start, length);
		List<Book> books = new ArrayList<Book>();
		for (int i = 0; i < isbns.size(); i++) {
			books.add(bookDao.getBookByIsbn(isbns.get(i)));
		}
		return books;
	}

	public int countBooksInCategory(int cate) {
		return bookCateRelationshipDao.countBooksInCate(cate);
	}

}