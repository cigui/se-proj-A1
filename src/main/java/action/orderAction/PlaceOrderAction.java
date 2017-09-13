package action.orderAction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import action.BaseAction;
import model.BorrowItem;
import service.BorrowItemsService;
import service.BorrowHistoryService;

public class PlaceOrderAction extends BaseAction  {

	private static final long serialVersionUID = 1L;
	private BorrowHistoryService borrowHistoryService;
	private BorrowItemsService borrowItemsService;
	private String json;
	private int id;
	private int r_id;
	private String location;
	private Map<String, Object> resultMap;

	
	
	public String getJson() {
		return json;
	}


	public void setJson(String json) {
		this.json = json;
	}

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

	public BorrowItemsService getBorrowItemsService() {
		return borrowItemsService;
	}


	public void setBorrowItemsService(BorrowItemsService borrowItemsService) {
		this.borrowItemsService = borrowItemsService;
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
			Gson gson = new Gson();
			resultMap = new HashMap<String, Object>();
			@SuppressWarnings("unchecked")
			List<Double> r_id1 = gson.fromJson(json, List.class);
			List<Integer> r_id2 = new ArrayList<Integer>();
			for (int i = 0; i < r_id1.size(); i++) {
				r_id2.add(r_id1.get(i).intValue());
			}
			for (int i = 0; i < r_id2.size(); i++) {
				BorrowItem bi = borrowItemsService.getBorrowItem(id, r_id2.get(i));
				String result = borrowHistoryService.borrow(id, r_id2.get(i), location);
				resultMap.put("result", result);
				borrowItemsService.delete(bi);	
			}
			return SUCCESS;
		}
	}
