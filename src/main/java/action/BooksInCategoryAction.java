package action;

import java.util.List;

import model.Book;
import model.Category;
import service.BookService;
import service.CategoryService;

public class BooksInCategoryAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int cate;
	private BookService bookService;
	private CategoryService categoryService;
	
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
	public int getCate() {
		return cate;
	}
	public void setCate(int cate) {
		this.cate = cate;
	}
	
	public String execute() {
		List<Book> result = bookService.getBooksInCategory(cate);
		List<Category> categories = categoryService.getAllCategories();
		String currentCate = categoryService.getCategoryById(cate).getName();
		request().setAttribute("booksInCate", result);
		request().setAttribute("categories", categories);
		request().setAttribute("currentCate", currentCate);
		return SUCCESS;
	}
}
