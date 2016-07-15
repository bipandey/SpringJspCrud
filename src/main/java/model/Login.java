package model;

import org.springframework.beans.factory.annotation.Required;

public class Login {
	
	private String userId;
	
	private String userPassword;
	
	private String userRole;
	
	
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getUserId() {
		return userId;
	}
	@Required
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	@Required
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	
	
	

}
