package action;

import com.opensymphony.xwork2.ActionSupport;

public class DispatcherAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String Register() {
		return "register";
	}
	
	public String ReleaseBook() {
		return "releaseBook";
	}
	
	public String BooksNearby() {
		return "booksNearby";
	}
}
