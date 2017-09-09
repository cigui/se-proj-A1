package service.impl;

import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import model.Picture;
import dao.BorrowHistoryDao;
import dao.BorrowItemDao;
import dao.BookReleaseDao;
import dao.BookCateRelationshipDao;
import dao.UserDao;
import model.User;
import model.BorrowItem;
import model.BorrowHistory;
import service.UserService;
import utils.MD5Util;
import utils.EmailUtil;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	private BorrowItemDao borrowItemDao;
	private BorrowHistoryDao borrowHistoryDao;
	private BookReleaseDao bookReleaseDao;
	private BookCateRelationshipDao bookCateRelationshipDao;
	private String activateUrl;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public BorrowItemDao getBorrowItemDao() {
		return borrowItemDao;
	}

	public void setBorrowItemDao(BorrowItemDao borrowItemDao) {
		this.borrowItemDao = borrowItemDao;
	}

	public BorrowHistoryDao getBorrowHistoryDao() {
		return borrowHistoryDao;
	}

	public void setBorrowHistoryDao(BorrowHistoryDao borrowHistoryDao) {
		this.borrowHistoryDao = borrowHistoryDao;
	}

	public BookReleaseDao getBookReleaseDao() {
		return bookReleaseDao;
	}

	public void setBookReleaseDao(BookReleaseDao bookReleaseDao) {
		this.bookReleaseDao = bookReleaseDao;
	}

	public BookCateRelationshipDao getBookCateRelationshipDao() {
		return bookCateRelationshipDao;
	}

	public void setBookCateRelationshipDao(BookCateRelationshipDao bookCateRelationshipDao) {
		this.bookCateRelationshipDao = bookCateRelationshipDao;
	}

	public String getActivateUrl() {
		return activateUrl;
	}

	public void setActivateUrl(String activateUrl) {
		this.activateUrl = activateUrl;
	}

	public Integer save(User user) {
		return userDao.save(user);
	}

	public void delete(User user) {
		userDao.delete(user);
	}

	public void update(User user) {
		userDao.update(user);
	}

	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

	public Picture getPictureById(int id){
	    	return userDao.getPictureById(id);
	    }
	  
	public User getUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}

	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	public boolean isAdmin(User user) {
		// int of admin setted 2
		if (user.getRole() == 2) {
			return true;
		} else {
			return false;
		}
	}

	public boolean login(String email, String password) {
		User u = userDao.getUserByEmail(email);
		if (u != null) {
			String TruePwd = u.getPassword();
			if (TruePwd.equals(password)) {
				return true;
			}
		}
		return false;
	}

	public boolean dupEmail(String email) {
		if (getUserByEmail(email) != null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean uploadImage(int id, File image, String contentType, String fileName) {
		return userDao.uploadPicture(id, image, contentType, fileName);
	}

	public boolean register(User user) throws AddressException, MessagingException {
		if (getUserByEmail(user.getEmail()) != null) {
			return false;
		}

		/* 将用户邮箱和密码进行加密并发送验证邮件 */
		String dest = user.getEmail();
		String token = dest + user.getPassword();
		String md5Token = MD5Util.MD5(token);
		user.setToken(md5Token);
		String title = "欢迎来到阅享";
		String content = "<p>您好，" + user.getNickname() + "！</p><br/><br/>账户需要激活才能使用，请在24小时内点击下面的链接激活：<br/><a href='"
				+ activateUrl + "?token=" + md5Token + "&email=" + dest + "'>"
				+ activateUrl + "?token=" + md5Token + "&email=" + dest + "</a>";
		EmailUtil.sendMail(dest, title, content);

		/* 设置激活期限，限制一天内完成激活 */
		java.util.Date date = new java.util.Date(System.currentTimeMillis());
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 1);// 把日期往后增加一天.整数往后推,负数往前移动
		Date activateDue = new Date(calendar.getTime().getTime()); // 这个时间就是日期往后推一天的结果
		user.setActivateDue(activateDue);
		
		/* 将用户信息存入数据库 */
		int userId = userDao.save(user);
		user.setId(userId);
		return true;
	}

	public boolean activateUser(String token, String email) {
		User u = userDao.getUserByEmail(email);
		if (u == null) {
			return false;
		}
		if (!u.getToken().equals(token)) {
			return false;
		}

		/* 只将状态为"未激活"的用户状态设置为"已激活"，防止将管理员或被封禁用户设置为"已激活" */
		if (u.getRole() == 0) {
			u.setRole(1);
			/* 重新设置token防止重复激活 */
			u.setToken("ACTIVATED");
			userDao.update(u);
		}
		return true;
	}

	public void manageUser(int id, int status) {
		User u = getUserById(id);
		if (!isAdmin(u)) {
			if (status == 0) {
				u.setRole(-1);
				update(u);
			} else if (status == 1) {
				u.setRole(1);
				update(u);
			}
		}
	}

	public void updateFavCate(User user) {
		int id = user.getId();
		List<BorrowHistory> bhList = borrowHistoryDao.getBorrowHistoryById(id);
		List<BorrowItem> biList = borrowItemDao.getBorrowItemById(id);
		List<Long> isbnList = new ArrayList<Long>();
		
		//get recent 5 records in borrow history
		if (bhList != null) {
			int s = bhList.size() - 5 > 0 ? bhList.size() - 5 : 0;
			for(int i = s;i < bhList.size();i++){
				int rid = bhList.get(i).getR_id();
				long isbn = bookReleaseDao.getBookReleaseByR_id(rid).getIsbn();
				isbnList.add(isbn);
			}
		}
		
		//get recent 5 records in borrow item
		if (biList != null) {
			int s = biList.size() - 5 > 0 ? biList.size() - 5 : 0;
			for(int i = s;i < biList.size();i++){
				int rid = biList.get(i).getR_id();
				long isbn = bookReleaseDao.getBookReleaseByR_id(rid).getIsbn();
				isbnList.add(isbn);
			}
		}
		
		//count frequency of each category
		Map<Integer,Integer> cateCount = new HashMap<Integer,Integer>();
		for (int i = 0; i < isbnList.size(); i++) {
			List<Integer> cates = bookCateRelationshipDao.getCategoriesIdByIsbn(isbnList.get(i));
			if (cates != null) {
				for (int j = 0; j < cates.size(); j++) {
					int cate = cates.get(j);
					if (cateCount.containsKey(cate)) {
						int count = cateCount.get(cate) + 1;
						cateCount.put(cate, count);
					} else {
						cateCount.put(cate, 1);
					}
				}
			}
		}
		
		//get most frequent category
		Integer maxCate = null;
		Integer count = 0;
		Iterator<Entry<Integer, Integer>> it = cateCount.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, Integer> entry = it.next();
			Integer key = entry.getKey();
			Integer value = entry.getValue();
			
			if (value > count) {
				maxCate = key;
				count = value;
			}
		}

		user.setFav_category(maxCate);
		userDao.update(user);
	}

}
