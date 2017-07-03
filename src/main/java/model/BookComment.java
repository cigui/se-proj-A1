package model;

public class BookComment {
	private int id;
	private int isbn;
	private String discription;
	private int score;
	
	public BookComment(){
		
	}
	
	public BookComment(int id,int isbn,String discription,int score){
		this.id = id;
		this.isbn = isbn;
		this.discription = discription;
		this.score = score;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
