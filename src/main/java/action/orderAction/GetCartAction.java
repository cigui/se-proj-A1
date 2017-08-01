package action.orderAction;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import action.BaseAction;
import model.Book;
import model.BorrowItem;
import model.BookRelease;
import org.apache.struts2.interceptor.SessionAware;
import service.BookService;
import service.BookReleaseService;
import service.BorrowItemsService;

public  class GetCartAction extends BaseAction implements SessionAware {
	
	/**edit by Yu Haifeng
	 * 2017.7.19
	 */
	
	private static final long serialVersionUID = 1L;
	private BookReleaseService bookReleaseService;
	private BorrowItemsService borrowItemsService;
	private BookService bookService;
	
	private Map<String, Object> session;
	
	public  BookReleaseService getbookReleaseService() {
		return bookReleaseService;
	}


	public void setBookReleaseService(BookReleaseService bookReleaseService) {
		this.bookReleaseService = bookReleaseService;
	}
	
	public BorrowItemsService  getBorrowItemsService() {
		return borrowItemsService;
	}


	public void setBorrowItemsService(BorrowItemsService borrowItemsService) {
		this.borrowItemsService = borrowItemsService;
	}
	
	public  BookService getbookService() {
		return bookService;
	}


	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	
	
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public String execute() throws Exception {
		int id = (Integer) session.get("userId");
		List<BorrowItem> bi = borrowItemsService.getBorrowItemById(id);
		Map<Integer, String>books = new HashMap<Integer, String>();  //r_id and title
		for (int i =0; i<bi.size(); i++){
			int r_id = bi.get(i).getR_id();
			BookRelease br = bookReleaseService.getBookReleaseByR_id(r_id);
			long isbn = br.getIsbn();
			Book bk = bookService.getBookByISBN(isbn);	
			books.put(r_id,bk.getTitle());		
		} 
		Map<Integer, Integer>prices = new HashMap<Integer, Integer>(); //r_id and price
		for (int i=0; i<bi.size();i++){
			int r_id = bi.get(i).getR_id();
			BookRelease br = bookReleaseService.getBookReleaseByR_id(r_id);
			prices.put(r_id, br.getPrice());
		} 
		request().setAttribute("bi", bi);
		request().setAttribute("books", books);
        request().setAttribute("prices", prices);		
		return SUCCESS;
	}
}
