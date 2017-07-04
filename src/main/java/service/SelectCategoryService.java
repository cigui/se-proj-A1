package service;

import model.Category;

import java.util.List;

public interface SelectCategoryService {
    
    public Integer save(Category category);

	public void delete(Category category);

	public void update(Category category);

	public Category getCategoryById(int cate_ID);

	public List<Category> getAllCategories();
    
    public boolean SelectCategory(Category category);
}
