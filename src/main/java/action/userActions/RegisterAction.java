package action.userActions;

import java.io.File;

import action.BaseAction;
import model.User;
import service.UserService;

public class RegisterAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private int district;
	private String nickName;
	private String email;
	private String password;
	private Byte gender;
	private File avatar; 
	private String avatarContentType;
	private String avatarFileName;
	

	public int getDistrict() {
		return district;
	}


	public void setDistrict(int district) {
		this.district = district;
	}


	public String getNickName() {
		return nickName;
	}


	public void setNickName(String nickName) {
		this.nickName = nickName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Byte getGender() {
		return gender;
	}


	public void setGender(Byte gender) {
		this.gender = gender;
	}


	public File getAvatar() {
		return avatar;
	}


	public void setAvatar(File avatar) {
		this.avatar = avatar;
	}


	public String getAvatarContentType() {
		return avatarContentType;
	}


	public void setAvatarContentType(String avatarContentType) {
		this.avatarContentType = avatarContentType;
	}


	public String getAvatarFileName() {
		return avatarFileName;
	}


	public void setAvatarFileName(String avatarFileName) {
		this.avatarFileName = avatarFileName;
	}


	public UserService getUserService() {
		return userService;
	}


	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	@Override
	public String execute() throws Exception {
		try {
			User user = new User(district, nickName, password, email, gender);
			userService.register(user);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
}
