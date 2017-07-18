package action.orderAction;

import java.util.List;

import action.BaseAction;
import model.BorrowHistory;
import service.BorrowHistoryService;

public class ListHistoryOrderAction extends BaseAction {

	/**
	 * Created on July 12th, 2017
	 * By Xia Jiasheng
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int status;
	private BorrowHistoryService borrowHistoryService;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public BorrowHistoryService getBorrowHistoryService() {
		return borrowHistoryService;
	}
	
	public void setBorrowHistoryService(BorrowHistoryService borrowHistoryServise) {
		this.borrowHistoryService = borrowHistoryServise;
	}

	@Override
	public String execute() throws Exception {
		List<BorrowHistory> historyList = borrowHistoryService.getBorrowHistory(id, status);
		request().setAttribute("history", historyList);
		return SUCCESS;
	}
}
