package action.userActions;

import java.util.Map;
import action.BaseAction;
import model.User;
import model.District;
import service.DistrictService;
import service.UserService;
import org.apache.struts2.interceptor.SessionAware;

public class GetUserProfileAction extends BaseAction implements SessionAware{
	/**
	 * Modified on 21th, July, 2017
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
			int l_id = user.getL_id();
			request().setAttribute("user", user);
			District district = districtService.getDistrictById(l_id);
			int city_id = district.getParent_id();
			District city = districtService.getDistrictById(city_id);
			int province_id = city.getParent_id();
			District province = districtService.getDistrictById(province_id);
			request().setAttribute("distrcit", district);
			request().setAttribute("city", city);
			request().setAttribute("province", province);
			
			
			return SUCCESS;
		}
	}

