package dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.BookCommentDao;
import model.BookComment;

@SuppressWarnings("deprecation")
public class BookCommentDaoImpl extends HibernateDaoSupport implements BookCommentDao {

	public Integer save(BookComment bookComment) {
		return (Integer) getHibernateTemplate().save(bookComment);
	}

	public void delete(BookComment bookComment) {
		getHibernateTemplate().delete(bookComment);
	}

	public void update(BookComment bookComment) {
		getHibernateTemplate().merge(bookComment);
	}

	public List<BookComment> getBookCommentById(int id) {
		@SuppressWarnings("unchecked")
		List<BookComment> bookComments = (List<BookComment>) getHibernateTemplate().find(
				"from BookComment as t where t.id=?", id);
		return bookComments;
	}
	
	public List<BookComment> getBookCommentByIsbn(int isbn) {
		@SuppressWarnings("unchecked")
		List<BookComment> bookComments = (List<BookComment>) getHibernateTemplate().find(
				"from BookComment as d where d.isbn=?", isbn);
		return bookComments;
	}
	
	public List<BookComment> getAllBookComments() {
		@SuppressWarnings("unchecked")
		List<BookComment> bookComments = (List<BookComment>) getHibernateTemplate()
				.find("from BookComment");
		return bookComments;
	}
	
}