package com.revature.pojos;

public class ErsReimbursementType {
	private int reimbTypeId;
	private int reimbType;
	
	public ErsReimbursementType() {
		
	}

	public ErsReimbursementType(int reimbTypeId, int reimbType) {
		super();
		this.reimbTypeId = reimbTypeId;
		this.reimbType = reimbType;
	}

	public int getReimbTypeId() {
		return reimbTypeId;
	}

	public void setReimbTypeId(int reimbTypeId) {
		this.reimbTypeId = reimbTypeId;
	}

	public int getReimbType() {
		return reimbType;
	}

	public void setReimbType(int reimbType) {
		this.reimbType = reimbType;
	}

	@Override
	public String toString() {
		return "ErsReimbursementType [reimbTypeId=" + reimbTypeId + ", reimbType=" + reimbType + "]";
	}
	
	
}
