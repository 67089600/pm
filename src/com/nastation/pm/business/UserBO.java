package com.nastation.pm.business;

import com.nastation.pm.bean.Permission;
import com.nastation.pm.bean.User;
import com.nastation.pm.util.*;

import java.sql.*;
import java.util.*;

/**
 * 
 * @author 孙重阳
 * 
 */
public class UserBO {

	public static final String columnNames = "username, password, fullname, email, create_date";

	/**
	 * This method is use to insert the user's information into database;
	 * 
	 */
	public boolean addUser(User user) {
		boolean flag = false;
		Connection conn = null;
		String sql = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			sql = "insert into t_user(" + columnNames + ") value(?,?,?,?,?)";
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(sql);

			if (!exist(user.getName())) {
				pstmt.setString(1, user.getName());
				pstmt.setString(2, user.getPassword());
				pstmt.setString(3, user.getFullName());
				pstmt.setString(4, user.getEmail());
				pstmt.setString(5, user.getCreateDate());
				int x = pstmt.executeUpdate();
				flag = true;
			} else {
				flag = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			DBConn.closeConn(conn);

		}
		return flag;
	}

	/**
	 * 判断用户名是否重复
	 */
	public boolean exist(String name) {
		boolean flag = false;
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from t_user where username=?";
		System.out.println("==UserBO.java==exist==sql==" + sql);
		System.out.println("==UserBO.java==exist==name==" + name);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.closeConn(conn);
		}
		return flag;
	}

	/**
	 * this method is use to change password.
	 */
	public boolean changePassword(int id, String newpwd) {
		boolean flag = false;
		Connection conn = null;
		String sql = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConn.getConnection();
			sql = "update t_user set password=? where id=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newpwd);
			pstmt.setInt(2, id);
			int x = pstmt.executeUpdate();
			flag = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.closeConn(conn);
		}
		return flag;
	}

	/**
	 * This method is use to get a user class by user id.
	 */
	public User getUser(String username) {
		Connection conn = null;
		String sql = "select id," + columnNames + " from t_user where username=?";
		ResultSet rs = null;
		PreparedStatement stmt = null;
		User user = null;
		try {
			conn = DBConn.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			rs = stmt.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFullName(rs.getString("fullname"));
				user.setEmail(rs.getString("email"));
				user.setCreateDate(rs.getString("create_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.closeConn(conn);
		}
		return user;
	}

	/**
	 * this method is use to get a user class by id.
	 */
	public User getUser(int id) {
		Connection conn = null;
		String sql = "select * from t_user where id=" + id;
		System.out.println("=======sql==161==" + sql);
		System.out.println("=======userId==161==" + id);
		ResultSet rs = null;
		Statement stmt = null;
		User user = new User();
		try {
			conn = DBConn.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFullName(rs.getString("fullname"));
				user.setEmail(rs.getString("email"));
				user.setCreateDate(rs.getDate("create_date").toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.closeConn(conn);
		}
		return user;
	}

	/**
	 * This method is use to update user's information
	 */
	public void updateUser(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConn.getConnection();
			String sql = "update t_user set fullname=?,email=? where id='"
					+ user.getId() + "'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getFullName());
			pstmt.setString(2, user.getEmail());
			pstmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.closeConn(conn);
		}
	}

	/**
	 * judge if this user have a foreign key.
	 * 
	 * @param id
	 */
	public boolean hasForeignKey(int userId) {
		System.out.println("hasForeignKey method");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean flag = false;
		try {
			// 判断t_project_user表中是否有外键关联。
			conn = DBConn.getConnection();
			String sql = "select user_id from t_project_user where user_id=?";
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();
			System.out.println("after executeQuery");

			if (rs.next()) {
				flag = true;
				System.out.println(flag);
			}
			// 判断t_issue表中assignee_id是否有外键关联。
			String sql2 = "select assignee_id,reporter_id from t_issue where assignee_id=? or reporter_id=?";
			System.out.println(sql2);
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, userId);
			pstmt.setInt(2, userId);
			rs = pstmt.executeQuery();
			System.out.println("after executeQuery");

			if (rs.next()) {
				flag = true;
				System.out.println(flag);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.closeConn(conn);
		}
		return flag;
	}

	/**
	 * This method is use to update user's information
	 * 
	 * @param id
	 */
	public void deleteUser(int id) {
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql = "delete from t_group_user where user_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			String sql2 = "delete from t_user where id=?";
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.closeConn(conn);
		}
	}

	/**
	 * This method is use to view all user's details. All user's informations
	 * are reserved in a List class.
	 */
	public List viewUsers() {
		Connection conn = null;
		String sql = "select * from t_user";
		ResultSet rs = null;
		Statement stmt = null;
		List list = new ArrayList();
		try {
			conn = DBConn.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("username"));
				user.setFullName(rs.getString("fullname"));
				user.setEmail(rs.getString("email"));
				user.setCreateDate(rs.getDate("create_date").toString());
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.closeConn(conn);
		}
		return list;
	}

	/**
	 * this method is check login,use to check the user's name and password and
	 * return a user class.
	 */
	public User login(String username, String password) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = new User();
		String sql = "select * from t_user where username=? and password=?";
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if (rs.next() == false) {
				user = null;
			} else {

				user.setId(rs.getInt("id"));
				user.setName(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setFullName(rs.getString("fullname"));
				user.setPassword(rs.getString("password"));
				user.setCreateDate(rs.getDate("create_date").toString());
				user.setPermissions(getAllPermissions(rs.getInt("id")));
				user.setAdmin(isAdmin(rs.getInt("id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.closeConn(conn);
		}
		return user;
	}

	/**
	 * 判断t_project_user表里是否存在projectId 如果存在就返回true，反之则返回false
	 */
	public boolean checkProjectUser(int projectId) {
		Connection conn = DBConn.getConnection();
		boolean b = false;
		try {
			String sql = "select * from t_project_user where project_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, projectId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				b = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.closeConn(conn);
		}
		return b;
	}

	/**
	 * 删除项目中所有用户
	 */
	public void deleteAllProjectUser(int projectId) {
		Connection conn = DBConn.getConnection();
		try {
			String sql = "delete from t_project_user where project_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, projectId);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.closeConn(conn);
		}
	}

	/**
	 * This method is use to get a user class by user id.
	 */
	public boolean checkUserExist(String username) {
		Connection conn = null;
		String sql = "select * from t_user where username=?";
		ResultSet rs = null;
		PreparedStatement stmt = null;
		User user = new User();
		try {
			conn = DBConn.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			rs = stmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.closeConn(conn);
		}
		return false;
	}

	/**
	 * 通过用户ID获得该用户的所有权限。权限通过HashMap存储，Key为projectId,Value为list<Permission>。
	 * 
	 * @param id
	 * @author sun
	 */
	public HashMap<Integer, List> getAllPermissions(int id) {
		HashMap<Integer, List> userPermissions = new HashMap<Integer, List>();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		StringBuffer strBuffer = new StringBuffer();
		strBuffer
				.append("select distinct a.id as user_id,b.id as project_id, ");
		strBuffer.append("e.name as permission_name ");
		strBuffer
				.append("from t_user a left join t_project_user f on a.id=f.user_id ");
		strBuffer.append("left join t_project b on f.project_id=b.id ");
		strBuffer
				.append("left join t_permission_scheme c on b.permission_scheme_id=c.id ");
		strBuffer
				.append("left join t_permission_assignee d on c.id = d.scheme_id ");
		strBuffer.append("left join t_permission e on d.permission_id=e.id ");
		strBuffer
				.append("where ((d.assignee_type='ProjectRole' and d.assignee in ");
		strBuffer.append("(select distinct b.role_name ");
		strBuffer
				.append("from t_user a left join t_project_user c on a.id=c.user_id ");
		strBuffer.append("left join t_role b on b.id=c.role_id ");
		strBuffer.append("left join t_project d on d.id=c.project_id ");
		strBuffer.append("where a.id=?)) ");
		strBuffer.append("or (d.assignee_type='Group' and d.assignee in( ");
		strBuffer.append("select distinct c.name as group_name ");
		strBuffer
				.append("from t_user a left join t_group_user e on a.id=e.user_id ");
		strBuffer
				.append("left join t_group c on c.id=e.group_id where a.id=?)) ");
		strBuffer
				.append("or (d.assignee_type='Single User' and d.assignee=a.username)) ");
		strBuffer.append("and a.id=? ");
		String view = strBuffer.toString();
		String sql = "select distinct project_id from (" + view + ") as view";
		String sql2 = "select * from (" + view + ") as view where project_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setInt(2, id);
			pstmt.setInt(3, id);
			rs = pstmt.executeQuery();
			int projectId = 0;
			while (rs.next()) {
				projectId = rs.getInt("project_id");
				List<String> list = new ArrayList();
				pstmt2 = conn.prepareStatement(sql2);
				pstmt2.setInt(1, id);
				pstmt2.setInt(2, id);
				pstmt2.setInt(3, id);
				pstmt2.setInt(4, projectId);
				rs2 = pstmt2.executeQuery();
				while (rs2.next()) {
					list.add(rs2.getString("permission_name"));
				}
				userPermissions.put(projectId, list);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.closeConn(conn);
		}
		return userPermissions;
	}

	/**
	 * 判断用户是否为管理员。
	 * 
	 * @author sun
	 * @param userId
	 * @return
	 */

	public boolean isAdmin(int userId) {
		boolean flag = false;
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select group_id from t_user a,t_group_user b where a.id=b.user_id and a.id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if (rs.getInt("group_id") == 1) {
					flag = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.closeConn(conn);
		}
		return flag;
	}
}
