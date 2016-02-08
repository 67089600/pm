/**
 * ������Projectҵ���߼���
 * ���ߣ��Ų�
 * ���ڣ�2008-12-18
 */
package com.nastation.pm.business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.nastation.pm.bean.Project;
import com.nastation.pm.bean.User;
import com.nastation.pm.util.DBConn;

public class ProjectBO {

	/**
	 * ���һ����Ŀ
	 * 
	 * @param project
	 *            ����Ŀ�����Ϣ�������ݿ����
	 */
	public void addProject(Project project) {
		Connection conn = DBConn.getConnection();

		try {

			boolean beforeCommit = conn.getAutoCommit();
			conn.setAutoCommit(false);

			// insert project infomation.
			String sql = "insert into t_project(name,project_key,description,url,leader,category_id,permission_scheme_id,create_date) value(?,?,?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, project.getName());
			pst.setString(2, project.getProjectKey());
			pst.setString(3, project.getDescription());
			pst.setString(4, project.getUrl());
			pst.setString(5, project.getLeader());
			pst.setNull(6, Types.NULL);
			pst.setInt(7, project.getPermissionSchemeId());
			pst.setString(8, project.getCreateDate());
			pst.executeUpdate();
          
			// get new project id
			String sql3 = "select id from t_project where project_key=?";
			System.out.println("=======sql3===" + sql3);
			PreparedStatement pst3 = conn.prepareStatement(sql3);
			pst3.setString(1, project.getProjectKey());
			ResultSet rs = pst3.executeQuery();
			int projectId = 0;
			if (rs.next()) {
				projectId = rs.getInt("id");
			}

			  //����Ŀ��������Ϣ���뵽t_project_user;
			String sql1="insert t_project_user (project_id,user_id,role_id,create_date) values(?,?,?,curdate())";
			PreparedStatement pstmt=conn.prepareStatement(sql1);
			UserBO userBO=new UserBO();
			User user=userBO.getUser(project.getLeader());
			pstmt.setInt(1,projectId);
			pstmt.setInt(2, user.getId());
			pstmt.setInt(3, 1);//��ɫID��1Ϊ����Ա��
			pstmt.executeUpdate();
			
			
			// insert initial project issue key
			String sql2 = "insert into t_project_issue_sequence(project_id,max_id_value) value(?,?)";
			System.out.println("=======sql2===" + sql2);
			System.out.println("=======projectId===" + projectId);
			PreparedStatement pst2 = conn.prepareStatement(sql2);
			pst2.setInt(1, projectId);
			pst2.setInt(2, 1); // ��ʼֵΪ1
			pst2.executeUpdate();

			conn.commit();
			conn.setAutoCommit(beforeCommit);

		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBConn.closeConn(conn);
		}
	}

