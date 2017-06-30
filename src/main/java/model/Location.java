package model;

public class Location {
	private int l_id;
	private char province;
	private char city;
	private char district;
	
	public Location(){
		
	}
    
	public Location(int l_id, char province, char city, char district){
		this.setL_id(l_id);
		this.setProvince(province);
		this.setCity(city);
		this.setDistrict(district);
	}

	public int getL_id() {
		return l_id;
	}

	public void setL_id(int l_id) {
		this.l_id = l_id;
	}

	public char getProvince() {
		return province;
	}

	public void setProvince(char province) {
		this.province = province;
	}

	public char getCity() {
		return city;
	}

	public void setCity(char city) {
		this.city = city;
	}

	public char getDistrict() {
		return district;
	}

	public void setDistrict(char district) {
		this.district = district;
	}
	
}
