package dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Login;
import model.UserDetail;

@Component
public class UserDao {

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		//this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public boolean isValidUser(Login login) {
		String sql = "select count(*) from login where userId=? and userPassword=? and userRole=?";
		int i = 0;

		i = jdbcTemplate.queryForObject(sql, new Object[] { login.getUserId(),
				login.getUserPassword(),login.getUserRole() }, Integer.class);
		if (i > 0) {
			
			return true;
		} else {
			return false;
		}

	}

	public boolean addUser(UserDetail userDetail) {
		String checkUserDuplication = "select count(*)from user_detail where userName=?";
		int i = 0;

		i = jdbcTemplate.queryForObject(checkUserDuplication, Integer.class,
				userDetail.getUserName());
		if (i > 1) {
			return false;

		} else {

			String sql = "insert into user_detail (userName ,userAge, userDob, userSex) values(?,?,?,?) ";
			i = jdbcTemplate.update(sql, userDetail.getUserName(),
					userDetail.getUserAge(), userDetail.getUserDob(),
					userDetail.getUserSex());
			if (i > 0) {
				return true;
			} else {
				return false;
			}

		}
	}
		
		public  List<UserDetail> getUserDetail(){
			String sql="select * from user_detail";
		
			List<UserDetail> userdetails=jdbcTemplate.query(sql, new UserMapper());
			return userdetails;
			
			
		}
		
		public void deleteUser(String userName){
			String sql="delete from user_detail where userName=?";
			jdbcTemplate.update(sql,userName);
			
		}
		
		/*public void editUser(UserDetail userDetail){
			int i=0;
			String sql="select count(*) from user_detail where userName=?";
			i=jdbcTemplate.queryForObject(sql, new Object[]{userDetail.getUserName()}, Integer.class);
			if(i>0){
				String sql1="update user_detail set userName=?,userAge=?,userDob=?,userSex=?";
				jdbcTemplate.update(sql1, new Object[] {userDetail.getUserName(),userDetail.getUserAge(),userDetail.getUserDob(),userDetail.getUserSex()});				
			}else{
				
				String sql2 = "insert into user_detail (userName ,userAge, userDob, userSex) values(?,?,?,?) ";
				jdbcTemplate.update(sql2, userDetail.getUserName(),
						userDetail.getUserAge(), userDetail.getUserDob(),
						userDetail.getUserSex());
				
			}
		}*/
		
		public List<UserDetail> getUserDetailForEdit(String userName){
			
			String sql="select * from user_detail where userName='"+userName+"'";
			//List<Map<String, Object>> userDetail=jdbcTemplate.queryForList(sql, userName);
			
			List<UserDetail> userDetail=jdbcTemplate.query(sql, new UserMapper());
			return userDetail;
			
		}
		
	/*	public List<Map<String, Object>> updateUser(UserDetail userDetail){
			String sql="update user_detail set userName=?,userAge=?,userDob=?,userSex=? where userName=?   ";
			List<Map<String, Object>> userDetails=jdbcTemplate.queryForList(sql, userDetail.getUserName(),
					userDetail.getUserAge(), userDetail.getUserDob(),
					userDetail.getUserSex(),userDetail.getUserName()); 
			return userDetails;
			
		}
		*/
		
		/*public void updateUser(UserDetail userDetail){
			
			String sql=" update user_detail set userName=?,userAge=?,userDob=?,userSex=? where userName=?  ";
			jdbcTemplate.update(sql, userDetail.getUserName(),
					userDetail.getUserAge(), userDetail.getUserDob(),
					userDetail.getUserSex(),userDetail.getUserName());
			
			
		}
		*/
		public void updateUser(UserDetail userDetail){
		
			String sql=" update user_detail set userName=?,userAge=?,userDob=?,userSex=? where u_id=?  ";
			
			jdbcTemplate.update(sql, userDetail.getUserName(),userDetail.getUserAge(),userDetail.getUserDob(),
					userDetail.getUserSex(),userDetail.getU_id());
			
			
		}
		
		
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
