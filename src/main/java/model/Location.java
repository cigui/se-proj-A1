package model;

public class Location {
	private int l_id;
	private String province;
	private String city;
	private String district;
	
	public Location(){
		
	}
    
	public Location(int l_id, String province, String city, String district){
		this.l_id = l_id;
		this.province = province;
		this.city = city;
		this.district = district;
	}

	public int getL_id() {
		return l_id;
	}

	public void setL_id(int l_id) {
		this.l_id = l_id;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}
	
}
