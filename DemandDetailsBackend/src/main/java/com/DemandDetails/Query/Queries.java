package com.DemandDetails.Query;

public class Queries {

	public final static String INSERT_DEMAND_DETAILS = "INSERT INTO DEMAND_DETAILS"
			+ "(ED_ID, HM_ID, LOCATION_ID, DEMAND_COUNT, START_TIME, STATUS, COMMENTS)" + " VALUES (?,?,?,?,?,?,?)";

	public final static String GET_ALL_DEMANDS = "SELECT ED_ID, HM_ID, LOCATION_ID,"
			+ "DEMAND_COUNT, START_TIME, STATUS, COMMENTS FROM DEMAND_DETAILS";

	public final static String INSERT_LOCATION = "INSERT INTO LOCATION (LOCATION_NAME)";
	
	public final static String GET_ALL_EMPLOYEES = "SELECT * FROM EMPLOYEE";

	public final static String UPDATE_DEMAND_DETAIL = "UPDATE DEMAND_DETAILS SET DEMAND_COUNT = ? , COMMENTS = ?, STATUS = ? WHERE ID = ?";
}
