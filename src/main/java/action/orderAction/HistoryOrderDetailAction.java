package action.orderAction;

import action.BaseAction;
import model.Book;
import model.BookRelease;
import model.BorrowHistory;
import model.User;
import service.BookReleaseService;
import service.BookService;
import service.BorrowHistoryService;
import service.UserService;

public class HistoryOrderDetailAction extends BaseAction {

	/**
	 * Created on July 12th, 2017
	 * By Xia Jiasheng
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private BorrowHistoryService borrowHistoryService;
	private UserService userService;
	private BookReleaseService bookReleaseService;
	private BookService bookService;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public BorrowHistoryService getBorrowHistoryService() {
		return borrowHistoryService;
	}
	
	public void setBorrowHistoryService(BorrowHistoryService borrowHistoryServise) {
		this.borrowHistoryService = borrowHistoryServise;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
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

	@Override
	public String execute() throws Exception {
		BorrowHistory bh = borrowHistoryService.getBorrowHistoryByH_id(id);
		int r_id = bh.getR_id();
		BookRelease br = bookReleaseService.getBookReleaseByR_id(r_id);
		long isbn = br.getIsbn();
		Book book = bookService.getBookByISBN(isbn);
		int u_id = br.getId();
		User u = userService.getUserById(u_id);
		request().setAttribute("borrowHistory", bh);
		request().setAttribute("user", u);
		request().setAttribute("release", br);
		request().setAttribute("book", book);
		return SUCCESS;
	}
}
