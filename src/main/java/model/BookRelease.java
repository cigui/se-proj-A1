package model;

import java.sql.Date;

public class BookRelease {
	private int r_id;
	private int id;
	private long isbn;
	private Date publish_date;
	private String discription;
	private short status;
	private int price;
	
	public BookRelease(){
		
	}
	
	public BookRelease(int id, long isbn,Date publish_date, String discription, int price) {
		this.id = id;
		this.isbn = isbn;
		this.publish_date = publish_date;
		this.discription = discription;
		this.price = price;
		this.status = 0; /* 已发布，未审核 */
	}
	
	public BookRelease(int id, int r_id, long isbn, Date publish_date, String discription, short status, int price ){
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

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
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

	public short getStatus() {
		return status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
