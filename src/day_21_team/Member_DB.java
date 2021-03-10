package day_21_team;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Member_DB {
	private String url = "jdbc:oracle:thin:@210.108.48.214:1521";
	private String id = "team5";
	private String pwd = "1004";

	
	public Member_DB() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void getMember() {
		String sql = "select * from manage";
		
		try {
			Connection con = DriverManager.getConnection(url, id, pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			System.out.println("사원번호\t이름\t부서\t직책\t입사년도");
			System.out.println("--------------------------------------");
			while(rs.next()) {
				System.out.print(rs.getString("serial"));
				System.out.print("\t");
				System.out.print(rs.getString("name"));
				System.out.print("\t");
				System.out.print(rs.getString("department"));
				System.out.print("\t");
				System.out.print(rs.getString("position"));
				System.out.print("\t");
				System.out.println(rs.getString("year"));
				System.out.println("______________________________________");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void saveMember(Member_Data m) {
		String sql = "insert into manage(serial, name, department, position, year) values(?, ?, ?, ?, ?)";
		
		try {
			Connection con = DriverManager.getConnection(url, id, pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, m.getSerial());
			ps.setString(2, m.getName());
			ps.setString(3, m.getDepartment());
			ps.setString(4, m.getPosition());
			ps.setInt(5, m.getYear());
			ps.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int modifyMember(Member_Data m) {
		String sql = "update manage set name=?, department=?, position=?, year=? where serial=?";
		int result = 0;
		
		try {
			Connection con = DriverManager.getConnection(url, id, pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, m.getName());
			ps.setString(2, m.getDepartment());
			ps.setString(3, m.getPosition());
			ps.setInt(4, m.getYear());
			ps.setString(5, m.getSerial());
			result = ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}
	public int deleteMember(String serial) {
		String sql = "delete from manage where serial=?";
		int result = 0;
		try {
			Connection con = DriverManager.getConnection(url, this.id, pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, serial);;
			result = ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		return result;
	}

}
