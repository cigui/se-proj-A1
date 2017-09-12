package action.userActions;

import java.util.Map;
import action.BaseAction;
import model.User;
import service.DistrictService;
import service.UserService;
import org.apache.struts2.interceptor.SessionAware;

public class GetBeforeUpdatePasswordAction extends BaseAction implements SessionAware{
	/**
	 * Modified on 7th, July, 2017
	 * By Yu Haifeng
	 */
	private static final long serialVersionUID = 1L;//用于版本控制 
	private UserService userService;
	private DistrictService districtService;
	private Map<String, Object> session;
	
	
	
	public UserService getUserService() {
		return userService;
	}


	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public DistrictService  getDistrictService() {
		return districtService;
	}


	public void setDistrictService(DistrictService districtService) {
		this.districtService = districtService;
	}
	
	
	
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String execute() throws Exception {
			int id = (Integer) session.get("userId");
			User user = userService.getUserById(id);
			request().setAttribute("user", user);
			
			
			
			return SUCCESS;
		}
	}

