package action.bookAction;

import java.io.File;
import java.sql.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import action.BaseAction;
import model.BookRelease;
import service.BookReleaseService;

public class ReleaseBookAction extends BaseAction implements SessionAware {
	/**
	 * Modified on 7th, July, 2017
	 * By: Zhou Xin
	 */
	private static final long serialVersionUID = 1L;
	
	private long isbn;
	private String discription;
	private int price;
	private Date publishDate;
	private Integer category1;
	private Integer category2;
	private Integer category3;
	private File image;
	private String imageContentType;
	private String imageFileName;
	private BookReleaseService bookReleaseService;
	private Map<String, Object> session;
	
	
	public long getIsbn() {
		return isbn;
	}


	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public Date getPublishDate() {
		return publishDate;
	}


	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
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


	public String getDiscription() {
		return discription;
	}


	public void setDiscription(String discription) {
		this.discription = discription;
	}


	public File getImage() {
		return image;
	}


	public void setImage(File image) {
		this.image = image;
	}


	public String getImageContentType() {
		return imageContentType;
	}


	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}


	public String getImageFileName() {
		return imageFileName;
	}


	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public BookReleaseService getBookReleaseService() {
		return bookReleaseService;
	}


	public void setBookReleaseService(BookReleaseService bookReleaseService) {
		this.bookReleaseService = bookReleaseService;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public String execute() throws Exception {
		try {
			int userId = (Integer)session.get("userId");
			BookRelease bookRelease = new BookRelease(userId, isbn, publishDate, discription, price, category1, category2, category3);
			if (!bookReleaseService.ReleaseBook(bookRelease)) {
				return ERROR;
			};
			if (image != null) {
				bookReleaseService.uploadImage(bookRelease.getR_id(), image, imageContentType, imageFileName);
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}



}
