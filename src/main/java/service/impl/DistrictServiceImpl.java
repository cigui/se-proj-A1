package service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.DistrictDao;
import model.District;
import service.DistrictService;

public class DistrictServiceImpl implements DistrictService {

	private DistrictDao districtDao;
	private Map<Integer, District> districtsMap;
	
	public DistrictDao getDistrictDao() {
		return districtDao;
	}

	public void setDistrictDao(DistrictDao districtDao) {
		this.districtDao = districtDao;
	}

	/* 
	 * Modified on 14th Aug, 2017 by Zhou Xin
	 * Use HashMap to store districts in memory in order to enhance
	 * performance.
	 */
	public District getDistrictById(int id) {
		if (districtsMap == null) {
			districtsMap = new HashMap<Integer, District>();
			List<District> districts = districtDao.getAllDistricts();
			for (District district : districts) {
				districtsMap.put(district.getId(), district);
			}
		}
		return districtsMap.get(id);
		// return districtDao.getDistrictById(id);
	}

	public List<District> getDistrictsByParent_id(int parent_id) {
		return districtDao.getDistrictsByParent_id(parent_id);
	}
}

