package dao;

import java.util.List;

import model.BookRelease;

public interface BookReleaseDao {

	public Integer save(BookRelease bookRelease);

	public void delete(BookRelease bookRelease);

	public void update(BookRelease bookRelease);

	public List<BookRelease> getBookReleaseByIsbn(int isbn);
	
	public List<BookRelease> getBookReleaseById(int id);
	
	public BookRelease getBookReleaseByR_id(int r_id);
	
	public List<BookRelease> getBookReleaseByStatus(int status);

	public List<BookRelease> getAllBookReleases();

}