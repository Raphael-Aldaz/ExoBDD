package fr.fms.entities;

public class User {
	private int userId;
	private String userLogin;
	private String userPassword;
	public User(int userId, String userLogin, String userPassword) {
		super();
		this.userId = userId;
		this.userLogin = userLogin;
		this.userPassword = userPassword;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
}
