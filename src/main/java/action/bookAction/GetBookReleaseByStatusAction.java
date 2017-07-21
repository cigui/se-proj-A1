package action.bookAction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import action.BaseAction;
import model.Book;
import model.BookRelease;
import service.AdminService;
import service.BookService;;

public class GetBookReleaseByStatusAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private AdminService adminService;
	private BookService bookService;

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	@Override
	public String execute() throws Exception {

		List<BookRelease> bookReleases = adminService.getBookReleaseByStatus();
		Map<Long,Book>books = new HashMap<Long,Book>();
		for (BookRelease item:bookReleases){
			long isbn = item.getIsbn();
			Book book = bookService.getBookByISBN(isbn);
			books.put(isbn, book);
		}
		request().setAttribute("bookrelease", bookReleases);
		request().setAttribute("books", books);
		return SUCCESS;
	}
}
