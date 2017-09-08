package action.orderAction;


import action.BaseAction;
import model.Book;
import model.BookRelease;
import model.User;
import service.BookReleaseService;
import service.BookService;
import service.DistrictService;
import service.UserService;

public class MyReleaseDetailAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int r_id;
	private BookReleaseService bookReleaseService;
	private BookService bookService;
	private UserService userService;
	private DistrictService districtService;
	
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

	public DistrictService getDistrictService() {
		return districtService;
	}

	public void setDistrictService(DistrictService districtService) {
		this.districtService = districtService;
	}

	public String execute() throws Exception {
		BookRelease bookRelease = bookReleaseService.getBookReleaseByR_id(r_id);
		long isbn = bookRelease.getIsbn();
		int id = bookRelease.getId();
		Book book = bookService.getBookByISBN(isbn);
		User user = userService.getUserById(id);
		if (user.getId() == (Integer) session().getAttribute("userId")) {
			request().setAttribute("bookRelease", bookRelease);
			request().setAttribute("book", book);
			request().setAttribute("user", user);
			request().setAttribute("location", districtService.getLocationById(user.getL_id()));
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	

}
