package model;

import java.io.Serializable;

public class BookComment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private long isbn;
	private String discription;
	private byte score;
	
	public BookComment(){
		
	}
	
	public BookComment(int id,long isbn,String discription,byte score){
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

}
