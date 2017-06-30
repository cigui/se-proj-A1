package model;

import java.sql.Date;

public class BookRelease {
	private int r_id;
	private int id;
	private int ISBN;
	private Date publishDate;
	private char discription;
	private int status;
	private int price;
	
	public BookRelease(){
		
	}
	
	public BookRelease(int id, int r_id, int ISBN, Date publishDate, char discription, int status, int price ){
		this.setId(id);
		this.setR_id(r_id);
		this.setISBN(ISBN);
		this.setPublishDate(publishDate);
		this.setDiscription(discription);
		this.setStatus(status);
		this.setPrice(price);
		
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

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public char getDiscription() {
		return discription;
	}

	public void setDiscription(char discription) {
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
