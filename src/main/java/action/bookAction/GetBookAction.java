package action.bookAction;

import action.BaseAction;
import model.Book;
import service.BookService;

public class GetBookAction extends BaseAction {
	
	/**
	 * Created on 7th, July, 2017
	 * By Zhou Xin
	 */
	private static final long serialVersionUID = 1L;
	private String isbn;
	private Book result = null;
	private BookService bookService;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Book getResult() {
		return result;
	}

	public void setResult(Book result) {
		this.result = result;
	}

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	public String execute() {
		this.setResult(bookService.getBookByISBN(Long.parseLong(isbn)));
		return SUCCESS;
	}
	
}
