package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.UserDetail;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<UserDetail> {

	@Override
	public UserDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserDetail userDetail=new UserDetail();
		userDetail.setUserName(rs.getString("userName"));
		userDetail.setUserDob(rs.getDate("userDob"));
		userDetail.setUserAge(rs.getInt("userAge"));
		userDetail.setUserSex(rs.getString("userSex"));
		userDetail.setU_id(rs.getInt("u_id"));
		return userDetail;
	}

}
