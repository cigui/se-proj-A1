package service.impl;

import java.util.List;

import dao.DistrictDao;
import model.District;
import service.DistrictService;

public class DistrictServiceImpl implements DistrictService {

	private DistrictDao districtDao;
	
	public DistrictDao getDistrictDao() {
		return districtDao;
	}

	public void setDistrictDao(DistrictDao districtDao) {
		this.districtDao = districtDao;
	}

	public District getDistrictById(int id) {
		return districtDao.getDistrictById(id);
	}

	public List<District> getDistrictsByParent_id(int parent_id) {
		return districtDao.getDistrictByParent_id(parent_id);
	}
}

