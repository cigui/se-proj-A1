package dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.UserDao;
import model.User;

@SuppressWarnings("deprecation")
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public Integer save(User user) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public void delete(User user) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void update(User user) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public User getUserById(int id) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public User getUserByEmail(String email) {
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) getHibernateTemplate().find(
				"from User as u where u.email=?", email);
		User user = users.size() > 0 ? users.get(0) : null;
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO �Զ����ɵķ������
		return null;
	}
	
}