package dao;

import java.util.List;

import model.Location;

public interface LocationDao {

	public Integer save(Location location);

	public void delete(Location location);

	public void update(Location location);

	public Location getLocationByL_id(int l_id);

	public List<Location> getAllLocations();

}