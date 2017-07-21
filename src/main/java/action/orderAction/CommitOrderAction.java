package action.orderAction;

import java.sql.Timestamp;
import java.util.Map;
import action.BaseAction;
import model.BorrowItem;
import model.User;
import model.BorrowHistory;
import service.BorrowItemsService;
import service.BorrowHistoryService;
import org.apache.struts2.interceptor.SessionAware;

public class CommitOrderAction extends BaseAction implements SessionAware {

	private static final long serialVersionUID = 1L;
	private BorrowHistoryService borrowHistoryService;
	private BorrowItemsService borrowItemsService;
	private Map<String, Object> session;
	private int id;
	private int r_id;
	private int orderStatus;
	private String location;
	private Timestamp date;
	private int h_id;

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
	
	public int getOrderStatus() {
		return orderStatus;
	}


	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}
	
	public Timestamp getDate() {
		return date;
	}


	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	public BorrowItemsService getBorrowItemService() {
		return borrowItemsService;
	}


	public void BorrowItemsService(BorrowItemsService borrowItemsService) {
		this.borrowItemsService = borrowItemsService;
	}
	
	public BorrowHistoryService getBorrowHistoryService() {
		return borrowHistoryService;
	}


	public void BorrowHistoryService(BorrowHistoryService borrowHistoryService) {
		this.borrowHistoryService = borrowHistoryService;
	}
	
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	
	public String execute() throws Exception {	
		try {
			int id = (Integer) session.get("userId");
			BorrowItem bi = borrowItemsService.getBorrowItem(id, r_id);
			borrowItemsService.delete(bi);
			BorrowHistory bh = new BorrowHistory(orderStatus, location, date,  id,  h_id, r_id);
			
			
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
}
