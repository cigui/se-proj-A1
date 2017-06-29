package action.category;

import java.sql.Date;

import model.Category;
import service.AppService;

public class AddCategoryAction extends BaseAction {

	@Override
	public String execute() throws Exception {

		Order order = new Order();
		appService.addOrder(order);

		return SUCCESS;
	}

}
