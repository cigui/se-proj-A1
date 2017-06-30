package model;

public class BorrowComment {
	private int h_id;
	private int score;
	private char borrowComment;
	
	public BorrowComment(){
		
	}

	public BorrowComment(int h_id, int score, char borrowComment ){
		this.setH_id(h_id);
		this.setScore(score);
		this.setBorrowComment(borrowComment);
		
	}

	public int getH_id() {
		return h_id;
	}

	public void setH_id(int h_id) {
		this.h_id = h_id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public char getBorrowComment() {
		return borrowComment;
	}

	public void setBorrowComment(char borrowComment) {
		this.borrowComment = borrowComment;
	}
	
}
