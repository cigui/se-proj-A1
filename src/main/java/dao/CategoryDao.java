package dao;

import java.util.List;

import model.Category;


public interface CategoryDao {

	public Integer save(Category category);

	public void delete(Category category);

	public void update(Category category);

	public Category getCategoryByCate_id(int cate_id);

	public List<Category> getAllCategories();

}