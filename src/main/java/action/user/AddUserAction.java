package action.user;

import model.User;
import service.AppService;

public class AddUserAction extends BaseAction {

	@Override
	public String execute() throws Exception {

		User user = new User();
		appService.addUser(user);

		return SUCCESS;
	}

}
