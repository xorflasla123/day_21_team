package day_21_team;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner; 

public class Product implements interface_01{
	private String url = "jdbc:oracle:thin:@210.108.48.214:1521:xe";
	private String id = "team5";
	private String pwd = "1004"; 
	private Scanner input = new Scanner(System.in);
	private int num;
	private boolean roop;
	
	Product_Data pd = new Product_Data();
	
	public Product() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	} 

	@Override
	public void display() {
		// TODO Auto-generated method stub
		roop=true;
		while(roop) {
			System.out.println("====��ǰ����====");
			System.out.println("1.Ȯ�� 2.��� 3.���� 4.���� 5.�ڷ�");
			System.out.print(">>> ");
			num = input.nextInt();
			
			switch(num) {
			case 1: this.show(); break;
			case 2: this.add(); break;
			case 3: this.modify(); break;
			case 4: this.delete(); break;
			case 5: this.back(); break;
			}
		}
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
	String sql = "select * from product";
	try {
		Connection con = DriverManager.getConnection(url,id,pwd);
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		System.out.println("��ǰ��ȣ\t��ǰ�̸�\t��ǰ����");
		System.out.println("------------------------------");
		while(rs.next()) { 
			System.out.println(rs.getString("serial"));
			System.out.println(rs.getString("name"));
			System.out.println(rs.getInt("count"));
			System.out.println("=================");
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} 
}
		

 

	@Override
	public void add() {
		// TODO Auto-generated method stub
		System.out.println("��ǰ��ȣ �Է� : ");
		pd.setSerial(input.next());
		System.out.println("��ǰ�̸� �Է� : ");
		pd.setName(input.next());
		System.out.println("��ǰ���� �Է� : ");
		pd.setCount(input.nextInt());
		String sql = "insert into product(serial, name, count) values(?,?,?)";
		try {
			Connection con = DriverManager.getConnection(url, id, pwd);
			PreparedStatement ps  = con.prepareStatement(sql);
			ps.setString(1, pd.getSerial());
			ps.setString(2, pd.getName());
			ps.setInt(3, pd.getCount());
			ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void modify() {
		// TODO Auto-generated method stub
		System.out.println("������ ��ǰ��ȣ �Է� : ");
		pd.setSerial(input.next());
		System.out.println("������ ��ǰ�̸� �Է� : ");
		pd.setName(input.next());
		System.out.println("������ ��ǰ���� �Է� : ");
		pd.setCount(input.nextInt());
		String sql = "update product set name=?, count=? where serial=?";
		int result = 0;
		try {
			Connection con = DriverManager.getConnection(url,id,pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,  pd.getName()); 
			ps.setInt(2, pd.getCount()); 
			ps.setString(3, pd.getSerial()); 
			ps.executeQuery();
			result = ps.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(result == 1) {
			System.out.println("���������� �����߽��ϴ�.");
		}else {
			System.out.println("���� �� ������ �߻��߽��ϴ�.");
		}
	}
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("���� �� ��ǰ��ȣ �Է� : ");
		String serial = input.next();
		String sql = "delete from product where serial='"+serial+"'";
		int result =0;
		try {
			Connection con = DriverManager.getConnection(url,this.id,pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			result = ps.executeUpdate();			
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(result == 1) {
			System.out.println("���������� �����߽��ϴ�");
		}else {
			System.out.println("���� �� ������ �߻��߽��ϴ�");
		} 
		
	}

	@Override
	public void back() {
		// TODO Auto-generated method stub
		roop = false;
	}

} 

