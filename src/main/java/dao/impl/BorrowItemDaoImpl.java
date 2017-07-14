package dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.BorrowItemDao;
import model.BorrowItem;

@SuppressWarnings("deprecation")
public class BorrowItemDaoImpl extends HibernateDaoSupport implements BorrowItemDao {

	public BorrowItem save(BorrowItem borrowItem) {
		return (BorrowItem) getHibernateTemplate().save(borrowItem);
	}

	public void delete(BorrowItem borrowItem) {
		getHibernateTemplate().delete(borrowItem);
	}

	public void update(BorrowItem borrowItem) {
		getHibernateTemplate().merge(borrowItem);
	}

	public List<BorrowItem> getBorrowItemById(int id) {
		@SuppressWarnings("unchecked")
		List<BorrowItem> borrowItems = (List<BorrowItem>) getHibernateTemplate().find(
				"from BorrowItem as b where b.id=?", id);
		return borrowItems;
	}

	public List<BorrowItem> getAllBorrowItems() {
		@SuppressWarnings("unchecked")
		List<BorrowItem> borrowItems = (List<BorrowItem>) getHibernateTemplate()
				.find("from BorrowItem");
		return borrowItems;
	}
	
}