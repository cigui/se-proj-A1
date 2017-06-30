package model;

public class BookComment {
	private int id;
	private int ISBN;
	private char discription;
	private int score;
	
	public BookComment(){
		
	}
	
	public BookComment(int id,int ISBN,char discription,int score){
		this.setId(id);
		this.setISBN(ISBN);
		this.setDiscription(discription);
		this.setScore(score);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public char getDiscription() {
		return discription;
	}

	public void setDiscription(char discription) {
		this.discription = discription;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
