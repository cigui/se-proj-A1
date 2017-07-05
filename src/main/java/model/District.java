package model;

public class District {
	private int id;
	private String name;
	private int parent_id;
	private byte order;
	
	public District(){
		
	}
    
	public District(int id, String name, int parent_id, byte order){
		this.id = id;
		this.name = name;
		this.parent_id = parent_id;
		this.order = order;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}

	public byte getOrder() {
		return order;
	}

	public void setOrder(byte order) {
		this.order = order;
	}

	
}
