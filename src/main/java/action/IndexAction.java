package action;

import java.util.Collections;
import java.util.List;

import model.Book;
import model.Category;
import model.User;
import service.BookService;
import service.CategoryService;
import service.UserService;

public class IndexAction extends BaseAction {

	/**
	 * Created on July 3rd, 2017
	 * By Zhou Xin
	 */
	private static final long serialVersionUID = 1L;
	
	private UserService userService;
	private BookService bookService;
	private CategoryService categoryService;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

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
		
		if(session().getAttribute("userId") != null){
			User u = userService.getUserById((Integer)session().getAttribute("userId"));
			List<Book> recBooks = bookService.getBooksByCategory(u.getFav_category());
			Collections.shuffle(recBooks);
			request().setAttribute("recommendBooks", recBooks);
		}
		
		return SUCCESS;
	}
}
