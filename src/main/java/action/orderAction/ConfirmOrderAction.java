package action.orderAction;

import action.BaseAction;
import model.BorrowHistory;
import service.BorrowHistoryService;

public class ConfirmOrderAction extends BaseAction {

	/**
	 * Created on July 21st, 2017
	 * By Xia Jiasheng
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private BorrowHistoryService borrowHistoryService;
	
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

	@Override
	public String execute() throws Exception {
		BorrowHistory bh = borrowHistoryService.getBorrowHistoryByH_id(id);
		bh.setOrderStatus(1);
		borrowHistoryService.update(bh);
		return SUCCESS;
	}
}
