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
	private int page;
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
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String execute() {
		List<Book> result = bookService.getRecommendedBooks(page);
		List<Category> categories = categoryService.getAllCategories();
		request().setAttribute("categories", categories);
		request().setAttribute("books", result);
		request().setAttribute("cur", page);
		request().setAttribute("maxPage", bookService.getMaxPage());
		return SUCCESS;
	}
}
