package kr.co.m;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class SawonModel {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource ds;
	
	public static SawonModel model = new SawonModel();
	public static SawonModel Instance(){
		return model;
	}
	
	public SawonModel() {
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc_maria");
		} catch (Exception e) {
			
		}
	}
	
	public ArrayList<SawonDto> getdataAll(String buser){
		ArrayList<SawonDto> list = new ArrayList<>();
		try {
			String sql = "select * from sawon inner join buser on buser_no=buser_num where buser_name='" + buser + "'";
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println(sql);
			while(rs.next()){
				SawonDto dto = new SawonDto();
				dto.setSawon_no(rs.getString("sawon_no"));
				dto.setSawon_name(rs.getString("sawon_name"));
				dto.setSawon_jik(rs.getString("sawon_jik"));
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
