package action.bookAction;


import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import action.BaseAction;
import model.BookComment;
import service.BookCommentService;

public class SendBookCommentAction extends BaseAction implements SessionAware{

	private static final long serialVersionUID = 1L;
	private long isbn;
	private String discription;
	private String score;
	private BookComment bookComment;
	private BookCommentService bookCommentService;
	private String success;
	private Map<String, Object> session;

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public BookComment getBookComment() {
		return bookComment;
	}

	public void setBookComment(BookComment bookComment) {
		this.bookComment = bookComment;
	}

	public BookCommentService getBookCommentService() {
		return bookCommentService;
	}

	public void setBookCommentService(BookCommentService bookCommentService) {
		this.bookCommentService = bookCommentService;
	}

	
	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	@Override
	public String execute() throws Exception {
		int sessionId = (Integer) session.get("userId");
		if (bookCommentService.isNumeric0(score) == false){
			setSuccess("error");
			return SUCCESS;
		}
		int score0 = Integer.parseInt(score);
		Integer IO = new Integer(score0);
		byte score1 = IO.byteValue();
		if (score0>0 && score0<=10){
			bookCommentService.SendBookComment(sessionId, isbn, discription, score1);
			setSuccess("good");
			return SUCCESS;
		}
		else {
			setSuccess("error");
			return SUCCESS;
		}
		
	}

	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
		
	}

}
