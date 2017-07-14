package action.bookAction;

import java.util.List;

import action.BaseAction;
import model.Book;
import model.Category;
import service.BookService;
import service.CategoryService;

public class GetRecommendedAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BookService bookService;
	private CategoryService categoryService;
	private int cur;
	private int limit;
	public BookService getBookService() {
		return bookService;
	}
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	public CategoryService getCategoryService() {
		return categoryService;
	}
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	public int getCur() {
		return cur;
	}
	public void setCur(int cur) {
		this.cur = cur;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	
	public String more() {
		List<Book> result = bookService.getBookByScore();
		List<Category> categories = categoryService.getAllCategories();
		request().setAttribute("categories", categories);
		request().setAttribute("books", result);
		request().setAttribute("cur", 0);
		return SUCCESS;
	}
}
