package model;

public class User {
	private int id;
	private int l_id;
	private char nickname;
	private char password;
	private char email;
	private int role;
	private int points;
	private int credit;
	private int fav_Category;
	private int gender;
	
	public User(){
		
	}

	public User(int id, int l_id, char nickname, char password, char email, int role, int points, int credit, int fav_Category, int gender){
		this.setId(id);
		this.setL_id(l_id);
		this.setNickname(nickname);
		this.setPassword(password);
		this.setEmail(email);
		this.setRole(role);
		this.setPoints(points);
		this.setCredit(credit);
		this.setFav_Category(fav_Category);
		this.setGender(gender);
		
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

	public char getNickname() {
		return nickname;
	}

	public void setNickname(char nickname) {
		this.nickname = nickname;
	}

	public char getPassword() {
		return password;
	}

	public void setPassword(char password) {
		this.password = password;
	}

	public char getEmail() {
		return email;
	}

	public void setEmail(char email) {
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

	public int getFav_Category() {
		return fav_Category;
	}

	public void setFav_Category(int fav_Category) {
		this.fav_Category = fav_Category;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}
	
}
