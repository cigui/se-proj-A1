package action.bookAction;

import action.BaseAction;
import model.BorrowItem;
import service.AddBookToCartService;

public class AddBookToCartAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int r_id;
	private String success;
	private AddBookToCartService addBookToCartService;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getR_id() {
		return r_id;
	}

	public void setR_id(int r_id) {
		this.r_id = r_id;
	}

	public AddBookToCartService getAddBookToCartService() {
		return addBookToCartService;
	}

	public void setAddBookToCartService(AddBookToCartService addBookToCartService) {
		this.addBookToCartService = addBookToCartService;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String execute() throws Exception {
		BorrowItem borrowItem = new BorrowItem(id, r_id);
		if(addBookToCartService.AddBookToCart(borrowItem)){
			addBookToCartService.save(borrowItem);
			setSuccess("good");
		}
		else{
			setSuccess("error");
		}
		return SUCCESS;
		
	}
		
	
}
