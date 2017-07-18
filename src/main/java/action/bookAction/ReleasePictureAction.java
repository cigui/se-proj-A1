package action.bookAction;

import java.io.InputStream;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import action.BaseAction;
import model.Picture;
import service.BookReleaseService;

public class ReleasePictureAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int r_id;
	private BookReleaseService bookReleaseService;
	private GridFsTemplate gridFsTemplate;
	private InputStream inputStream;
	private String contentType;
	
	public int getR_id() {
		return r_id;
	}
	
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}

	public BookReleaseService getBookReleaseService() {
		return bookReleaseService;
	}

	public void setBookReleaseService(BookReleaseService bookReleaseService) {
		this.bookReleaseService = bookReleaseService;
	}

	public GridFsTemplate getGridFsTemplate() {
		return gridFsTemplate;
	}

	public void setGridFsTemplate(GridFsTemplate gridFsTemplate) {
		this.gridFsTemplate = gridFsTemplate;
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

	public String execute() throws Exception {
		    Picture picture = bookReleaseService.getPictureByR_id(r_id);
		    setInputStream(picture.getInputStream());
		    setContentType(picture.getContentType());
			return SUCCESS;
		}

}
