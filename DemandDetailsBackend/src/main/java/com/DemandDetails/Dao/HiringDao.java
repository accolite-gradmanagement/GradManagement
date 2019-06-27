package com.DemandDetails.Dao;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.DemandDetails.Model.Employee;
import com.DemandDetails.Model.HiringDemand;
import com.DemandDetails.Model.Location;
import com.DemandDetails.Query.Queries;

@Repository
public class HiringDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<HiringDemand> getAllDemandDetails() {
		return jdbcTemplate.query(Queries.GET_ALL_DEMANDS, (rs, i) -> {
			return new HiringDemand(rs.getInt("ED_ID"), rs.getInt("HM_ID"), rs.getInt("DEMAND_COUNT"),
					rs.getInt("LOCATION_ID"), rs.getDate("START_TIME"), rs.getString("STATUS"),
					rs.getString("COMMENTS"));
		});
	}

	public HiringDemand addHiringDetails(HiringDemand hd) {

		Object[] hiringDetailsParams = { hd.getED_ID(), hd.getHM_ID(), hd.getL_ID(), hd.getDEMAND_COUNT(),
				hd.getSTART_TIME(), hd.getSTATUS(), hd.getCOMMENTS() };

		int[] hiringDetailsTypes = { Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.DATE,
				Types.VARCHAR, Types.VARCHAR };

		jdbcTemplate.update(Queries.INSERT_DEMAND_DETAILS, hiringDetailsParams, hiringDetailsTypes);

		return hd;
	}

	// not in use currently
	public HiringDemand updateHiringDetail(int id, HiringDemand hd) {

		Object[] hiringDetailParams = { hd.getDEMAND_COUNT(), hd.getSTATUS(), hd.getCOMMENTS(), id };

		int[] hiringDetailsTypes = { Types.INTEGER, Types.VARCHAR, Types.VARCHAR, Types.INTEGER };

		jdbcTemplate.update(Queries.UPDATE_DEMAND_DETAIL, hiringDetailParams, hiringDetailsTypes);

		return hd;
	}

	public List<Employee> getAllEmployees() {
		return jdbcTemplate.query(Queries.GET_ALL_EMPLOYEES, (rs, i) -> {
			return new Employee(rs.getInt("EMP_ID"), rs.getString("EMP_NAME"), rs.getString("ROLE"));
		});
	}
	
	public List<Location> getAllLocations() {
		return jdbcTemplate.query(Queries.GET_ALL_LOCATIONS, (rs, i) -> {
			return new Location(rs.getInt("LOCATION_ID"), rs.getString("LOCATION_NAME"));
		});
	}
}