package model;

public class BookCateRelationship {
	private int isbn;
	private int cate_ID;
	
	public BookCateRelationship(){
		
	}
	
	public BookCateRelationship(int isbn,int cate_ID){
		this.isbn = isbn;
		this.cate_ID = cate_ID;
	}
	
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public int getCate_ID() {
		return cate_ID;
	}
	public void setCate_ID(int cate_ID) {
		this.cate_ID = cate_ID;
	}

}
