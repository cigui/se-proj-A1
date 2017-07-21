package model;

import java.sql.Timestamp;

public class BorrowHistory {
	private int orderStatus; // 0: not sent, 1: sent but not got, 2: got but not scored, 3: scored
	private String location;
	private Timestamp date;
	private Integer id;
	private int h_id;
	private Integer r_id;
	private Byte score;
	
	public BorrowHistory(){
		
	}
	
	public BorrowHistory(int orderStatus,String location, Integer id, Integer r_id){
		this.orderStatus = orderStatus;
		this.location = location;
		this.id = id;
		this.r_id = r_id;
		this.date = new Timestamp(System.currentTimeMillis()); 
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getH_id() {
		return h_id;
	}

	public void setH_id(int h_id) {
		this.h_id = h_id;
	}

	public Integer getR_id() {
		return r_id;
	}

	public void setR_id(Integer r_id) {
		this.r_id = r_id;
	}

	public Byte getScore() {
		return score;
	}

	public void setScore(Byte score) {
		this.score = score;
	}

}