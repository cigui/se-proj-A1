package action.userActions;

import java.util.List;

import action.BaseAction;
import model.User;
import service.UserService;;

public class AllUsersAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private UserService userService;

	public void setAppService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public String execute() throws Exception {

		List<User> users = userService.getAllUsers();
		request().setAttribute("users", users);
		return SUCCESS;
	}
}
