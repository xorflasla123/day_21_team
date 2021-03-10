package day_21_team;

import java.util.Scanner;

public class Member implements interface_01{
	private Scanner input = new Scanner(System.in);
	private int num;
	private boolean roop;

	@Override
	public void display() {
		// TODO Auto-generated method stub
		roop=true;
		while(roop) {
			System.out.println("====인사관리====");
			System.out.println("1.확인 2.등록 3.수정 4.삭제 5.뒤로");
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
		
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void back() {
		// TODO Auto-generated method stub
		roop = false;
	}

}
