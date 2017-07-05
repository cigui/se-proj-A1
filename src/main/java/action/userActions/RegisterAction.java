package action.userActions;

import java.io.File;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import action.BaseAction;
import model.User;
import service.UserService;

public class RegisterAction extends BaseAction implements SessionAware {
	
	/**
	 * Modified on 5th, July, 2017
	 * By Zhou Xin
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
	private Map<String, Object> session;

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

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public String execute() throws Exception {
		try {
			User user = new User(district, nickName, password, email, gender);
			userService.register(user);
			if (avatar != null){
				userService.uploadImage(user.getId(),avatar, avatarFileName, avatarContentType);
			}
			session.put("logined", true);
			session.put("userName", user.getNickname());
			session.put("userId", user.getId()); 
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

}
