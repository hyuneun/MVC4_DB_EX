package kr.co.m;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BuserModel {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource ds;
	
	public static BuserModel model = new BuserModel();
	public static BuserModel Instance(){
		return model;
	}
	
	public BuserModel() {
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc_maria");
		} catch (Exception e) {
			
		}
	}
	
	public ArrayList<BuserDto> getdataAll(){
		ArrayList<BuserDto> list = new ArrayList<>();
		try {
			String sql = "select * from buser";
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				BuserDto dto = new BuserDto();
				dto.setBuser_no(rs.getString("buser_no"));
				dto.setBuser_name(rs.getString("buser_name"));
				dto.setBuser_tel(rs.getString("buser_tel"));
				list.add(dto);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) rs.close();
				if(conn != null) rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return list;
	}
}
