package action.bookAction;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import action.BaseAction;
import model.BookRelease;
import service.AdminService;

public class CheckBookAction extends BaseAction implements SessionAware {
	
	private static final long serialVersionUID = 1L;
	private short status;
	private int r_id;
	private BookRelease bookRelease;
	private AdminService adminService;
	@SuppressWarnings("unused")
	private Map<String, Object> session;
	
	
	public short getStatus() {
		return status;
	}
	
	public void setStatus(short status) {
		this.status = status;
	}
	
	public BookRelease getBookRelease() {
		return bookRelease;
	}
	
	public void setBookRelease(BookRelease bookRelease) {
		this.bookRelease = bookRelease;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
		
	}
	
	public String execute() throws Exception {
		adminService.checkBook(r_id, status);
		return SUCCESS;
	}

	public int getR_id() {
		return r_id;
	}

	public void setR_id(int r_id) {
		this.r_id = r_id;
	}

}
