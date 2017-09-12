package dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.BookCateRelationshipDao;
import model.BookCateRelationship;

@SuppressWarnings("deprecation")
public class BookCateRelationshipDaoImpl extends HibernateDaoSupport implements BookCateRelationshipDao {

	public BookCateRelationship save(BookCateRelationship bookCateRelationship) {
		return (BookCateRelationship) getHibernateTemplate().save(bookCateRelationship);
	}

	public void delete(BookCateRelationship bookCateRelationship) {
		getHibernateTemplate().delete(bookCateRelationship);
	}

	public void update(BookCateRelationship bookCateRelationship) {
		getHibernateTemplate().merge(bookCateRelationship);
	}

/*	public List<BookCateRelationship> getBookCateRelationshipByCate_id(int cate_id) {
		@SuppressWarnings("unchecked")
		List<BookCateRelationship> bookCateRelationships = (List<BookCateRelationship>) getHibernateTemplate().find(
				"from BookCateRelationship as t where t.cate_id=?", cate_id);
		return bookCateRelationships;
	}
	
	public List<BookCateRelationship> getBookCateRelationshipByIsbn(long isbn) {
		@SuppressWarnings("unchecked")
		List<BookCateRelationship> bookCateRelationships = (List<BookCateRelationship>) getHibernateTemplate().find(
				"from BookCateRelationship as d where d.isbn=?", isbn);
		return bookCateRelationships;
	}*/
	
	public List<BookCateRelationship> getAllBookCateRelationships() {
		@SuppressWarnings("unchecked")
		List<BookCateRelationship> bookCateRelationships = (List<BookCateRelationship>) getHibernateTemplate()
				.find("from BookCateRelationship");
		return bookCateRelationships;
	}

	public List<Integer> getCategoriesIdByIsbn(long isbn) {
		@SuppressWarnings("unchecked")
		List<Integer> categories = (List<Integer>) getHibernateTemplate().find(
				"select cate_id from BookCateRelationship as t where t.isbn="+isbn);
		return categories;
	}

	public List<Long> getBooksIsbnByCate_id(int cate_id) {
		@SuppressWarnings("unchecked")
		List<Long> books = (List<Long>) getHibernateTemplate().find(
				"select isbn from BookCateRelationship as t where t.cate_id=?", cate_id);
		return books;
	}

	public List<Long> getBooksIsbnByCate_idLimits(int cate_id, int offset, int maxCount) {
		Query q = getSession().createQuery("select isbn from BookCateRelationship as t where t.cate_id=?");
		q.setParameter(0, cate_id);
		q.setFirstResult(offset);
		q.setMaxResults(maxCount);
		@SuppressWarnings("unchecked")
		List<Long> books = (List<Long>) q.list();
		return books;
	}

	public int countBooksInCate(int cate_id) {
		Query q = getSession().createQuery("select count(*) from BookCateRelationship as t where t.cate_id=?");
		q.setParameter(0, cate_id);
		int count= ((Number)q.uniqueResult()).intValue();  
		return count;
	}
	
}
