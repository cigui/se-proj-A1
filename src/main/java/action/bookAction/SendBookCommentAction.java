package action.bookAction;


import action.BaseAction;
import model.BookComment;
import service.BookCommentService;

public class SendBookCommentAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	private int id;
	private long isbn;
	private String discription;
	private byte score;
	private BookComment bookComment;
	private BookCommentService sendBookCommentService;

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

	
	@Override
	public String execute() throws Exception {
		
		sendBookCommentService.SendBookComment(id, isbn, discription, score);
		
		return SUCCESS;
	}

}
