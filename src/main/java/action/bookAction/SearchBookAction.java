package action.bookAction;

import java.util.List;

import action.BaseAction;
import model.Book;
import service.BookService;

public class SearchBookAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BookService bookService;
	private String searchString;
	
	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public String execute() throws Exception {
		List<Book> books = bookService.SearchBook(searchString);
		request().setAttribute("searchResult", books);
		return SUCCESS;
	}

}
