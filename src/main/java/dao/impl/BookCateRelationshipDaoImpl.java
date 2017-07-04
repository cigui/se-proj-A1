package dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.BookCateRelationshipDao;
import model.BookCateRelationship;

@SuppressWarnings("deprecation")
public class BookCateRelationshipDaoImpl extends HibernateDaoSupport implements BookCateRelationshipDao {

	public Integer save(BookCateRelationship bookCateRelationship) {
		return (Integer) getHibernateTemplate().save(bookCateRelationship);
	}

	public void delete(BookCateRelationship bookCateRelationship) {
		getHibernateTemplate().delete(bookCateRelationship);
	}

	public void update(BookCateRelationship bookCateRelationship) {
		getHibernateTemplate().merge(bookCateRelationship);
	}

	public List<BookCateRelationship> getBookCateRelationshipByCate_id(int cate_id) {
		@SuppressWarnings("unchecked")
		List<BookCateRelationship> bookCateRelationships = (List<BookCateRelationship>) getHibernateTemplate().find(
				"from BookCateRelationship as t where t.cate_id=?", cate_id);
		return bookCateRelationships;
	}
	
	public List<BookCateRelationship> getBookCateRelationshipByIsbn(int isbn) {
		@SuppressWarnings("unchecked")
		List<BookCateRelationship> bookCateRelationships = (List<BookCateRelationship>) getHibernateTemplate().find(
				"from BookCateRelationship as d where d.isbn=?", isbn);
		return bookCateRelationships;
	}
	
	public List<BookCateRelationship> getAllBookCateRelationships() {
		@SuppressWarnings("unchecked")
		List<BookCateRelationship> bookCateRelationships = (List<BookCateRelationship>) getHibernateTemplate()
				.find("from BookCateRelationship");
		return bookCateRelationships;
	}
	
}