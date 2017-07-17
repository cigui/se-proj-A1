package action.orderAction;

import action.BaseAction;
import model.BorrowHistory;
import service.BorrowHistoryService;

public class ScoreOrderDetailAction extends BaseAction {

	/**
	 * Created on July 12th, 2017
	 * By Xia Jiasheng
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private byte score;
	private BorrowHistoryService borrowHistoryService;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public byte getScore() {
		return score;
	}

	public void setScore(byte score) {
		this.score = score;
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
		bh.setScore(score);
		borrowHistoryService.update(bh);
		return SUCCESS;
	}
}
