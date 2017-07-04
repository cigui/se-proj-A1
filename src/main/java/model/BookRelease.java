package model;

import java.sql.Date;

public class BookRelease {
	private int r_id;
	private int id;
	private int isbn;
	private Date publish_date;
	private String discription;
	private int status;
	private int price;
	
	public BookRelease(){
		
	}
	
	public BookRelease(int id, int r_id, int isbn, Date publish_date, String discription, int status, int price ){
		this.id = id;
		this.r_id = r_id;
		this.isbn = isbn;
		this.publish_date = publish_date;
		this.discription = discription;
		this.status = status;
		this.price = price;
		
	}

	public int getR_id() {
		return r_id;
	}

	public void setR_id(int r_id) {
		this.r_id = r_id;
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
	public Date getPublish_date() {
		return publish_date;
	}

	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	

}
