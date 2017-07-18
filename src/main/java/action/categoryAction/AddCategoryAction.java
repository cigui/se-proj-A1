package action.categoryAction;

import java.util.List;

import action.BaseAction;
import model.Category;
import service.CategoryService;

public class AddCategoryAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private String category;
	private CategoryService categoryService;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}


	public CategoryService getCategoryService() {
		return categoryService;
	}


	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}


	@Override
	public String execute() throws Exception {
		Category c = new Category();
		c.setName(category);
		int id = categoryService.save(c);
		c.setCate_id(id);

		List<Category> cl = categoryService.getCategories();
		cl.add(c);
		categoryService.setCategories(cl);
		
		return SUCCESS;
	}

}
