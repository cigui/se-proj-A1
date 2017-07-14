package model;

import java.io.Serializable;

public class BorrowItem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int r_id;
	
	public BorrowItem(){
		
	}
	
	public BorrowItem(int id, int r_id){
		this.id = id;
		this.r_id = r_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getR_id() {
		return r_id;
	}

	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
}
