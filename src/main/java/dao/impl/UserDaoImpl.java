package dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;

import dao.UserDao;
import model.Picture;
import model.User;

@SuppressWarnings("deprecation")
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	public Integer save(User user) {
		return (Integer) getHibernateTemplate().save(user);
	}

	public void delete(User user) {
		getHibernateTemplate().delete(user);
	}

	public void update(User user) {
		getHibernateTemplate().merge(user);
	}

	public User getUserById(int id) {
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) getHibernateTemplate().find(
				"from User as b where b.id=?", id);
		User user = users.size() > 0 ? users.get(0) : null;
		return user;
	}

	public User getUserByEmail(String email) {
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) getHibernateTemplate().find(
				"from User as u where u.email=?", email);
		User user = users.size() > 0 ? users.get(0) : null;
		return user;
	}

	public List<User> getAllUsers() {
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) getHibernateTemplate()
				.find("from User");
		return users;
	}
	
	private GridFsTemplate GridFsTemplate;

	public void setGridFsTemplate(GridFsTemplate GridFsTemplate) {
	    this.GridFsTemplate = GridFsTemplate;
	}
	
	public Picture getPictureById(int id) {
		GridFSDBFile result = GridFsTemplate.findOne(new Query(Criteria.where("metadata.id").is(id)));
		Picture picture =new Picture(result.getContentType(),result.getInputStream());
		return picture;
	}
	
	public boolean uploadPicture(int id,File file,String contentType,String fileName){
		try{
			FileInputStream inputStream = new FileInputStream(file);
			DBObject metadata = new BasicDBObject("id",id);
			GridFSDBFile oldFile = GridFsTemplate.findOne(new Query(Criteria.where("metadata.id").is(id)));
			if (oldFile != null) {
				GridFsTemplate.delete(new Query(Criteria.where("metadata.id").is(id)));
			}
			GridFsTemplate.store(inputStream, fileName, contentType, metadata);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	
}