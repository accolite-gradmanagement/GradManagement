package com.accolite.msgrad.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.accolite.msgrad.model.Login;
import com.accolite.msgrad.model.User;


@Repository
public class UserDao implements InfUser
{
	JdbcTemplate jTemplate;
	public JdbcTemplate getjTemplate() {
		return jTemplate;
	}

	public void setjTemplate(JdbcTemplate jTemplate) {
		this.jTemplate = jTemplate;
	}

	public Boolean saveUser(User user) {
		// TODO Auto-generated method stub
		String sql = "SELECT EMAIL_ID FROM USERS WHERE EMAIL_ID='"+user.getEmailId()+"';";
		System.out.println(sql);
		List<User> temp = this.jTemplate.query(sql, new RowMapper<User>(){
			
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				User m = new User();
				m.setEmailId(rs.getString("EMAIL_ID"));
				return m;
			}
		});
		if(!temp.isEmpty())
			return false;
		sql = "INSERT INTO LOGIN(USERNAME,PASS_WORD)"+" VALUES('"+user.getUserName()+"','"+user.getPassWord()+"')";
		System.out.println(sql);
		this.jTemplate.execute(sql);
		sql = "INSERT INTO USERS(FIRST_NAME,LAST_NAME,MOBILE_NO,EMAIL_ID,DOB,GENDER,USERNAME)"+" VALUES('"+user.getFirstName()+"','"+user.getLastName()+"','"+user.getMobileNo()+"','"+user.getEmailId()+"','"+user.getDob()+"','"+user.getGender()+"','"+user.getUserName()+"')";
		System.out.println(sql);
		this.jTemplate.execute(sql);
		return true;
	}
	
	public boolean loginUser(Login login)
	{
		String sql = "SELECT * FROM LOGIN WHERE USERNAME='"+login.getUsername()+"' AND "+"PASS_WORD='"+login.getPass_word()+"';";
		System.out.println(sql);
		List<Login> temp = this.jTemplate.query(sql, new RowMapper<Login>(){
			
			public Login mapRow(ResultSet rs, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				Login m = new Login();
				m.setUsername(rs.getString("USERNAME"));
				m.setPass_word(rs.getString("PASS_WORD"));
				return m;
			}
		});
		if(temp.isEmpty())
			return false;
		if(temp.size()==1)
			return true;
		return false;
	}

	public List<User> viewUser() {
		// TODO Auto-generated method stub
		String sql = "select * from users";
		return this.jTemplate.query(sql, new RowMapper<User>(){
			
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				User m = new User();
				m.setUserId(rs.getInt("USER_ID"));
				m.setFirstName(rs.getString("FIRST_NAME"));
				m.setLastName(rs.getString("LAST_NAME"));
				m.setMobileNo(rs.getString("MOBILE_NO"));
				m.setEmailId(rs.getString("EMAIL_ID"));
				m.setGender(rs.getString("GENDER"));
				m.setDob(rs.getString("DOB"));
				return m;
			}
		});
		
	}

}