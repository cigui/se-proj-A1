package action.bookAction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import action.BaseAction;
import model.Book;
import service.BookService;

public class GetPagedBooksAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BookService bookService;
	private int cate;
	private int draw;
	private int start;
	private int length;
	private Map<String, Object> resultMap = new HashMap<String, Object>();
	
	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public int getCate() {
		return cate;
	}

	public void setCate(int cate) {
		this.cate = cate;
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

	public String byCategory() {
		
		/* 从数据库中取出限制条数的数据 */
		List<Book> result = bookService.getBooksByCategoryLimits(cate, start, length);
		
		/* 总条数 */
		/* 
		 * 这里还有疑问，如果每次调用获取分页数据的action都要count一下性能不会很好，但不设置count
		 * 的话前端页面不能正常显示，暂时先这么写着。
		 */
		int count = bookService.countBooksInCategory(cate);
		
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
