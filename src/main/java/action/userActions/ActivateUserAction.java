package action.userActions;

import action.BaseAction;
import service.UserService;

public class ActivateUserAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String token;
	private String email;
	private UserService userService;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String execute() {
		if (userService.activateUser(token, email)) {
			return SUCCESS;
		}
		return ERROR;
	}
}
