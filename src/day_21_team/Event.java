package day_21_team;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Event implements interface_01 {
	private String url = "jdbc:oracle:thin:@210.108.48.214:1521:xe";
	private String id = "team5";
	private String pwd = "1004";
	private Scanner input = new Scanner(System.in);
	private int num;
	private boolean roop;
	
	Event_Data ed = new Event_Data();
	
	public Event() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		roop = true;
		while (roop) {
			System.out.println("====이벤트관리====");
			System.out.println("1.확인 2.등록 3.수정 4.삭제 5.뒤로");
			System.out.print(">>> ");
			num = input.nextInt();

			switch (num) {
			case 1:
				this.show();
				break;
			case 2:
				this.add();
				break;
			case 3:
				this.modify();
				break;
			case 4:
				this.delete();
				break;
			case 5:
				this.back();
				break;
			}
		}
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		String sql = "select * from event";
		try {
			Connection con = DriverManager.getConnection(url, id, pwd);
			PreparedStatement ps  = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			System.out.println("날짜\t이벤트\t담당자\t내용");
			System.out.println("----------------------------");
			while(rs.next()) {
				System.out.print(rs.getString("day"));
				System.out.print("\t");
				System.out.print(rs.getString("name"));
				System.out.print("\t");
				System.out.print(rs.getString("person"));
				System.out.print("\t");
				System.out.println(rs.getString("content"));
				System.out.println("============================");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		System.out.print("날짜 입력 : ");
		ed.setDay(input.next());
		System.out.print("이벤트 이름 입력 : ");
		ed.setName(input.next());
		System.out.print("담당자 입력 : ");
		ed.setPerson(input.next());
		System.out.print("내용 입력 : ");
		ed.setContent(input.next());
		String sql = "insert into event(day, name, person, content) values(?,?,?,?)";
		try {
			Connection con = DriverManager.getConnection(url, id, pwd);
			PreparedStatement ps  = con.prepareStatement(sql);
			ps.setString(1, ed.getDay());
			ps.setString(2, ed.getName());
			ps.setString(3, ed.getPerson());
			ps.setString(4, ed.getContent());
			ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modify() {
		// TODO Auto-generated method stub
		System.out.print("수정할 날짜 입력 : ");
		ed.setDay(input.next());
		System.out.print("수정할 이벤트 이름 입력 : ");
		ed.setName(input.next());
		System.out.print("수정할 담당자 입력 : ");
		ed.setPerson(input.next());
		System.out.print("수정 내용 입력 : ");
		ed.setContent(input.next());
		int result = 0;
		String sql = "update event set name=?, person=?, content=? where day=?";
		try {
			Connection con = DriverManager.getConnection(url, id, pwd);
			PreparedStatement ps  = con.prepareStatement(sql);
			ps.setString(1, ed.getName());
			ps.setString(2, ed.getPerson());
			ps.setString(3, ed.getContent());
			ps.setString(4, ed.getDay());
			ps.executeQuery();
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(result == 1) {
			System.out.println("성공적으로 수정했습니다.");
		}else {
			System.out.println("수정 중 문제가 발생했습니다.");
		}
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.print("삭제할 날짜 입력 : ");
		String day = input.next();
		String sql = "delete from event where day='" + day + "'";
		int result = 0;
		try {
			Connection con = DriverManager.getConnection(url, id, pwd);
			PreparedStatement ps  = con.prepareStatement(sql);
			result = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(result == 1) {
			System.out.println("성공적으로 삭제했습니다.");
		}else {
			System.out.println("삭제 중 문제가 발생했습니다.");
		}
	}

	@Override
	public void back() {
		// TODO Auto-generated method stub
		roop = false;
	}

}
