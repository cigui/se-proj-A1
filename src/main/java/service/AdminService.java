package service;

import model.User;

import model.BookRelease;

import java.util.List;

public interface AdminService {
    public Integer save(User user);

	public void delete(User user);

	public void update(User user);

	public User getUserById(int id);
	
	public User getUserByEmail(String email);

	public List<User> getAllUsers();
    
	public Integer save(BookRelease bookRelease);

	public void delete(BookRelease bookRelease);

	public void update(BookRelease bookRelease);

	public List<BookRelease> getBookReleaseByStatus(int status);

	public List<BookRelease> getAllBookReleases();
	
	public void checkBook(BookRelease bookRelease,short status);
    

}