	/**
	 * ���һ����Ŀ��Ϣ
	 * 
	 * @param id
	 * @return �������ݿ���һ����Ŀ����ϸ��Ϣ
	 */
	public Project getProject(int id) {
		Project project = new Project();
		Connection conn = DBConn.getConnection();
		try {
			String sql = "select * from t_project where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				project.setProjectId(id);
				project.setName(rs.getString("name"));
				project.setProjectKey(rs.getString("project_key"));
				project.setDescription(rs.getString("description"));
				project.setUrl(rs.getString("url"));
				project.setLeader(rs.getString("leader"));
				project.setCategoryId(rs.getInt("category_id"));
				project.setPermissionSchemeId(rs.getInt("permission_scheme_id"));
				project.setCreateDate(rs.getString("create_date"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.closeConn(conn);
		}
		return project;
	}
	
	/**
	 * ͨ����Ŀ����ø���ĿID
	 * @param name
	 * @return id
	 */
	public int getProjectId(String name) {
		Connection conn = DBConn.getConnection();
		int id = 0;
		try {
			String sql = "select id from t_project where name=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				id = rs.getInt("id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.closeConn(conn);
		}
		return id;
	}

	/**
	 * �ж���Ŀ���Ƿ��Ѿ�����
	 * 
	 * @param projectName
	 * @param projectKey
	 * @return true if exist, otherwise return false.
	 */
	public boolean existName(Project project) {
		Connection conn = DBConn.getConnection();
		try {
			String sql = "select id from t_project where name=? and id!=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, project.getName());
			ps.setInt(2, project.getProjectId());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.closeConn(conn);
		}
		return false;
	}
	/**
	 * �ж�key�Ƿ��Ѿ�����
	 * @param key
	 * @return
	 */
	public boolean existKey(Project project) {
		Connection conn = DBConn.getConnection();
		try {
			String sql = "select id from t_project where project_key=? and id!=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, project.getProjectKey());
			ps.setInt(2, project.getProjectId());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.closeConn(conn);
		}
		return false;
	}
	
	/**
	 * �޸���Ŀ��Ϣ
	 * 
	 * @param project
	 */

	public void updateProject(Project project) {
		Connection conn = DBConn.getConnection();
		try {
			String sql = "update t_project set name=?,description=?,url=?,leader=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, project.getName());
			ps.setString(2, project.getDescription());
			ps.setString(3, project.getUrl());
			ps.setString(4, project.getLeader());
			ps.setInt(5, project.getProjectId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.closeConn(conn);
		}
	}

	/**
	 * ɾ��һ����Ŀ
	 * 
	 * @param id
	 */

	public void deleteProject(int id) {
		Connection conn = DBConn.getConnection();
		try {
			String sql = "delete from t_project where id=?";
			System.out.println("==sql==" + sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.closeConn(conn);
		}
	}

	/**
	 * ������ݿ���t_project�������е���Ϣ
	 * 
	 * @return ����һ���������Ŀ��Ϣ��List
	 */

	public List getProjectList() {
		List list = new ArrayList();
		Connection conn = DBConn.getConnection();
		try {
			String sql = "select * from t_project";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Project project = new Project();
				project.setProjectId(rs.getInt("id"));
				project.setName(rs.getString("name"));
				project.setProjectKey(rs.getString("project_key"));
				project.setDescription(rs.getString("description"));
				project.setUrl(rs.getString("url"));
				project.setLeader(rs.getString("leader"));
				project.setCategoryId(rs.getInt("category_id"));
				project.setPermissionSchemeId(rs.getInt("permission_scheme_id"));
				project.setCreateDate(rs.getString("create_date"));
				list.add(project);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.closeConn(conn);
		}
		return list;
	}

	/**
	 * ������Ŀ����
	 */

	public void updateProject1(Project project) {
		Connection conn = DBConn.getConnection();
		try {
			String sql = "update t_project set name=?,project_key=?,description=?,url=?,leader=?,category_id=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, project.getName());
			ps.setString(2, project.getProjectKey());
			ps.setString(3, project.getDescription());
			ps.setString(4, project.getUrl());
			ps.setString(5, project.getLeader());
			ps.setInt(6, project.getCategoryId());
			ps.setInt(7, project.getProjectId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.closeConn(conn);
		}
	}

	/**
	 * ����ָ��ProjectId�������������ֵ
	 * 
	 * @param projectId
	 * @return
	 */
	public int getProjectIssueMaxId(int projectId) {
		Connection conn = DBConn.getConnection();
		int id = 0;
		try {
			boolean beforeCommit = conn.getAutoCommit();
			conn.setAutoCommit(false);

			// get max id value
			String sql = "select max_id_value from t_project_issue_sequence where project_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, projectId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				id = rs.getInt("max_id_value");
			}

			// increment max_id_value
			String sql2 = "update t_project_issue_sequence set max_id_value=max_id_value+1 where project_id=?";
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setInt(1, projectId);
			ps2.executeUpdate();

			conn.commit();
			conn.setAutoCommit(beforeCommit);

		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBConn.closeConn(conn);
		}
		return id;
	}
    
	/**
	 * ����һ��Ȩ��ģ���µ�������Ŀ��Ϣ
	 * @param schemeId
	 * @return
	 * @author sun
	 */
	public List<Project> getProjectListByScheme(int schemeId) {
        List<Project> list = new ArrayList();
        Connection conn=DBConn.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs=null;
        try{
        	String sql = "select id,name from t_project where permission_scheme_id=?";
        	pstmt=conn.prepareStatement(sql);
        	pstmt.setInt(1, schemeId);
        	rs = pstmt.executeQuery();
        	while(rs.next()){
        		Project project = new Project();
        		project.setProjectId(rs.getInt("id"));
        		project.setName(rs.getString("name"));
        		list.add(project);
        	}
        }catch(SQLException e){
        	e.printStackTrace();
        }finally{
        	
        	DBConn.closeConn(conn);
        }
		return list;
	}
    /**
     * �ı�һ����Ŀʹ�õ�ģ��
     * @param projectId,schemeId
     */
	public void changeScheme(int projectId,int schemeId){
		Connection conn=DBConn.getConnection();
		PreparedStatement pstmt=null;
		String sql="update t_project set permission_scheme_id=? where id=?";
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, schemeId);
			pstmt.setInt(2, projectId);
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConn.closeConn(conn);
		}
	}
}
