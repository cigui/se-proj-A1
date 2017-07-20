package action.orderAction;

import java.util.HashMap;
import java.util.Map;

import action.BaseAction;
import service.BorrowHistoryService;

public class CommitOrderAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int r_id;
	private String location;
	private BorrowHistoryService borrowHistoryService;
	private Map<String, Object> resultMap;


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


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public BorrowHistoryService getBorrowHistoryService() {
		return borrowHistoryService;
	}


	public void setBorrowHistoryService(BorrowHistoryService borrowHistoryService) {
		this.borrowHistoryService = borrowHistoryService;
	}
	 
	
	public Map<String, Object> getResultMap() {
		return resultMap;
	}


	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}


	public String execute() throws Exception {
		resultMap = new HashMap<String, Object>();
		String result = borrowHistoryService.borrow(id, r_id, location);
		resultMap.put("result", result);
		return SUCCESS;
	}

}
