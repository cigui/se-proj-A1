package action.userActions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import action.BaseAction;
import model.District;
import model.User;
import model.BookRelease;
import model.BorrowItem;
import service.DistrictService;
import service.BookReleaseService;
import service.UserService;
import org.apache.struts2.interceptor.SessionAware;

public class UpdateLocationAction extends BaseAction implements SessionAware{
	/**
	 * Modified on 6th, July, 2017
	 * By Yu Haifeng
	 */
	private static final long serialVersionUID = 1L;//用于版本控制 
	private UserService userService;
	private BookReleaseService bookReleaseService;
	private DistrictService districtService;
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


	public BookReleaseService getBookReleaseService() {
		return bookReleaseService;
	}


	public void setBookReleaseService(BookReleaseService bookReleaseService) {
		this.bookReleaseService = bookReleaseService;
	}


	public DistrictService getDistrictService() {
		return districtService;
	}


	public void setDistrictService(DistrictService districtService) {
		this.districtService = districtService;
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
			User user = userService.getUserByEmail(email);
	        user.setL_id(district);
			//user.setNickname(nickName);
	        //user.setPassword(password);		
	        //user.setGender(gender);
			userService.update(user);
			District district = districtService.getDistrictById(user.getL_id());
			List<BookRelease> br = bookReleaseService.getBookReleaseById(user.getId());
			for (BookRelease item : br) {
				item.setDistrictCode(district.getCode());
				item.setCityCode((district.getCode()/100)*100);
				bookReleaseService.update(item);
			}
					
			session.put("logined", true);
			session.put("userName", user.getNickname());
			session.put("userId", user.getId()); 
			session.put("role", user.getRole()); 
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

}