package model;

public class BorrowComment {
	private int h_id;
	private Integer score;
	private String borrowComment;
	
	public BorrowComment(){
		
	}

	public BorrowComment(int h_id, Integer score, String borrowComment ){
		this.h_id = h_id;
		this.score = score;
		this.borrowComment = borrowComment;
		
	}

	public int getH_id() {
		return h_id;
	}

	public void setH_id(int h_id) {
		this.h_id = h_id;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getBorrowComment() {
		return borrowComment;
	}

	public void setBorrowComment(String borrowComment) {
		this.borrowComment = borrowComment;
	}
	
}
