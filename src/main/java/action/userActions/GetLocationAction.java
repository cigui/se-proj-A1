package action.userActions;

import action.BaseAction;
import model.Location;
import service.DistrictService;

public class GetLocationAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DistrictService districtService;
	private String latitude;
	private String longitude;
	private Location result;

	public DistrictService getDistrictService() {
		return districtService;
	}

	public void setDistrictService(DistrictService districtService) {
		this.districtService = districtService;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	public Location getResult() {
		return result;
	}

	public void setResult(Location result) {
		this.result = result;
	}

	public String execute(){
		setResult(districtService.getLocationByLL(latitude, longitude));
		return SUCCESS;
	}
}
