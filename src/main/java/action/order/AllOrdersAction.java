package action.order;

import java.util.List;

import model.Order;
import model.User;
import service.AppService;

public class AllOrdersAction extends BaseAction {

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
