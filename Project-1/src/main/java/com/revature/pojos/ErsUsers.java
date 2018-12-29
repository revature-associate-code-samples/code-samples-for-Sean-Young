package com.revature.pojos;

public class ErsUsers {
	private int ersUserId;
	private String ersUserName;
	private String ersPassword;
	private String firstName;
	private String lastName;
	private String userEmail;
	private int userRoleId;
	
	public ErsUsers() {
		
	}

	public ErsUsers(int ersUserId, String ersUserName, String ersPassword, String firstName, String lastName,
			String userEmail, int userRoleId) {
		super();
		this.ersUserId = ersUserId;
		this.ersUserName = ersUserName;
		this.ersPassword = ersPassword;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userEmail = userEmail;
		this.userRoleId = userRoleId;
	}

	public int getErsUserId() {
		return ersUserId;
	}

	public void setErsUserId(int ersUserId) {
		this.ersUserId = ersUserId;
	}

	public String getErsUserName() {
		return ersUserName;
	}

	public void setErsUserName(String ersUserName) {
		this.ersUserName = ersUserName;
	}

	public String getErsPassword() {
		return ersPassword;
	}

	public void setErsPassword(String ersPassword) {
		this.ersPassword = ersPassword;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	@Override
	public String toString() {
		return "ErsUsers [ersUserId=" + ersUserId + ", ersUserName=" + ersUserName + ", ersPassword=" + ersPassword
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", userEmail=" + userEmail + ", userRoleId="
				+ userRoleId + "]";
	}

	
	
}
