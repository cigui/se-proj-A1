package model;

import java.sql.Date;

public class BookRelease {
	private int r_id;
	private int id;
	private int isbn;
	private Date publishDate;
	private String discription;
	private int status;
	private int price;
	
	public BookRelease(){
		
	}
	
	public BookRelease(int id, int r_id, int isbn, Date publishDate, String discription, int status, int price ){
		this.id = id;
		this.r_id = r_id;
		this.isbn = isbn;
		this.publishDate = publishDate;
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
	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
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
