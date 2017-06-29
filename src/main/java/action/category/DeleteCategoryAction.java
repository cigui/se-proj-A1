package action.category;

import model.Category;
import service.AppService;

public class DeleteCategoryAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private int id;

	private AppService appService;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAppService(AppService appService) {
		this.appService = appService;
	}

	@Override
	public String execute() throws Exception {

		Order order = appService.getOrderById(id);
		appService.deleteOrder(order);

		return SUCCESS;
	}

}
