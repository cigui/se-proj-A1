package action.orderAction;

import java.util.Map;
import action.BaseAction;
import model.BorrowItem;
import service.BorrowItemsService;
import org.apache.struts2.interceptor.SessionAware;

public class DeleteFromShoppingCartAction extends BaseAction implements SessionAware {

	private static final long serialVersionUID = 1L;
	private BorrowItemsService borrowItemsService;
	private Map<String, Object> session;
	private int id;
	private int r_id;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public int getR_id() {
		return r_id;
	}


	public void setR_Id(int r_id) {
		this.r_id = r_id;
	}
	
	

	
	public BorrowItemsService getBorrowItemService() {
		return borrowItemsService;
	}


	public void BorrowItemsService(BorrowItemsService borrowItemsService) {
		this.borrowItemsService = borrowItemsService;
	}
	
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	
	public String execute() throws Exception {	
		try {
			int id = (Integer) session.get("userId");
			BorrowItem bi = borrowItemsService.getBorrowItem(id, r_id);
			borrowItemsService.delete(bi);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
}
