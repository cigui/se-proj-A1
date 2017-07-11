package model;

import java.io.Serializable;

public class BookCateRelationship implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long isbn;
	private int cate_id;
	
	public BookCateRelationship(){
		
	}
	
	public BookCateRelationship(long isbn,int cate_ID){
		this.isbn = isbn;
		this.cate_id = cate_ID;
	}
	
	public long getIsbn() {
		return isbn;
	}
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}
	public int getCate_id() {
		return cate_id;
	}
	public void setCate_id(int cate_ID) {
		this.cate_id = cate_ID;
	}

}
