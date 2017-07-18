package model;

/* 用于包装简化的书籍信息以供分页显示 */

public class PagedBookInfo {
	private long isbn;
	private String author;
	private String titleHref;
	
	public PagedBookInfo(long isbn, String author, String title) {
		this.isbn = isbn;
		this.author = author;
		this.titleHref = "<a href='bookdetails?isbn=" + isbn + "'>" + title + "</a>";
	}
	
	public long getIsbn() {
		return isbn;
	}
	public void setIsbn(long isbn) {
		this.isbn = isbn;
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
}