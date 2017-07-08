package dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.BookDao;
import model.Book;

@SuppressWarnings("deprecation")
public class BookDaoImpl extends HibernateDaoSupport implements BookDao {

	public Long save(Book book) {
		return (Long) getHibernateTemplate().save(book);
	}

	public void delete(Book book) {
		getHibernateTemplate().delete(book);
	}

	public void update(Book book) {
		getHibernateTemplate().merge(book);
	}

	public List<Book> getBookByTitle(String title) {
		@SuppressWarnings("unchecked")
		List<Book> books = (List<Book>) getHibernateTemplate().find(
				"from Book as t where t.title=?", title);
		return books;
	}
	
	public List<Book> getBookByAuthor(String author) {
		@SuppressWarnings("unchecked")
		List<Book> books = (List<Book>) getHibernateTemplate().find(
				"from Book as t where t.title=?", author);
		return books;
	}
	
	public Book getBookByIsbn(long isbn) {
		@SuppressWarnings("unchecked")
		List<Book> books = (List<Book>) getHibernateTemplate().find(
				"from Book as d where d.isbn=?", isbn);
		Book book = books.size() > 0 ? books.get(0) : null;
		return book;
	}
	
	public List<Book> getAllBooks() {
		@SuppressWarnings("unchecked")
		List<Book> books = (List<Book>) getHibernateTemplate()
				.find("from Book");
		return books;
	}
	
}