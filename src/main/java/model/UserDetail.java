package model;

import java.util.Date;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.format.annotation.DateTimeFormat;

//import java.util.Date;

public class UserDetail {
	
	private String userName;
	
	private int userAge;
	private String userSex;
	@DateTimeFormat(pattern = "yyyy-dd-MM")
	private Date userDob;
	
	private int u_id;
	
	

	public String getUserName() {
		return userName;
	}

	@Required
	public void setUserName(String userName) {
		this.userName = userName;
	}


	public Date getUserDob() {
		return userDob;
	}

	//@Required
	public void setUserDob(Date userDob) {
		this.userDob = userDob;
	}


	public int getUserAge() {
		return userAge;
	}

	@Required
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}


	public String getUserSex() {
		return userSex;
	}

	@Required
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

}
