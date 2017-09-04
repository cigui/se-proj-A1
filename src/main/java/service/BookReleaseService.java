package service;

import model.BookRelease;
import model.PagedBookReleaseInfo;
import model.Picture;

import java.io.File;
import java.util.List;

public interface BookReleaseService {
	
	public List<BookRelease> getBookReleaseByISBN(long ISBN);
	
	public List<BookRelease> getBookReleaseById(int id);
	
	public List<BookRelease> getBookReleaseByIdAndStatus(int id, short status);
	
	/* 
	 * 获取指定地区行政编码的图书发布信息的简要信息
	 */
	public List<PagedBookReleaseInfo> getPagedBookReleaseInfoByCode(Integer code, int start, int length);
	
	public int countBookReleasesByCode(Integer code);
	
	public BookRelease getBookReleaseByR_id(int r_id);

	public List<BookRelease> getAllBookReleases();
      
    public boolean ReleaseBook(BookRelease bookRelease);
    
    public boolean uploadImage(int id, File image, String contentType, String fileName);
    
    public Picture getPictureByR_id(int r_id);
    
}