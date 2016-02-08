package com.nastation.pm.business;

/**
 * ���ܣ�����״̬��ҵ���߼���
 * @author ��ϣ��
 * 
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nastation.pm.bean.Icon;
import com.nastation.pm.bean.Issue;
import com.nastation.pm.bean.IssuePriority;
import com.nastation.pm.bean.IssueStatus;
import com.nastation.pm.bean.IssueType;
import com.nastation.pm.util.DBConn;

public class IssueStatusBO {

	/*
	 * �����ݿ�����Ӽ�¼ IssueStatus ����
	 */
	public void addIssueStatus(IssueStatus issueStatus) {

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into t_issue_status(name,description,icon_url)values(?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, issueStatus.getName());
			pstmt.setString(2, issueStatus.getDescription());
			pstmt.setString(3, issueStatus.getIconUrl());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBConn.closeConn(conn);
		}
	}

	/*
	 * ������֪�ļ�¼
	 */
	public void updateIssueStatus(IssueStatus issueStatus) {

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql = "update t_issue_status set name=?,description=?,icon_url=?where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, issueStatus.getName());
			pstmt.setString(2, issueStatus.getDescription());
			pstmt.setString(3, issueStatus.getIconUrl());
			pstmt.setInt(4, issueStatus.getId());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBConn.closeConn(conn);
		}
	}

	/*
	 * ������֪�� id �����IssueStatus����
	 */
	public IssueStatus getIssueStatus(int id) {

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		IssueStatus issueStatus = new IssueStatus();
		ResultSet rs = null;
		try {
			String sql = "select * from t_issue_status where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				issueStatus.setId(rs.getInt(1));
				issueStatus.setName(rs.getString(2));
				issueStatus.setDescription(rs.getString(3));
				issueStatus.setIconUrl(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBConn.closeConn(conn);
		}
		return issueStatus;
	}

	/*
	 * ������֪�� name �����IssueStatus����
	 */
	public IssueStatus getIssueStatus(String name) {

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		IssueStatus issueStatus = new IssueStatus();
		ResultSet rs = null;
		try {
			String sql = "select * from t_issue_status where name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				issueStatus.setId(rs.getInt(1));
				issueStatus.setName(rs.getString(2));
				issueStatus.setDescription(rs.getString(3));
				issueStatus.setIconUrl(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBConn.closeConn(conn);
		}
		return issueStatus;
	}

	/*
	 * ɾ����ӦID��IssueStatus ����
	 */
	public void deleteIssueStatus(int id) {

		Connection conn = DBConn.getConnection();
		try {
			String sql = "delete from t_issue_status where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.closeConn(conn);
		}
	}

	/*
	 * �������״̬�б� List
	 */
	public List<IssueStatus> getIssueStatusList() {

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;

		List<IssueStatus> list = new ArrayList<IssueStatus>();
		ResultSet rs = null;
		try {
			String sql = "select * from t_issue_status ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				IssueStatus issueStatus = new IssueStatus();
				issueStatus.setId(rs.getInt(1));
				issueStatus.setName(rs.getString(2));
				issueStatus.setDescription(rs.getString(3));
				issueStatus.setIconUrl(rs.getString(4));
				list.add(issueStatus);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBConn.closeConn(conn);
		}
		return list;
	}

	/**
	 * ����Ƿ񴴽���ͬ��IssueStatus
	 */
	public boolean exist(IssueStatus is) {
		Connection conn = DBConn.getConnection();
		try {
			String sql = "select id from t_issue_status where name=? and id!=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, is.getName());
			ps.setInt(2, is.getId());
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
	 * ��ô�ͼƬ���͵�list
	 * 
	 * @return
	 */
	public List<Icon> getIconList() {

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;

		List<Icon> list = new ArrayList<Icon>();
		ResultSet rs = null;
		try {
			String sql = "select * from t_icon where icon_type=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 1);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Icon icon = new Icon();
				icon.setId(rs.getInt(1));
				icon.setFileName(rs.getString(2));
				icon.setIconType(rs.getInt(3));
				list.add(icon);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBConn.closeConn(conn);
		}
		return list;
	}

	/**
	 * ����icon ������������б� List
	 */
	public List<IssueStatus> getIssueStatusListByIcon(Icon icon) {

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;

		List<IssueStatus> list = new ArrayList<IssueStatus>();
		ResultSet rs = null;
		try {
			String sql = "select * from t_issue_status where icon_url=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, icon.getFileName());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				IssueStatus status = new IssueStatus();
				status.setIconUrl(rs.getString(4));
				status.setName(rs.getString(2));
				list.add(status);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBConn.closeConn(conn);
		}
		return list;
	}
}
