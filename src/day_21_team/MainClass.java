package day_21_team;

import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num;
		Member m = new Member();
		Product p = new Product();
		Event e = new Event();
		
		while(true) {
			System.out.println("Spring ȸ�� ���� �ý���");
			System.out.println("1.�λ���� 2.��ǰ���� 3.�̺�Ʈ���� 4.����");
			System.out.print(">>> ");
			num = input.nextInt();
			
			switch (num) {
			case 1:
				m.display();
				break;
			case 2:
				p.display();
				break;
			case 3:
				e.display();
				break;
			case 4:
				System.out.println("�����մϴ�");
				System.exit(0);
			}
			System.out.println();
		}
	}
}
