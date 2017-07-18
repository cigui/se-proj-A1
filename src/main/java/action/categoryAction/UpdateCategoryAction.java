package action.categoryAction;

import action.BaseAction;
import model.Category;
import service.CategoryService;

public class UpdateCategoryAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private int id;
	private String category;
	private CategoryService categoryService;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


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
		Category c = categoryService.getCategoryById(id);
		c.setName(category);
		categoryService.update(c);
		categoryService.setCategoriesById(id-1, c);
		return SUCCESS;
	}

}
