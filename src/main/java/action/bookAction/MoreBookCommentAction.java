package action.bookAction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import action.BaseAction;
import model.Book;
import model.BookComment;
import model.User;
import service.BookCommentService;
import service.BookService;
import service.UserService;

public class MoreBookCommentAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private long isbn;
	private BookCommentService bookCommentService;
	private UserService userService;
	private BookService bookService;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
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
	
	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public String execute() throws Exception {
		List<BookComment> bookComments = bookCommentService.getBookCommentByISBN(isbn);
		Book book = bookService.getBookByISBN(isbn);
		Map<Integer,User> users = new HashMap<Integer,User>();
		for (BookComment item:bookComments){
			int id = item.getId();
			User user = userService.getUserById(id);
			users.put(id, user);
		}
		request().setAttribute("bookComments", bookComments);
		request().setAttribute("users", users);
		request().setAttribute("book", book);
		return SUCCESS;
	}
	

}
