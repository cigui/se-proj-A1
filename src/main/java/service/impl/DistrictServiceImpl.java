package service.impl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

import com.google.gson.Gson;

import dao.DistrictDao;
import model.District;
import model.Location;
import service.DistrictService;

public class DistrictServiceImpl implements DistrictService {

	private DistrictDao districtDao;
	private Map<Integer, District> districtsMap;
	private String apikey; // 百度地图apikey
	
	public DistrictDao getDistrictDao() {
		return districtDao;
	}

	public void setDistrictDao(DistrictDao districtDao) {
		this.districtDao = districtDao;
	}

	public String getApikey() {
		return apikey;
	}

	public void setApikey(String apikey) {
		this.apikey = apikey;
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
	
	/**
	 * 使用百度地图API获取地址信息
	 */
	@SuppressWarnings("unchecked")
	public Location getLocationByLL(String latitude, String longitude) {
		try {
			/* 使用spring-web提供的http请求类 */
			/* 创建HTTP请求 */
			URI uri = new URI("http://api.map.baidu.com/geocoder/v2/?location="+latitude+","+longitude+"&output=json&ak="+apikey);
			SimpleClientHttpRequestFactory schr = new SimpleClientHttpRequestFactory();
			ClientHttpRequest chr = schr.createRequest(uri, HttpMethod.GET);
			chr.getHeaders().set("Accept", "application/json");  
			
			/* 发送请求  */
			ClientHttpResponse res = chr.execute();
			/* 获得返回数据,注意这里是个流 */
			InputStream is = res.getBody(); 
			/* 处理数据流，注意需要设置编码为utf-8，否则会乱码 */
			InputStreamReader isr = new InputStreamReader(is,"utf-8");
			BufferedReader br = new BufferedReader(isr);
			String str = br.readLine();
			
			/* 使用gson将字符串转换为map，方便获取属性 */
			Gson gson = new Gson();
			Map<String, Object> resultMap = (Map<String, Object>)gson.fromJson(str, Map.class);
			
			/* 获取属性，创建Location对象 */
			Map<String, Object> addressComponent = (Map<String, Object>) 
					((Map<String, Object>)resultMap.get("result")).get("addressComponent");
			Location result = new Location();
			result.setProvince((String) addressComponent.get("province"));
			result.setCity((String) addressComponent.get("city"));
			result.setDistrict((String) addressComponent.get("district"));
			result.setCode(Integer.valueOf((String)addressComponent.get("adcode")));
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 根据地区id获取地址省市区信息
	 */
	public Location getLocationById(int id) {
		District district = districtDao.getDistrictById(id);
		District city = districtDao.getDistrictById(district.getParent_id());
		District province = districtDao.getDistrictById(city.getParent_id());
		Location result = new Location();
		if (province != null) {
			result.setProvince(province.getName());
		}
		result.setCity(city.getName());
		result.setDistrict(district.getName());
		return result;
	}
	
}

