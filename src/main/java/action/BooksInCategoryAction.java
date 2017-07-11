package action;

import java.util.List;

import model.Book;
import service.BookService;

public class BooksInCategoryAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int cate;
	private BookService bookService;
	
	public BookService getBookService() {
		return bookService;
	}
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	public int getCate() {
		return cate;
	}
	public void setCate(int cate) {
		this.cate = cate;
	}
	
	public String execute() {
		List<Book> result = bookService.getBooksInCategory(cate);
		request().setAttribute("booksInCate", result);
		return SUCCESS;
	}
}
