package dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.LocationDao;
import model.Location;

@SuppressWarnings("deprecation")
public class LocationDaoImpl extends HibernateDaoSupport implements LocationDao {

	public Integer save(Location user) {
		return (Integer) getHibernateTemplate().save(user);
	}

	public void delete(Location location) {
		getHibernateTemplate().delete(location);
	}

	public void update(Location location) {
		getHibernateTemplate().merge(location);
	}

	public Location getLocationByL_id(int l_id) {
		@SuppressWarnings("unchecked")
		List<Location> locations = (List<Location>) getHibernateTemplate().find(
				"from Location as u where u.l_id=?", l_id);
		Location location = locations.size() > 0 ? locations.get(0) : null;
		return location;
	}

	public List<Location> getAllLocations() {
		@SuppressWarnings("unchecked")
		List<Location> locations = (List<Location>) getHibernateTemplate()
				.find("from Location");
		return locations;
	}


	
}