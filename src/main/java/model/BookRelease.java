package model;

import java.sql.Date;

public class BookRelease {
	private int r_id;
	private int id;
	private long isbn;
	private Date publish_date;
	private String discription;
	private short status; // 0:not checked, 1:pass, -1:rejected, 2:borrowed
	private int price;
	private Integer cityCode;
	private Integer districtCode;
	private Integer category1;
	private Integer category2;
	private Integer category3;

	public BookRelease() {

	}

	public BookRelease(int id, long isbn, Date publish_date, String discription, int price, Integer category1,
			Integer category2, Integer category3) {
		this.id = id;
		this.isbn = isbn;
		this.publish_date = publish_date;
		this.discription = discription;
		this.price = price;
		this.status = 0; /* 已发布，未审核 */
		this.category1 = category1;
		this.category2 = category2;
		this.category3 = category3;
	}

	public BookRelease(int id, int r_id, long isbn, Date publish_date, String discription, short status, int price) {
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

	public void setStatus(short i) {
		this.status = i;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Integer getCityCode() {
		return cityCode;
	}

	public void setCityCode(Integer cityCode) {
		this.cityCode = cityCode;
	}

	public Integer getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(Integer districtCode) {
		this.districtCode = districtCode;
	}

	public Integer getCategory1() {
		return category1;
	}

	public void setCategory1(Integer category1) {
		this.category1 = category1;
	}

	public Integer getCategory2() {
		return category2;
	}

	public void setCategory2(Integer category2) {
		this.category2 = category2;
	}

	public Integer getCategory3() {
		return category3;
	}

	public void setCategory3(Integer category3) {
		this.category3 = category3;
	}

}
