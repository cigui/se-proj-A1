package model;

/* 用于包装简化的书籍发布信息以供分页显示 */

public class PagedBookReleaseInfo {
	private String author;
	private String titleHref;
	private int price;
	
	public PagedBookReleaseInfo(int r_id, String author, String title, int price){
		this.author = author;
		this.titleHref = "<a href='releaseDetail?r_id=" + r_id + "'>" + title + "</a>";
		this.price = price;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getTitleHref() {
		return titleHref;
	}
	public void setTitleHref(String titleHref) {
		this.titleHref = titleHref;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
