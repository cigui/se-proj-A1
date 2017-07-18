package dao.impl;

import java.util.List;

import org.hibernate.Query;
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
				"from Book as t where t.title like ?", "%"+title+"%");
		return books;
	}
	
	public List<Book> getBookByAuthor(String author) {
		@SuppressWarnings("unchecked")
		List<Book> books = (List<Book>) getHibernateTemplate().find(
				"from Book as t where t.author like ?", "%"+author+"%");
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
	
	public List<Book> getBookByScore(){
		@SuppressWarnings("unchecked")
		List<Book> books = (List<Book>) getHibernateTemplate()
		    .find("from Book order by score desc");
		return books;
	}

	public List<Book> getBookByScoreLimits(int offset, int maxCount) {
		Query q = getSession().createQuery("from Book order by score desc");
		q.setFirstResult(offset);
		q.setMaxResults(maxCount);
		@SuppressWarnings("unchecked")
		List<Book> books = (List<Book>)q.list();
		return books;
	}

	public long getBooksCount() {
		Query q = getSession().createQuery("select count(*) from Book");
		long count = (Long) q.uniqueResult();
		return count;
	}
	
}