package action.categoryAction;

import java.util.List;

import action.BaseAction;
import model.Category;
import service.CategoryService;;

public class ListCategoryAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private CategoryService categoryService;

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@Override
	public String execute() throws Exception {
		List<Category> catelist = categoryService.getAllCategories();
		request().setAttribute("categories", catelist);
		return SUCCESS;
	}
}
