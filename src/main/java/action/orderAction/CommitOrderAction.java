package action.orderAction;

import java.util.Map;
import action.BaseAction;
import model.BorrowItem;
import model.BorrowHistory;
import service.BorrowItemsService;
import service.BorrowHistoryService;
import org.apache.struts2.interceptor.SessionAware;

public class CommitOrderAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private BorrowHistoryService borrowHistoryService;
	private BorrowItemsService borrowItemsService;
	private Map<String, Object> session;
	
	
	
	
	
	public String execute() throws Exception {
		
		return SUCCESS;
	}

}
