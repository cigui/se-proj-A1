package service;

import java.util.List;

import model.Category;

public interface CategoryService {
	
	public void setCategoriesById(int id, Category c);
	
	public Integer save(Category category);
	
	public void delete(Category category);
	
	public void update(Category category);
	
	public List<Category> getAllCategories();
	
	// functions for variable categories
	public List<Category> getCategories();
	
	public void setCategories(List<Category> categories);
	
	public Category getCategoryById(int id);
}
