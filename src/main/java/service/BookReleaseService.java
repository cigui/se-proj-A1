package service;

import model.BookRelease;

import java.io.File;
import java.util.List;

public interface BookReleaseService {
	
	public List<BookRelease> getBookReleaseByISBN(long ISBN);
	
	public List<BookRelease> getBookReleaseById(int id);
	
	public BookRelease getBookReleaseByR_id(int r_id);

	public List<BookRelease> getAllBookReleases();
      
    public boolean ReleaseBook(BookRelease bookRelease);
    
    public boolean uploadImage(int id, File image, String contentType, String fileName);
    
}