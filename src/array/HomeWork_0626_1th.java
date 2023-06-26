package array;

import java.util.Scanner;

public class HomeWork_0626_1th {

	public static void main(String[] args) {
		char board[][] = new char[12][12];// 12*12 바둑판 배열
		boolean chk[][] = new boolean[12][12];// 중복값 판별용 배열

		// ----------------------------------------------------초기 바둑판 양식 배열에 저장
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
				
				chk[x][y] = false;
				System.out.printf("%c", board[y][x]);
			}
			System.out.println();
		} // 바둑판 만들기 닫기
			// ----------------------------------------------------
		int ox = -1; // 돌
		int oy = -1; // 돌

		// 이전좌표
		int xBefore = -1;
		int yBefore = -1;

		QUIT: while (true) {
			Scanner scan = new Scanner(System.in);

			System.out.println("┌───────────────────────────┐");
			System.out.println("│          Omok Game        │");
			System.out.println("└───────────────────────────┘");
			System.out.println();

			System.out.println("1. 게임시작");
			System.out.println("2. 도움말");
			System.out.println("3. 종료");
			System.out.print(">");
			int option = scan.nextInt();

			switch (option) {
			// 1. 게임시작
			case 1: {

				int count = 1;// 홀수일때 흰돌, 짝수일때 검돌

				GAMEOVER: while (true) {

					// 중복 제거 & 첫 사이클은 그냥 지나침.
					// 첫 사이클부터 통과하면 배열 변수 초기값 -1이여서 오류발생!
					if (ox != -1 && oy != -1 && !chk[ox][oy]) {
						xBefore = ox;
						yBefore = oy;

						if (count % 2 == 1)
							board[ox][oy] = '●';
						else if (count % 2 == 0)
							board[ox][oy] = '○';

						chk[ox][oy] = true;
						count++;

						System.out.printf("☆이전 좌표 : [%2d][%2d]☆\n", xBefore, yBefore);
					} else if (count > 1)
						System.out.println("\n☆★☆★중복 좌표입니다.☆★☆★");

					// 배열 바둑판 출력 양식.
					{
						for (int i = 0; i < 12; i++) {
							for (int j = 0; j < 12; j++) {
								System.out.print(board[i][j]);
							}
							System.out.println();
						}
					}

					// 좌표 입력
					do {
						System.out.println("\n그만두기:-1");
						if (count % 2 == 1)
							System.out.println("● 백돌 차례입니다");
						else
							System.out.println("○ 흑돌 차례입니다");
						System.out.print(" x sp y> ");

						ox = scan.nextInt();
						if (ox == -1) {
							System.out.println("GAMEOVER~~");
							break GAMEOVER;
						}
						oy = scan.nextInt();

						// 1~11 범위를 벗어나면 배열 Index오류 발생!! ☆★중요☆★ 예) 15입력시 오류발생해서 멈춤...
						if (!(1 <= ox && ox <= 11) || !(1 <= oy && oy <= 11)) {
							System.out.println("\n              ♨경고♨                ");
							System.out.println("오목 좌표의 범위(-1 or 1~11)를 벗어났습니다.");
						}

					} while (!(1 <= ox && ox <= 11) || !(1 <= oy && oy <= 11));
					System.out.println("==================================");

				}
			}
				break;

			// 2. 도움말.
			case 2: {
				System.out.println("좌표를 입력하면 게임을 할 수 있다");
				break;
			}
			// 3. 종료
			case 3: {
				System.out.println("종료");
				break QUIT;
			}
			}
		}
	}

}
