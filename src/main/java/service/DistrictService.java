package service;

import model.District;

import java.util.List;

public interface DistrictService {
	 
    public District getDistrictById(int id);
	
	public List<District> getDistrictsByParent_id(int parent_id);
    
}