package dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.CategoryDao;
import model.Category;

@SuppressWarnings("deprecation")
public class CategoryDaoImpl extends HibernateDaoSupport implements CategoryDao {

	public Integer save(Category  category) {
		return (Integer) getHibernateTemplate().save( category);
	}

	public void delete(Category  category) {
		getHibernateTemplate().delete( category);
	}

	public void update(Category  category) {
		getHibernateTemplate().merge( category);
	}

	public Category getCategoryByCate_id(int cate_id) {
		@SuppressWarnings("unchecked")
		List<Category>  categories = (List<Category>) getHibernateTemplate().find(
				"from Category as u where u.cate_id=?", cate_id);
		Category  category =  categories.size() > 0 ?  categories.get(0) : null;
		return category;
	}

	public List<Category> getAllCategories() {
		@SuppressWarnings("unchecked")
		List<Category> categories = (List<Category>) getHibernateTemplate()
				.find("from Category");
		return categories;
	}
	
}