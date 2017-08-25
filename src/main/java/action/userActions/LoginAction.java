package action.userActions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import action.BaseAction;
import model.User;
import service.UserService;

public class LoginAction extends BaseAction implements SessionAware {

	/**
	 * Created on July 3rd, 2017
	 * By Zhou Xin
	 */
	private static final long serialVersionUID = 1L;
	private String email;
	private String pwd;
	private Map<String, Object> session;
	private UserService userService;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

	@Override
	public String execute() throws Exception {
		if (userService.login(email, pwd)) {
			User u = userService.getUserByEmail(email);
			session.put("logined", true);
			session.put("userName", u.getNickname());
			session.put("userId", u.getId());
			session.put("role", u.getRole());
			if (userService.isAdmin(u)){
				session.put("isAdmin", true);
			}
			
			//Recommend
			userService.updateFavCate(u);
			
			return SUCCESS;
		}
		return ERROR;
	}

}
