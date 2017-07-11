package action;

import java.util.List;

import model.Book;
import service.BookService;

public class IndexAction extends BaseAction {

	/**
	 * Created on July 3rd, 2017
	 * By Zhou Xin
	 */
	private static final long serialVersionUID = 1L;
	
	private BookService bookService;
	
	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public String execute() throws Exception {
		List<Book> bestBooks = bookService.getBookByScore();
		request().setAttribute("bestBooks", bestBooks);
		return SUCCESS;
	}
}
