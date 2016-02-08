package com.nastation.pm.business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.nastation.pm.util.DBConn;

public class ProjectIssueSequenceBO {

	/**
	 * ɾ��������Ŀģ��
	 */

	public void deleteAllProjectIssueSequence(int projectId) {
		Connection conn = DBConn.getConnection();
		try {
			String sql = "delete from t_project_issue_sequence where project_id=?";
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
	 * �ж�t_project_user�����Ƿ����projectId ������ھͷ���true����֮�򷵻�false
	 */

	public boolean checkProjectLinkProjectIssueSequence(int projectId) {
		Connection conn = DBConn.getConnection();
		boolean b = false;
		try {
			String sql = "select * from t_project_issue_sequence where project_id=?";
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
}
