package dao;

import java.io.File;
import java.util.List;

import model.BookRelease;
import model.Picture;

public interface BookReleaseDao {

	public Integer save(BookRelease bookRelease);

	public void delete(BookRelease bookRelease);

	public void update(BookRelease bookRelease);

	public List<BookRelease> getBookReleaseByIsbn(long isbn);
	
	public List<BookRelease> getBookReleaseById(int id);
	
	public BookRelease getBookReleaseByR_id(int r_id);
	
	public List<BookRelease> getBookReleaseByStatus();

	public List<BookRelease> getAllBookReleases();
	
	public Picture getPictureByR_id(int r_id);
	
	public boolean uploadPicture(int r_id,File file,String contentType,String fileName);

}