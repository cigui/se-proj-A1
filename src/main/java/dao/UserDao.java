package dao;

import java.io.File;
import java.util.List;

import model.Picture;
import model.User;

public interface UserDao {

	public Integer save(User user);

	public void delete(User user);

	public void update(User user);

	public User getUserById(int id);
	
	public User getUserByEmail(String email);

	public List<User> getAllUsers();
	
	public Picture getPictureById(int id);
	
	public boolean uploadPicture(int id,File file,String contentType,String fileName);

}