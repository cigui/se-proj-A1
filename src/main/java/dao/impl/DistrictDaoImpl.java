package dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.DistrictDao;
import model.District;

@SuppressWarnings("deprecation")
public class DistrictDaoImpl extends HibernateDaoSupport implements DistrictDao {

	public Integer save(District district) {
		return (Integer) getHibernateTemplate().save(district);
	}

	public void delete(District district) {
		getHibernateTemplate().delete(district);
	}

	public void update(District district) {
		getHibernateTemplate().merge(district);
	}

	@Override
	public District getDistrictsById(int id) {
		@SuppressWarnings("unchecked")
		List<District> districts = (List<District>) getHibernateTemplate().find(
				"from District as u where u.id=?", id);
		District district = districts.size() > 0 ? districts.get(0) : null;
		return district;
	}
	
	public List<District> getDistrictByParent_id(int parent_id) {
		@SuppressWarnings("unchecked")
		List<District> districts = (List<District>) getHibernateTemplate().find(
				"from District where parent_id=?", parent_id);
		return districts;
	}

	public List<District> getAllDistricts() {
		@SuppressWarnings("unchecked")
		List<District> districts = (List<District>) getHibernateTemplate()
				.find("from District");
		return districts;
	}
	
}