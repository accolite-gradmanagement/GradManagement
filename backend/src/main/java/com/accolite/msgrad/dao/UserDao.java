package com.accolite.msgrad.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.accolite.msgrad.model.Employee;
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
	
	public long saveUser(User user) {
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
			return 0;
		
		sql = "INSERT INTO LOGIN(USERNAME,PASS_WORD)"+" VALUES('"+user.getEmailId()+"','"+user.getPassWord()+"')";
		System.out.println(sql);
		this.jTemplate.execute(sql);
		sql = "INSERT INTO USERS(FIRST_NAME,LAST_NAME,MOBILE_NO,EMAIL_ID,DOB,GENDER,ROLE)"+" VALUES('"+user.getFirstName()+"','"+user.getLastName()+"','"+user.getMobileNo()+"','"+user.getEmailId()+"','"+user.getDob()+"','"+user.getGender()+"','"+user.getRole()+"')";
		System.out.println(sql);
		this.jTemplate.execute(sql);
		return 1;
	}
	
	public User loginUser(Login login)
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
			return null;
		if(temp.size()==1)
		{
			sql = "SELECT * FROM USERS WHERE EMAIL_ID='"+login.getUsername()+"';";
			System.out.println(sql);
			List<User> temp1 = this.jTemplate.query(sql, new RowMapper<User>(){
				
				public User mapRow(ResultSet rs, int arg1) throws SQLException {
					// TODO Auto-generated method stub
					User m = new User();
					m.setFirstName(rs.getString("FIRST_NAME"));
					m.setLastName(rs.getString("LAST_NAME"));
					m.setMobileNo(rs.getString("MOBILE_NO"));
					m.setDob(rs.getString("DOB"));
					m.setEmailId(rs.getString("EMAIL_ID"));
					m.setGender(rs.getString("GENDER"));
					m.setRole(rs.getString("ROLE"));
					m.setUserId(rs.getInt("USER_ID"));
					return m;
				}
			});
				return temp1.get(0);
		}
		return null;
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
				m.setRole(rs.getString("ROLE"));
				m.setGender(rs.getString("GENDER"));
				m.setDob(rs.getString("DOB"));
				return m;
			}
		});
		
	}
	
	public long addEmployee(Employee user) {
		// TODO Auto-generated method stub
		user.setPassword("accoliteEmployee");
		String sql = "SELECT EMAIL_ID FROM USERS WHERE EMAIL_ID='"+user.getEmailId()+"';";
		System.out.println(sql);
		List<Employee> temp = this.jTemplate.query(sql, new RowMapper<Employee>(){
			
			public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				Employee m = new Employee();
				m.setEmailId(rs.getString("EMAIL_ID"));
				return m;
			}
		});
		if(!temp.isEmpty())
			return 0;
		
		User userobj = new User();
		userobj.setRole("employee");
		sql = "INSERT INTO LOGIN(USERNAME,PASS_WORD)"+" VALUES('"+user.getEmailId()+"','"+user.getPassword()+"')";
		System.out.println(sql);
		this.jTemplate.execute(sql);
		sql = "INSERT INTO USERS(EMAIL_ID,ROLE)"+" VALUES('"+user.getEmailId()+"','"+userobj.getRole()+"')";
		System.out.println(sql);
		this.jTemplate.execute(sql);
		return 1;
	}

	
}