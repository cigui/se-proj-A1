package service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.xwork.StringUtils;

import dao.BookCateRelationshipDao;
import dao.BookDao;
import model.Book;
import service.BookService;

public class BookServiceImpl implements BookService{
	
	private BookDao bookDao;
	private BookCateRelationshipDao bookCateRelationshipDao;
	private int itemsPerPage;
	private Integer maxPage = null;

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

	public int getItemsPerPage() {
		return itemsPerPage;
	}

	public void setItemsPerPage(int itemsPerPage) {
		this.itemsPerPage = itemsPerPage;
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
		
		Book book =  bookDao.getBookByIsbn(ISBN);
		if (book != null && book.getTranslator()==null){
			book.setTranslator("无");
		}
		return book;
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
		
		/* 使用Set进行查询结果去重，注意在Book里应该重载equals和hashCode方法 */
		Set<Book> resultSet = new HashSet<Book>();
		List<Book> resultList = new ArrayList<Book>();
		
		if (StringUtils.isNumeric(keyword) && (!keyword.equals(""))){
			Book tmp = bookDao.getBookByIsbn(Long.parseLong(keyword));
			if (tmp != null)
			resultList.add(tmp);
		}
		resultList.addAll(getBookByTitle(keyword));
		resultList.addAll(getBookByAuthor(keyword));
		resultSet.addAll(resultList);
		resultList.clear();
		resultList.addAll(resultSet);
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

	public List<Book> getRecommendedBooks(int page) {
		int offset = page * itemsPerPage;
		return bookDao.getBookByScoreLimits(offset, itemsPerPage);
	}

	public int getMaxPage() {
		if (maxPage == null) {
			int count = (int) bookDao.getBooksCount();
			maxPage = count%itemsPerPage == 0 ? count/itemsPerPage : count/itemsPerPage+1;
			/* page 从0算起 */
			maxPage--;
		}
		return maxPage;
	}
}