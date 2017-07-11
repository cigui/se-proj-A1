package action.bookAction;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import action.BaseAction;
import model.BookComment;
import service.BookCommentService;

public class SendBookCommentAction extends BaseAction implements SessionAware{

	private static final long serialVersionUID = 1L;
	private int id;
	private long isbn;
	private String discription;
	private byte score;
	private BookComment bookComment;
	private BookCommentService sendBookCommentService;
	@SuppressWarnings("unused")
	private Map<String, Object> session;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public byte getScore() {
		return score;
	}

	public void setScore(byte score) {
		this.score = score;
	}

	public BookComment getBookComment() {
		return bookComment;
	}

	public void setBookComment(BookComment bookComment) {
		this.bookComment = bookComment;
	}

	public BookCommentService getSendBookCommentService() {
		return sendBookCommentService;
	}

	public void setSendBookCommentService(BookCommentService sendBookCommentService) {
		this.sendBookCommentService = sendBookCommentService;
	}
	
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
		
	}

	
	@Override
	public String execute() throws Exception {
		sendBookCommentService.SendBookComment(id, isbn, discription, score);
		
		return SUCCESS;
	}

}
