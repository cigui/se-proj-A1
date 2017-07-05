package model;

public class User {
	private int id;
	private int l_id;
	private String nickname;
	private String password;
	private String email;
	private int role;
	private int points;
	private int credit;
	private Integer fav_category;
	private Byte gender;
	
	public User(){
		
	}
	
	public User(int l_id, String nickname, String password, String email, Byte gender) {
		this.l_id = l_id;
		this.nickname = nickname;
		this.password = password;
		this.email = email;
		this.gender = gender;
	}

	public User(int id, int l_id, String nickname, String password, String email, int role, int points, int credit, int fav_category, Byte gender){
		this.id = id;
		this.l_id = l_id;
		this.nickname = nickname;
		this.password = password;
		this.email = email;
		this.role = role;
		this.points = points;
		this.credit = credit;
		this.fav_category = fav_category;
		this.gender = gender;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getL_id() {
		return l_id;
	}

	public void setL_id(int l_id) {
		this.l_id = l_id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public Integer getFav_category() {
		return fav_category;
	}

	public void setFav_category(Integer fav_category) {
		this.fav_category = fav_category;
	}

	public Byte getGender() {
		return gender;
	}

	public void setGender(Byte gender) {
		this.gender = gender;
	}
	
}
