package service;

import model.User;

import java.util.List;

/*log in ¡¢log out¡¢register¡¢updateUserInformation*/
public interface UserService {
    public Integer save(User user);

	public void delete(User user);

	public void update(User user);

	public User getUserById(int id);

	public List<User> getAllUsers();
    
    public void isAdmin(User user);
    
    public boolean login(String email,String password);
    
    public boolean register(String nickname,String email,String password);
   
    public boolean dupEmail(String email,User user);
    
    public boolean uploadImage();
   
}

