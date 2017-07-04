package action.userActions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import action.BaseAction;

public class LogoutAction extends BaseAction implements SessionAware {
	/**
	 * Created on July 3rd, 2017
	 * By Zhou Xin
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
	
	@Override
	public String execute() throws Exception {
		session.remove("logined");
		session.remove("userName");
		session.remove("isAdmin");
		return SUCCESS;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
