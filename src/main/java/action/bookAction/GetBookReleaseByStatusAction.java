package action.bookAction;

import java.util.List;

import action.BaseAction;
import model.BookRelease;
import service.AdminService;;

public class GetBookReleaseByStatusAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private AdminService adminService;

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	@Override
	public String execute() throws Exception {

		List<BookRelease> bookReleases = adminService.getBookReleaseByStatus();
		request().setAttribute("bookrelease", bookReleases);
		return SUCCESS;
	}
}
