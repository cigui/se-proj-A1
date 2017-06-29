package action.order;

import java.sql.Date;

import model.Order;
import service.AppService;

public class AddOrderAction extends BaseAction {

	@Override
	public String execute() throws Exception {

		Order order = new Order();
		appService.addOrder(order);

		return SUCCESS;
	}

}
