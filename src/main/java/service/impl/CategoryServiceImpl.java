package service.impl;

import java.util.List;

import dao.CategoryDao;
import model.Category;
import service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	private CategoryDao categoryDao;
	private List<Category> categories;
	
	public List<Category> getCategories() {
		return categories;
	}
	
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	public void setCategoriesById(int id, Category c) {
		this.categories.set(id, c);
	}
	
	
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
