package service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

import com.google.gson.Gson;

import dao.BookDao;
import dao.BookReleaseDao;
import model.Book;
import model.BookRelease;
import model.Picture;
import service.BookReleaseService;

public class BookReleaseServiceImpl implements BookReleaseService {

	private BookReleaseDao bookReleaseDao;
	private BookDao bookDao;
	
	public BookReleaseDao getBookReleaseDao() {
		return bookReleaseDao;
	}

	public void setBookReleaseDao(BookReleaseDao bookReleaseDao) {
		this.bookReleaseDao = bookReleaseDao;
	}

	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public List<BookRelease> getBookReleaseByISBN(long ISBN) {
		return bookReleaseDao.getBookReleaseByIsbn(ISBN);
	}

	public List<BookRelease> getBookReleaseById(int id) {
		return bookReleaseDao.getBookReleaseById(id);
	}

	public BookRelease getBookReleaseByR_id(int r_id) {
		return bookReleaseDao.getBookReleaseByR_id(r_id);
	}

	public List<BookRelease> getAllBookReleases() {
		return bookReleaseDao.getAllBookReleases();
	}

	@SuppressWarnings("unchecked")
	public boolean ReleaseBook(BookRelease bookRelease) {
		try {
			/* 首先在本地数据库中查找这本书 */
			long isbn = bookRelease.getIsbn();
			Book book = bookDao.getBookByIsbn(isbn);
			/* 如果本地数据库中没有这本书，就通过豆瓣api获取 */
			if (book == null) {
				try {
					/* 使用spring-web提供的http请求类 */
					/* 创建HTTP请求 */
					URI uri = new URI("https://api.douban.com/v2/book/isbn/:"+Long.toString(isbn));
					SimpleClientHttpRequestFactory schr = new SimpleClientHttpRequestFactory();
					ClientHttpRequest chr = schr.createRequest(uri, HttpMethod.GET);
					chr.getHeaders().set("Accept", "application/json");  
					
					/* 发送请求  */
					ClientHttpResponse res = chr.execute();
					/* 获得返回数据,注意这里是个流 */
					InputStream is = res.getBody(); 
					/* 处理数据流，注意需要设置编码为utf-8，否则会乱码 */
					InputStreamReader isr = new InputStreamReader(is,"utf-8");
					BufferedReader br = new BufferedReader(isr);
					String str = br.readLine();
					
					/* 使用gson将字符串转换为map，方便获取属性 */
					Gson gson = new Gson();
					Map<String, Object> b = (Map<String, Object>)gson.fromJson(str, Map.class);
					
					/* 根据map中的属性构造本地Book类并存入数据库 */
					/* 首先获得各个属性，注意其中部分属性存在多个值，这里暂只取其中一个 */
					String title = (String) b.get("title");
					List<String> authors = (ArrayList<String>)b.get("author");
					String author = (authors.size()==0? null:(String)authors.get(0));
					String publisher = (String) b.get("publisher");
					List<String> translators = (ArrayList<String>)b.get("translator");
					String translator = (translators.size()==0? null:(String)translators.get(0));
					String image = (String)((Map<String, Object>)b.get("images")).get("large");
					Double score = Double.valueOf((String)((Map<String, Object>)b.get("rating")).get("average"));
					int numRaters = ((Double)((Map<String, Object>)b.get("rating")).get("numRaters")).intValue();
					/* coverSrc只取url最后文件名部分，减少数据库冗余 */
					/* url格式示例：https://img3.doubanio.com\/lpic\/s3597391.jpg */
					String coverSrc = image.substring(image.lastIndexOf("/")+1, image.length());
					Book newbook = new Book(isbn, title, author, publisher, translator, coverSrc, score, numRaters);
					bookDao.save(newbook);
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
			}
			int r_id = bookReleaseDao.save(bookRelease);
			bookRelease.setR_id(r_id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean uploadImage(int id, File image, String contentType, String fileName) {
		return bookReleaseDao.uploadPicture(id, image, contentType, fileName);
	}
	
	public Picture getPictureByR_id(int r_id){
		return bookReleaseDao.getPictureByR_id(r_id);
	}
	
}