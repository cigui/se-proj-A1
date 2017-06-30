package dao;

import java.util.List;

import model.Category;


public interface CategoryDao {

	public Integer save(Category category);

	public void delete(Category category);

	public void update(Category category);

	public Category getCategoryById(int cate_ID);

	public List<Category> getAllCategories();

}