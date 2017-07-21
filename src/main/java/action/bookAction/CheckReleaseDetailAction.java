package action.bookAction;

import action.BaseAction;
import model.Book;
import model.BookRelease;
import model.User;
import service.BookReleaseService;
import service.BookService;
import service.UserService;

public class CheckReleaseDetailAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int r_id;
	private BookReleaseService bookReleaseService;
	private BookService bookService;
	private UserService userService;
	
	public int getR_id() {
		return r_id;
	}
	
	public void setR_id(int r_id) {
		this.r_id = r_id;
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
		BookRelease bookrelease = bookReleaseService.getBookReleaseByR_id(r_id);
		long isbn = bookrelease.getIsbn();
        Book book = bookService.getBookByISBN(isbn);
        int id = bookrelease.getId();
        User user = userService.getUserById(id);
        request().setAttribute("bookRelease", bookrelease);
        request().setAttribute("book", book);
        request().setAttribute("user", user);
        
        
		
		return SUCCESS;
	}

}
