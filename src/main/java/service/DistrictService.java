package service;

import model.District;
import model.Location;

import java.util.List;

public interface DistrictService {
	 
    public District getDistrictById(int id);
	
	public List<District> getDistrictsByParent_id(int parent_id);
    
	/**
	 * getLocationByLL:
	 * Get the information of a location according to the latitude and
	 * longitude.
	 */
	public Location getLocationByLL(String latitude, String longitude);
	
	public Location getLocationById(int id);
	
}