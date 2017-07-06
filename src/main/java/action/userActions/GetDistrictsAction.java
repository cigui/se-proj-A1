package action.userActions;

import java.util.List;

import action.BaseAction;
import service.DistrictService;
import model.District;


public class GetDistrictsAction extends BaseAction {
	/**
	 * Modified on 6th, July, 2017
	 * By: Zhou Xin
	 */
	private static final long serialVersionUID = 1L;
	
	private String parentId;
	private DistrictService districtService;
	private List<District> districts;
	
	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public DistrictService getDistrictService() {
		return districtService;
	}

	public void setDistrictService(DistrictService districtService) {
		this.districtService = districtService;
	}

	public List<District> getDistricts() {
		return districts;
	}

	public void setDistricts(List<District> districts) {
		this.districts = districts;
	}

	@Override
	public String execute() throws Exception {
		setDistricts(districtService.getDistrictsByParent_id(Integer.parseInt(parentId)));
		return SUCCESS;
	}
}