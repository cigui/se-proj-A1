package service;

import java.util.List;

import model.Category;

public interface CategoryService {
	
	public Integer save(Category category);
	
	public void delete(Category category);
	
	public void update(Category category);
	
	public List<Category> getAllCategories();
	
	public Category getCategoryById(int id);
}
