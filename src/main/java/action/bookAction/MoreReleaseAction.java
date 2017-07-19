package action.bookAction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import action.BaseAction;
import model.Book;
import model.BookRelease;
import model.User;
import service.BookReleaseService;
import service.BookService;
import service.UserService;

public class MoreReleaseAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long isbn;
	private BookReleaseService bookReleaseService;
	private BookService bookService;
	private UserService userService;
	
	public long getIsbn() {
		return isbn;
	}
	
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public BookReleaseService getBookReleaseService() {
		return bookReleaseService;
	}

	public void setBookReleaseService(BookReleaseService bookReleaseService) {
		this.bookReleaseService = bookReleaseService;
	}

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String execute() throws Exception {
		Book book = bookService.getBookByISBN(isbn);
		List<BookRelease> rowBookReleases = bookReleaseService.getBookReleaseByISBN(isbn);
		List<BookRelease> bookReleases = new ArrayList<BookRelease>();
		for (BookRelease item : rowBookReleases) {
			int status = item.getStatus();
			if(status==1){
				bookReleases.add(item);
			}
		}
		Map<Integer, User> users = new HashMap<Integer,User>();
		for (BookRelease item : bookReleases) {
			int id = item.getId();
			User newUser = userService.getUserById(id);
			users.put(id, newUser);
		}
		request().setAttribute("book", book);
		request().setAttribute("bookReleases", bookReleases);
		request().setAttribute("users", users);
		return SUCCESS;
	}
	

}
