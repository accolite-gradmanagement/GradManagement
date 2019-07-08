package com.accolite.msgrad.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.accolite.msgrad.model.Employee;
import com.accolite.msgrad.model.GoogleLogin;
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

	public static String encrypt(String strClearText,String strKey) throws Exception{
		String strData="";
		
		try {
			SecretKeySpec skeyspec=new SecretKeySpec(strKey.getBytes(),"Blowfish");
			Cipher cipher=Cipher.getInstance("Blowfish");
			cipher.init(Cipher.ENCRYPT_MODE, skeyspec);
			byte[] encrypted=cipher.doFinal(strClearText.getBytes());
			strData=new String(encrypted);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return strData;
	}
	public static String decrypt(String strEncrypted,String strKey) throws Exception{
		String strData="";
		
		try {
			SecretKeySpec skeyspec=new SecretKeySpec(strKey.getBytes(),"Blowfish");
			Cipher cipher=Cipher.getInstance("Blowfish");
			cipher.init(Cipher.DECRYPT_MODE, skeyspec);
			byte[] decrypted=cipher.doFinal(strEncrypted.getBytes());
			strData=new String(decrypted);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return strData;
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
		
		String str;
		try {
			str = this.encrypt(user.getPassWord(), "BlowFish");
			user.setPassWord(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		try {
			String str = this.encrypt(login.getPass_word(), "BlowFish");
			login.setPass_word(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		try {
			String str = this.encrypt("accoliteEmployee", "BlowFish");
			user.setPassword(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		userobj.setRole("trainer");
		sql = "INSERT INTO LOGIN(USERNAME,PASS_WORD)"+" VALUES('"+user.getEmailId()+"','"+user.getPassword()+"')";
		System.out.println(sql);
		this.jTemplate.execute(sql);
		sql = "INSERT INTO USERS(EMAIL_ID,ROLE)"+" VALUES('"+user.getEmailId()+"','"+userobj.getRole()+"')";
		System.out.println(sql);
		this.jTemplate.execute(sql);
		return 1;
	}
	
	public boolean updateUser(User login) {
		int userId = login.getUserId();
		String sql = "SELECT * FROM USERS WHERE USER_ID='"+userId+"';";
		System.out.println(sql);
		List<User> temp = this.jTemplate.query(sql, new RowMapper<User>(){
			
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				User m = new User();
				m.setEmailId(rs.getString("EMAIL_ID"));
				m.setFirstName(rs.getString("FIRST_NAME"));
				m.setLastName(rs.getString("LAST_NAME"));
				m.setDob(rs.getString("DOB"));
				m.setGender(rs.getString("GENDER"));
				m.setMobileNo(rs.getString("MOBILE_NO"));
				m.setRole(rs.getString("ROLE"));
				return m;	
			}
		});
		if(temp.isEmpty())
			return false;
		sql = "UPDATE USERS SET FIRST_NAME='"+login.getFirstName()+"' ,LAST_NAME='"+login.getLastName()+"' ,MOBILE_NO='"+login.getMobileNo()+"' WHERE USER_ID="+userId+";";
		System.out.println(sql);
		this.jTemplate.execute(sql);
		return true;
		
	}

	public User googlelogin(GoogleLogin login) {

		String sql = "SELECT * FROM LOGIN WHERE USERNAME='"+login.getEmail()+ "';";
		System.out.println(sql);
		List<GoogleLogin> temp = this.jTemplate.query(sql, new RowMapper<GoogleLogin>(){
			
			public GoogleLogin mapRow(ResultSet rs, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				GoogleLogin m = new GoogleLogin();
				m.setEmail(rs.getString("USERNAME"));
				return m;
			}
		});
		System.out.println(temp.size());
		if(temp.isEmpty())
			return null;
		if(temp.size() == 1)
		{
			sql = "SELECT * FROM USERS WHERE EMAIL_ID='"+login.getEmail()+"';";
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

	public int setPassword(Login login) throws Exception {
		System.out.println("set password called");
		String password = this.encrypt(login.getPass_word(), "BlowFish");
		login.setPass_word(password);
		String sql = "UPDATE LOGIN SET pass_word='"+password+"' WHERE username='"+login.getUsername()+"';";
		this.jTemplate.execute(sql);
		return 1;
	}


	
}
