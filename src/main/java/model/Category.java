package model;

public class Category {
	private int cate_ID;
	private char name;
	
	public Category(){
		
	}
	
	public Category(int cate_ID, char name){
		this.setCate_ID(cate_ID);
		this.setName(name);
	}

	public int getCate_ID() {
		return cate_ID;
	}

	public void setCate_ID(int cate_ID) {
		this.cate_ID = cate_ID;
	}

	public char getName() {
		return name;
	}

	public void setName(char name) {
		this.name = name;
	}

}
