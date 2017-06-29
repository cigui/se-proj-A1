package action.book;

import java.sql.Date;

import model.Book;
import service.AppService;

public class AddBookAction extends BaseAction {


	@Override
	public String execute() throws Exception {

		Book book = new Book();
		appService.addBook(book);
		return SUCCESS;
	}

}
