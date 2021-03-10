package day_21_team;

import java.util.Scanner;

public class Member implements interface_01{
	private Scanner input = new Scanner(System.in);
	private int num;
	private boolean roop;
	Member_DB m_db = new Member_DB();
	Member_Data m = new Member_Data();

	@Override
	public void display() {
		// TODO Auto-generated method stub
		roop=true;
		while(roop) {
			System.out.println();
			System.out.println("====�λ����====");
			System.out.println("1.Ȯ�� 2.��� 3.���� 4.���� 5.�ڷ�");
			System.out.print(">>> ");
			num = input.nextInt();

			switch(num) {
			case 1: 
				this.show();
				break;
			case 2: this.add(); break;
			case 3: this.modify(); break;
			case 4: this.delete(); break;
			case 5: this.back(); break;
			}
		}
	}

	@Override
	public void show() {
		m_db.getMember();
		// TODO Auto-generated method stub

	}

	@Override
	public void add() {
		System.out.print("�����ȣ �Է� : ");
		m.setSerial(input.next());
		System.out.print("�̸� �Է� : ");
		m.setName(input.next());
		System.out.print("�μ� �Է� : ");
		m.setDepartment(input.next());
		System.out.print("��å �Է� : ");
		m.setPosition(input.next());
		System.out.print("�Ի�⵵ �Է� : ");
		m.setYear(input.nextInt());
		
		m_db.saveMember(m);
		System.out.println("��ϵǾ����ϴ�.");
		// TODO Auto-generated method stub

	}

	@Override
	public void modify() {
		System.out.print("���� �����ȣ �Է� : ");
		m.setSerial(input.next());
		System.out.print("���� �̸� �Է� : ");
		m.setName(input.next());
		System.out.print("���� �μ� �Է� : ");
		m.setDepartment(input.next());
		System.out.print("���� ��å �Է� : ");
		m.setPosition(input.next());
		System.out.print("���� �Ի�⵵ �Է� : ");
		m.setYear(input.nextInt());
		
		int result = m_db.modifyMember(m);
		if(result == 1) {
			System.out.println("�����Ǿ����ϴ�.");
		}
		else {
			System.out.println("���� �� �� �����ϴ�");
		}
		
		
		// TODO Auto-generated method stub

	}

	@Override
	public void delete() {
		System.out.print("���� �� �����ȣ �Է� : ");
		String serial = input.next();
		int result = m_db.deleteMember(serial);
		
		if(result == 1) {
			System.out.println("�����Ǿ����ϴ�.");
		}
		else {
			System.out.println("���� �� �� �����ϴ�.");
		}
		
		// TODO Auto-generated method stub

	}

	@Override
	public void back() {
		// TODO Auto-generated method stub
		roop = false;
	}

}
