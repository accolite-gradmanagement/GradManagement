package com.DemandDetails.Model;

public class Location {

	private int LOCATION_ID;
	private String LOCATION_NAME;

	public int getLOCATION_ID() {
		return LOCATION_ID;
	}

	public void setLOCATION_ID(int lOCATION_ID) {
		LOCATION_ID = lOCATION_ID;
	}

	public String getLOCATION_NAME() {
		return LOCATION_NAME;
	}

	public void setLOCATION_NAME(String lOCATION_NAME) {
		LOCATION_NAME = lOCATION_NAME;
	}

	public Location(int lOCATION_ID, String lOCATION_NAME) {
		super();
		LOCATION_ID = lOCATION_ID;
		LOCATION_NAME = lOCATION_NAME;
	}

	public Location() {
		super();
	}

	@Override
	public String toString() {
		return "Location [LOCATION_ID=" + LOCATION_ID + ", LOCATION_NAME=" + LOCATION_NAME + "]";
	}

}
