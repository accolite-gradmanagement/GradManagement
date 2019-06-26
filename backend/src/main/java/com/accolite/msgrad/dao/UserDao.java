package com.accolite.msgrad.dao;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.bcrypt.BCrypt;
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
	
	public static String hashPassword(String password_plaintext) {
		String salt = BCrypt.gensalt(12);
		String hashed_password = BCrypt.hashpw(password_plaintext, salt);

		return(hashed_password);
	}
	public static boolean checkPassword(String password_plaintext, String stored_hash) {
		boolean password_verified = false;

		if(null == stored_hash || !stored_hash.startsWith("$2a$"))
			throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");

		password_verified = BCrypt.checkpw(password_plaintext, stored_hash);

		return(password_verified);
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
		
		sql = "SELECT USERNAME FROM USERS WHERE USERNAME='"+user.getUserName()+"';";
		System.out.println(sql);
		List<User> temp1 = this.jTemplate.query(sql, new RowMapper<User>(){
			
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				User m = new User();
				m.setEmailId(rs.getString("USERNAME"));
				return m;
			}
		});
		if(!temp1.isEmpty())
			return 2;
		
		String encoded = hashPassword(user.getPassWord());
		user.setPassWord(encoded);
		sql = "INSERT INTO LOGIN(USERNAME,PASS_WORD,ROLE)"+" VALUES('"+user.getUserName()+"','"+user.getPassWord()+"','"+user.getRole()+"')";
		System.out.println(sql);
		this.jTemplate.execute(sql);
		sql = "INSERT INTO USERS(FIRST_NAME,LAST_NAME,MOBILE_NO,EMAIL_ID,DOB,GENDER,USERNAME)"+" VALUES('"+user.getFirstName()+"','"+user.getLastName()+"','"+user.getMobileNo()+"','"+user.getEmailId()+"','"+user.getDob()+"','"+user.getGender()+"','"+user.getUserName()+"')";
		System.out.println(sql);
		this.jTemplate.execute(sql);
		return 1;
	}
	
	public boolean loginUser(Login login)
	{
		String sql = "SELECT * FROM LOGIN WHERE USERNAME='"+login.getUsername()+"')";//" AND "+"PASS_WORD='"+login.getPass_word()+"';";
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
		{
			if(checkPassword(login.getPass_word(),temp.get(0).getPass_word()))
				return true;
		}
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