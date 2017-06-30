package model;

import java.sql.Timestamp;

public class BorrowHistory {
	private int orderStatus;
	private char location;
	private Timestamp date;
	private int id;
	private int h_id;
	private int r_id;
	
	public BorrowHistory(){
		
	}
	
	public BorrowHistory(int orderStatus,char location,Timestamp date, int id, int h_id,int r_id){
		this.setOrderStatus(orderStatus);
		this.setLocation(location);
		this.setDate(date);
		this.setId(id);
		this.setH_id(h_id);
		this.setR_id(r_id);
		
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public char getLocation() {
		return location;
	}

	public void setLocation(char location) {
		this.location = location;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getH_id() {
		return h_id;
	}

	public void setH_id(int h_id) {
		this.h_id = h_id;
	}

	public int getR_id() {
		return r_id;
	}

	public void setR_id(int r_id) {
		this.r_id = r_id;
	}

}