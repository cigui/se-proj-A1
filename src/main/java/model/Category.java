package model;

public class Category {
	private int cate_id;
	private String name;
	
	public Category(){
		
	}
	
	public Category(int cate_id, String name){
		this.cate_id = cate_id;
		this.name = name;
	}

	public int getCate_id() {
		return cate_id;
	}

	public void setCate_id(int cate_id) {
		this.cate_id = cate_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
