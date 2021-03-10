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
			System.out.println("====인사관리====");
			System.out.println("1.확인 2.등록 3.수정 4.삭제 5.뒤로");
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
		System.out.print("사원번호 입력 : ");
		m.setSerial(input.next());
		System.out.print("이름 입력 : ");
		m.setName(input.next());
		System.out.print("부서 입력 : ");
		m.setDepartment(input.next());
		System.out.print("직책 입력 : ");
		m.setPosition(input.next());
		System.out.print("입사년도 입력 : ");
		m.setYear(input.nextInt());
		
		m_db.saveMember(m);
		System.out.println("등록되었습니다.");
		// TODO Auto-generated method stub

	}

	@Override
	public void modify() {
		System.out.print("수정 사원번호 입력 : ");
		m.setSerial(input.next());
		System.out.print("수정 이름 입력 : ");
		m.setName(input.next());
		System.out.print("수정 부서 입력 : ");
		m.setDepartment(input.next());
		System.out.print("수정 직책 입력 : ");
		m.setPosition(input.next());
		System.out.print("수정 입사년도 입력 : ");
		m.setYear(input.nextInt());
		
		int result = m_db.modifyMember(m);
		if(result == 1) {
			System.out.println("수정되었습니다.");
		}
		else {
			System.out.println("수정 할 수 없습니다");
		}
		
		
		// TODO Auto-generated method stub

	}

	@Override
	public void delete() {
		System.out.print("삭제 할 사원번호 입력 : ");
		String serial = input.next();
		int result = m_db.deleteMember(serial);
		
		if(result == 1) {
			System.out.println("삭제되었습니다.");
		}
		else {
			System.out.println("삭제 할 수 없습니다.");
		}
		
		// TODO Auto-generated method stub

	}

	@Override
	public void back() {
		// TODO Auto-generated method stub
		roop = false;
	}

}
