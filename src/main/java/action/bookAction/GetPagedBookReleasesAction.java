package action.bookAction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import action.BaseAction;
import model.PagedBookReleaseInfo;
import service.BookReleaseService;

public class GetPagedBookReleasesAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BookReleaseService bookReleaseService;
	private Integer code;
	private int draw;
	private int start;
	private int length;
	private Map<String, Object> resultMap = new HashMap<String, Object>();
	
	public BookReleaseService getBookReleaseService() {
		return bookReleaseService;
	}
	public void setBookReleaseService(BookReleaseService bookReleaseService) {
		this.bookReleaseService = bookReleaseService;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public int getDraw() {
		return draw;
	}
	public void setDraw(int draw) {
		this.draw = draw;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public Map<String, Object> getResultMap() {
		return resultMap;
	}
	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}
	
	public String byCode() {
		/* 从数据库中取出限制条数的数据 */
		List<PagedBookReleaseInfo> result = bookReleaseService.getPagedBookReleaseInfoByCode(code, start, length);
		
		/* 总条数 */
		int count = bookReleaseService.countBookReleasesByCode(code);
		
		/* 
		 * 这里的data和前端js中设置的dataSrc:"data"相对应， draw提示datatables重新画表格，
		 * 两个records记录表示总共有多少条数据
		 */
		resultMap.put("data", result);
		resultMap.put("draw", draw);
		resultMap.put("recordsFiltered", count);
		resultMap.put("recordsTotal", count);
		
		return SUCCESS;
	}
}
