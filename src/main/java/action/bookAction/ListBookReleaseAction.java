package action.bookAction;

import java.util.ArrayList;
import java.util.List;

import action.BaseAction;
import model.BookRelease;
import service.BookReleaseService;;

public class ListBookReleaseAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private int status;
	private BookReleaseService bookReleaseService;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public BookReleaseService getBookReleaseService() {
		return bookReleaseService;
	}


	public void setBookReleaseService(BookReleaseService bookReleaseService) {
		this.bookReleaseService = bookReleaseService;
	}


	@Override
	public String execute() throws Exception {
		List<BookRelease> releaseList = new ArrayList<BookRelease>();
		if(status == 0){ //已发布图书包括未审核，审核通过和不通过
			releaseList.addAll(bookReleaseService.getBookReleaseByIdAndStatus(id, (short) -1));
			releaseList.addAll(bookReleaseService.getBookReleaseByIdAndStatus(id, (short) 0));
			releaseList.addAll(bookReleaseService.getBookReleaseByIdAndStatus(id, (short) 1));
		} else {
			releaseList.addAll(bookReleaseService.getBookReleaseByIdAndStatus(id, (short) 2));
		}
		
		request().setAttribute("release", releaseList);
		return SUCCESS;
	}
}
