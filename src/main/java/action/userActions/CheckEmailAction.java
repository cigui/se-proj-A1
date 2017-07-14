package action.userActions;

import java.util.HashMap;
import java.util.Map;

import action.BaseAction;
import service.UserService;

public class CheckEmailAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String email;
	private UserService userService;
	private Map<String, Object> result = new HashMap<String, Object>();
	
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
	

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	public String execute() {
		if (userService.dupEmail(email)) {
			result.put("dup", true);
		}
		return SUCCESS;
	}
}
