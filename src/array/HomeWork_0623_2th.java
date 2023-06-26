package array;

import java.util.Scanner;

public class HomeWork_0623_2th {

	public static void main(String[] args) {
		// n개의 돌이 찍히는 바둑돌 만들기(홀수 시도는 하얀돌 / 짝수 시도는 검은돌), 찍힌 돌들이이 바둑판에 남겨있어야한다. 찍힌 돌이 중복이되면 안된다. 
		
		OVER:
		while (true) {
			System.out.println("┌─────────────────────────────┐");
			System.out.println("│         Omok Game           │");
			System.out.println("└─────────────────────────────┘");
			System.out.println("1. 게임시작");
			System.out.println("2. 도움말");
			System.out.println("3. 종료");
			System.out.print(">");

			Scanner scan = new Scanner(System.in);
			int menu = scan.nextInt(); // 오목게임의 메뉴를 받을 것이니 변수명 menu
			char[][] board = new char[12][12]; // 바둑돌 좌표
			
			switch (menu) {
			case 1: {
				{
					for (int y = 0; y < 12; y++) { // 바둑판 만들기
						for (int x = 0; x < 12; x++) {
							board[y][x] = '┼';
							board[y][11] = '┤';
							board[0][x] = '┬';
							board[11][x] = '┴';
							board[y][0] = '├';
							board[0][0] = '┌';
							board[0][11] = '┐';
							board[11][0] = '└';
							board[11][11] = '┘';
							System.out.printf("%c", board[y][x]);
						}
						System.out.println();
					} // 바둑판 만들기 닫기
				} // 지역화
				GAMEOVER: while (true) { // 값의 입력 및 조건이 설정된다.
					int ox = -1; // 값을 입력받는다.
					int oy = -1;

					do {
						System.out.println("그만두기: -1 0");
						System.out.print("(x sp y): ");

						ox = scan.nextInt();
						oy = scan.nextInt();

						if (ox == -1) {
							System.out.println("★GAME OVER★");
//		                  return; // break이면 do~while문 안에 갇혀버리기 때문에 return으로 강제 종료한다.
							break GAMEOVER;
						} // if

						if (!((1 <= ox && ox <= 10) && (1 <= oy && oy <= 10)))
							System.out.println("오목 좌표의 범위(-1 or 1~10)를 벗어났습니다."); // while(true)문 안에서 반복되어야 하지만 조건이
						// 달성되어야만 돌아거라서 조건을 따로 한 번 더 걸어줬다.

					} while (!((1 <= ox && ox <= 10) && (1 <= oy && oy <= 10)));

					for (int y = 0; y < 12; y++) { // 바둑판 만들기
						for (int x = 0; x < 12; x++) {
							if ( x% 2 == 0) { // 시도횟수가 짝수면 검은돌이 놓인다
								board[y][x] = '┼';
								board[y][11] = '┤';
								board[0][x] = '┬';
								board[11][x] = '┴';
								board[y][0] = '├';
								board[0][0] = '┌';
								board[0][11] = '┐';
								board[11][0] = '└';
								board[11][11] = '┘';
								board[oy][ox] = '●';
							} else if( x%2 != 0) { // 시도횟수가 홀수면 하얀돌이 놓인다
								board[y][x] = '┼';
								board[y][11] = '┤';
								board[0][x] = '┬';
								board[11][x] = '┴';
								board[y][0] = '├';
								board[0][0] = '┌';
								board[0][11] = '┐';
								board[11][0] = '└';
								board[11][11] = '┘';
								board[oy][ox] = '○';
							}
							System.out.printf("%c", board[y][x]);

						} // 바둑판 만들기 닫기
						System.out.println();
					} // for i
				} // while 1
			} // case 1
				break;
			// 2. 도움말
			case 2: {
				System.out.println("도움말");
				break;

				// 3. 종료
			}
			case 3: {
				System.out.println("종료");
				break OVER;

			}
			default:
				System.out.println("메뉴는 1부터 3까지 밖에 없습니다..");
			}// switch
		} // while
	}// main
}// class
