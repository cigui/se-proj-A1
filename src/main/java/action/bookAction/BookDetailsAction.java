package action.bookAction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import action.BaseAction;
import model.Book;
import model.BookComment;
import model.BookRelease;
import model.User;
import service.BookCommentService;
import service.BookReleaseService;
import service.BookService;
import service.UserService;

public class BookDetailsAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long isbn;
	private BookService bookService;
	private BookReleaseService bookReleaseService;
	private BookCommentService bookCommentService;
	private UserService userService;

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	public BookReleaseService getBookReleaseService() {
		return bookReleaseService;
	}

	public void setBookReleaseService(BookReleaseService bookReleaseService) {
		this.bookReleaseService = bookReleaseService;
	}
	
	public BookCommentService getBookCommentService() {
		return bookCommentService;
	}

	public void setBookCommentService(BookCommentService bookCommentService) {
		this.bookCommentService = bookCommentService;
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
		List<BookComment>bookComments = bookCommentService.getBookCommentByISBN(isbn);
		request().setAttribute("book", book);
		request().setAttribute("bookReleases", bookReleases);
		request().setAttribute("bookComments", bookComments);
		request().setAttribute("users", users);
		return SUCCESS;
	}


}
