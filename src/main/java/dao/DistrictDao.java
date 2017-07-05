package dao;

import java.util.List;

import model.District;

public interface DistrictDao {

	public Integer save(District location);

	public void delete(District location);

	public void update(District location);

	public District getDistrictsById(int id);
	
	public List<District> getDistrictByParent_id(int parent_id);

	public List<District> getAllDistricts();

}