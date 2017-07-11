package action;

import java.util.List;

import model.Book;
import model.Category;
import service.BookService;
import service.CategoryService;

public class IndexAction extends BaseAction {

	/**
	 * Created on July 3rd, 2017
	 * By Zhou Xin
	 */
	private static final long serialVersionUID = 1L;
	
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

	public String execute() throws Exception {
		List<Book> bestBooks = bookService.getBookByScore();
		List<Category> categories = categoryService.getAllCategories();
		request().setAttribute("bestBooks", bestBooks);
		request().setAttribute("categories", categories);
		return SUCCESS;
	}
}
