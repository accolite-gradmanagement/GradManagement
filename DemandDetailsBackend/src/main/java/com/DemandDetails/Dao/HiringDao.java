package com.DemandDetails.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HiringDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
}
