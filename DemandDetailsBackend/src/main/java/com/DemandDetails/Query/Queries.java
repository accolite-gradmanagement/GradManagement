package com.DemandDetails.Query;

public class Queries {

	private Queries() {
	}

	public static final String INSERT_DEMAND_DETAILS = "INSERT INTO DEMAND_DETAILS"
			+ "(ED_ID, HM_ID, LOCATION_ID, DEMAND_COUNT, START_TIME, STATUS, COMMENTS)" + " VALUES (?,?,?,?,?,?,?)";

	public static final String GET_ALL_DEMANDS = "SELECT ED_ID, HM_ID, LOCATION_ID,"
			+ "DEMAND_COUNT, START_TIME, STATUS, COMMENTS FROM DEMAND_DETAILS";

	public static final String INSERT_LOCATION = "INSERT INTO LOCATION (LOCATION_NAME)";

	public static final String GET_ALL_EMPLOYEES = "SELECT * FROM EMPLOYEE";

	public static final String UPDATE_DEMAND_DETAIL = "UPDATE DEMAND_DETAILS SET DEMAND_COUNT = ? , COMMENTS = ?, STATUS = ? WHERE ID = ?";

	public static final String GET_ALL_LOCATIONS = "SELECT * FROM LOCATION";

	public static final String INSERT_EMPLOYEE = "INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME,ROLE) VALUES(?,?,?)";

}
