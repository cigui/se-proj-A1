package model;

public class BookCateRelationship {
	private int ISBN;
	private int cate_ID;
	
	public BookCateRelationship(){
		
	}
	
	public BookCateRelationship(int ISBN,int cate_ID){
		this.ISBN = ISBN;
		this.cate_ID = cate_ID;
	}
	
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	public int getCate_ID() {
		return cate_ID;
	}
	public void setCate_ID(int cate_ID) {
		this.cate_ID = cate_ID;
	}

}
