package dao;

import java.util.List;

import model.District;

public interface DistrictDao {

	public Integer save(District district);

	public void delete(District district);

	public void update(District district);

	public District getDistrictById(int id);
	
	public List<District> getDistrictByParent_id(int parent_id);

	public List<District> getAllDistricts();

}