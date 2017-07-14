package service.impl;

import java.util.List;

import dao.CategoryDao;
import model.Category;
import service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	private CategoryDao categoryDao;
	
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
		return categoryDao.getAllCategories();
	}

	public Category getCategoryById(int id) {
		return categoryDao.getCategoryByCate_id(id);
	}

}
