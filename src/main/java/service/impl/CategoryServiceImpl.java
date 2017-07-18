package service.impl;

import java.util.List;

import dao.CategoryDao;
import model.Category;
import service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	private CategoryDao categoryDao;
	List<Category> categories;
	
	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	public Integer save(Category category) {
		return categoryDao.save(category);
	}

	public void delete(Category category) {
		categoryDao.delete(category);
	}

	public void update(Category category) {
		categoryDao.update(category);
	}

	public List<Category> getAllCategories() {
		if (categories == null) {
			categories = categoryDao.getAllCategories();
		}
		return categories;
	}

	public Category getCategoryById(int id) {
		return categoryDao.getCategoryByCate_id(id);
	}

}
