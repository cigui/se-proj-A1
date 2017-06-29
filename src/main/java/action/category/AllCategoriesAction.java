package action.category;

import java.util.List;

import model.Category;
import service.AppService;

public class AllCategoriesAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private AppService appService;

	public void setAppService(AppService appService) {
		this.appService = appService;
	}

	@Override
	public String execute() throws Exception {

		List<Order> orders = appService.getAllOrders();
		request().setAttribute("orders", orders);

		List<User> users = appService.getAllUsers();
		request().setAttribute("users", users);

		return SUCCESS;
	}
}
