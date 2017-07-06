package action.userActions;

import action.BaseAction;
import service.UserService;

public class ManageUserAction extends BaseAction {

	/**
	 * Created on July 6th, 2017 By Xia Jiasheng
	 */
	private static final long serialVersionUID = 1L;

	private UserService userService;
	private int id;
	private int status;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String execute() throws Exception {
		userService.manageUser(id, status);
		return SUCCESS;
	}

}
