package action.orderAction;

import java.util.HashMap;
import java.util.Map;
import action.BaseAction;
import model.BorrowItem;
import service.BorrowItemsService;
import org.apache.struts2.interceptor.SessionAware;

public class DeleteFromShoppingCartAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private BorrowItemsService borrowItemsService;
	private Map<String, Object> resultMap;
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


	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	
	

	
	public BorrowItemsService getBorrowItemsService() {
		return borrowItemsService;
	}


	public void setBorrowItemsService(BorrowItemsService borrowItemsService) {
		this.borrowItemsService = borrowItemsService;
	}
	
	public Map<String, Object> getResultMap() {
		return resultMap;
	}
	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}
	
	
	public String execute() throws Exception {	
		resultMap = new HashMap<String, Object>();
		try {
			BorrowItem bi = borrowItemsService.getBorrowItem(id, r_id);
			borrowItemsService.delete(bi);
			resultMap.put("success", true);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("error", "undefined");
			return ERROR;
		}
	}
}
