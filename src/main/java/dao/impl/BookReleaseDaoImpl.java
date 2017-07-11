package dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;

import dao.BookReleaseDao;
import model.BookRelease;
import model.Picture;

@SuppressWarnings("deprecation")
public class BookReleaseDaoImpl extends HibernateDaoSupport implements BookReleaseDao {

	public Integer save(BookRelease bookRelease) {
		return (Integer) getHibernateTemplate().save(bookRelease);
	}

	public void delete(BookRelease bookRelease) {
		getHibernateTemplate().delete(bookRelease);
	}

	public void update(BookRelease bookRelease) {
		getHibernateTemplate().merge(bookRelease);
	}

	public BookRelease getBookReleaseByR_id(int r_id) {
		@SuppressWarnings("unchecked")
		List<BookRelease> bookReleases = (List<BookRelease>) getHibernateTemplate().find(
				"from BookRelease as b where b.r_id=?", r_id);
		BookRelease bookRelease = bookReleases.size() > 0 ? bookReleases.get(0) : null;
		return bookRelease;
	}
	
	public List<BookRelease> getBookReleaseById(int id) {
		@SuppressWarnings("unchecked")
		List<BookRelease> bookReleases = (List<BookRelease>) getHibernateTemplate().find(
				"from BookRelease as b where b.id=?", id);
		return bookReleases;
	}
	
	public List<BookRelease> getBookReleaseByIsbn(long isbn) {
		@SuppressWarnings("unchecked")
		List<BookRelease> bookReleases = (List<BookRelease>) getHibernateTemplate().find(
				"from BookRelease as d where d.isbn=?", isbn);
		return bookReleases;
	}
	
	public List<BookRelease> getBookReleaseByStatus() {
		@SuppressWarnings("unchecked")
		List<BookRelease> bookReleases = (List<BookRelease>) getHibernateTemplate().find(
				"from BookRelease where status=?", (short)0);
		return bookReleases;
	}

	public List<BookRelease> getAllBookReleases() {
		@SuppressWarnings("unchecked")
		List<BookRelease> bookReleases = (List<BookRelease>) getHibernateTemplate()
				.find("from BookRelease");
		return bookReleases;
	}
	
	private GridFsTemplate GridFsTemplate;

	public void setGridFsTemplate(GridFsTemplate GridFsTemplate) {
	    this.GridFsTemplate = GridFsTemplate;
	}
	
	public Picture getPictureByR_id(int r_id) {
		GridFSDBFile result = GridFsTemplate.findOne(new Query(Criteria.where("metadata.r_id").is(r_id)));
		if (result!= null){
			Picture picture =new Picture(result.getContentType(),result.getInputStream());
			return picture;
		}
		else{
			GridFSDBFile result0 = GridFsTemplate.findOne(new Query(Criteria.where("filename").is("404.png")));
			Picture picture =new Picture(result0.getContentType(),result0.getInputStream());
			return picture;
		}
		
	}
	
	public boolean uploadPicture(int r_id,File file,String contentType,String fileName){
		try{
			FileInputStream inputStream = new FileInputStream(file);
			DBObject metadata = new BasicDBObject("r_id",r_id);
			GridFsTemplate.store(inputStream, fileName, contentType, metadata);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
}