package action.userActions;

import java.io.InputStream;
import action.BaseAction;
import service.UserService;
import model.Picture;


public class GetPictureAction extends BaseAction {
	/**
	 * Modified on 11th, July, 2017
	 * By: Yu Haifeng
	 */
	private static final long serialVersionUID = 1L;
	
	private UserService userService;
	private String contentType;
	private InputStream inputStream;
	private int id;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
   public int getId(int id){
	   return id;
   }
   
	
	public void setId(int id) {
		this.id = id;
	}
	
	public InputStream getInputStream() {		
		return inputStream;
		}
	
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	public String getContentType() {
		   return contentType;
		}
	
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	@Override
	public String execute() throws Exception {
		Picture picture = userService.getPictureById(id);
		InputStream inputStream = picture.getInputStream();
		setInputStream(inputStream);
		String contentType = picture.getContentType();
		setContentType(contentType);
		
		return SUCCESS;
	}
}