package com.revature.pojos;

public class ErsUserRoles {
	private int ersUserRoleId;
	private String userRole;
	
	public ErsUserRoles() {
		
	}

	public ErsUserRoles(int ersUserRoleId, String userRole) {
		super();
		this.ersUserRoleId = ersUserRoleId;
		this.userRole = userRole;
	}

	public int getErsUserRoleId() {
		return ersUserRoleId;
	}

	public void setErsUserRoleId(int ersUserRoleId) {
		this.ersUserRoleId = ersUserRoleId;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "ErsUserRoles [ersUserRoleId=" + ersUserRoleId + ", userRole=" + userRole + "]";
	}
	
	
}
