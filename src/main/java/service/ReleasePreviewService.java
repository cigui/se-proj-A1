package service;

import model.BookRelease;

import java.util.List;

public interface ReleasePreviewService {
    
    public Integer save(BookRelease bookRelease);

	public void delete(BookRelease bookRelease);

	public void update(BookRelease bookRelease);

	public BookRelease getBookReleaseByISBN(int ISBN);
	
	public BookRelease getBookReleaseById(int id);
	
	public BookRelease getBookReleaseByR_id(int r_id);

	public List<BookRelease> getAllBookReleases();
    
     public boolean SearchBook(String keyword);
    
}