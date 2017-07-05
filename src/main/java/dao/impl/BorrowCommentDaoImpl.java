package dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.BorrowCommentDao;
import model.BorrowComment;

@SuppressWarnings("deprecation")
public class BorrowCommentDaoImpl extends HibernateDaoSupport implements BorrowCommentDao {

	public Integer save(BorrowComment borrowComment) {
		return (Integer) getHibernateTemplate().save(borrowComment);
	}

	public void delete(BorrowComment borrowComment) {
		getHibernateTemplate().delete(borrowComment);
	}

	public void update(BorrowComment borrowComment) {
		getHibernateTemplate().merge(borrowComment);
	}

	public BorrowComment getBorrowCommentByH_id(int h_id) {
		@SuppressWarnings("unchecked")
		List<BorrowComment> borrowComments = (List<BorrowComment>) getHibernateTemplate().find(
				"from BorrowComment as h where h.h_id=?", h_id);
		BorrowComment borrowComment = borrowComments.size() > 0 ? borrowComments.get(0) : null;
		return borrowComment;
	}

	public List<BorrowComment> getAllBorrowComments() {
		@SuppressWarnings("unchecked")
		List<BorrowComment> borrowComments = (List<BorrowComment>) getHibernateTemplate()
				.find("from BorrowComment");
		return borrowComments;
	}
	
}