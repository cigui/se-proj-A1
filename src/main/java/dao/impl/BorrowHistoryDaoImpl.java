package dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.BorrowHistoryDao;
import model.BorrowHistory;

@SuppressWarnings("deprecation")
public class BorrowHistoryDaoImpl extends HibernateDaoSupport implements BorrowHistoryDao {

	public Integer save(BorrowHistory borrowHistory) {
		return (Integer) getHibernateTemplate().save(borrowHistory);
	}

	public void delete(BorrowHistory borrowHistory) {
		getHibernateTemplate().delete(borrowHistory);
	}

	public void update(BorrowHistory borrowHistory) {
		getHibernateTemplate().merge(borrowHistory);
	}

	public List<BorrowHistory> getBorrowHistoryById(int id) {
		@SuppressWarnings("unchecked")
		List<BorrowHistory> borrowHistories = (List<BorrowHistory>) getHibernateTemplate().find(
				"from BorrowHistory as b where b.id=?", id);
		return borrowHistories;
	}
	
	public List<BorrowHistory> getBorrowHistoryByIdAndStatus(int id, int status) {
		@SuppressWarnings("unchecked")
		List<BorrowHistory> borrowHistories = (List<BorrowHistory>) getHibernateTemplate().find(
				"from BorrowHistory as b where b.id=? and b.orderStatus=?", id, status);
		return borrowHistories;
	}
	
	public BorrowHistory getBorrowHistoryByH_id(int h_id) {
		@SuppressWarnings("unchecked")
		List<BorrowHistory> borrowHistories = (List<BorrowHistory>) getHibernateTemplate().find(
				"from BorrowHistory as h where h.h_id=?", h_id);
		BorrowHistory borrowHistory = borrowHistories.size() > 0 ? borrowHistories.get(0) : null;
		return borrowHistory;
	}

	public List<BorrowHistory> getAllBorrowHistories() {
		@SuppressWarnings("unchecked")
		List<BorrowHistory> borrowHistories = (List<BorrowHistory>) getHibernateTemplate()
				.find("from BorrowHistory");
		return borrowHistories;
	}
	
}