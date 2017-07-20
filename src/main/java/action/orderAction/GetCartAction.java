package action.orderAction;

import java.util.List;
import java.util.Map;
import action.BaseAction;
import model.BorrowItem;
import model.District;
import model.User;
import model.BookRelease;
import org.apache.struts2.interceptor.SessionAware;

import service.BookReleaseService;
import service.BorrowItemsService;
import service.DistrictService;
import service.UserService;

public  class GetCartAction extends BaseAction implements SessionAware {
	
	/**edit by Yu Haifeng
	 * 2017.7.19
	 */
	private static final long serialVersionUID = 1L;
	private BookReleaseService bookReleaseService;
	private BorrowItemsService borrowItemsService;
	@SuppressWarnings("unused")
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
	
	
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public String execute() throws Exception {
		int id = (Integer) session.get("userId");
		List<BorrowItem> bi = borrowItemsService.getBorrowItemById(id);
		return SUCCESS;
	}
}
