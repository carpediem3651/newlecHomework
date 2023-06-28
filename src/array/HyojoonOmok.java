package array;

public class HyojoonOmok {

	public static void main(String[] args) {
		// 0623과제 흑백 돌 번갈아두기 까지 만들기
		// 저번에 한거는 순서기반, 이번에는 배열을통해서 순서기반을 벗어나보자
		char[][] board = new char[12][12];

		for (int y = 0; y < 12; y++)
			for (int x = 0; x < 12; x++)
				board[y][x] = '┼';// 오목판전체를 +모양으로 배치

		board[0][0] = '┌';
		board[0][11] = '┐';
		board[11][0] = '└';
		board[11][11] = '┘';// 모서리 바꾸기

		for (int i = 0; i < 10; i++)
			board[i + 1][0] = '├';
		for (int i = 0; i < 10; i++)
			board[i + 1][11] = '┤';
		for (int i = 0; i < 10; i++)
			board[11][i + 1] = '┴';
		for (int i = 0; i < 10; i++)
			board[0][i + 1] = '┬';// 네 변 바꾸기

		// 오목판 초기화만하고 출력은 x

		Gameover: while (true) {
			System.out.println("┌───────────┐");
			System.out.println("│ Omok Game │");
			System.out.println("└───────────┘");

			System.out.println("1.게임시작");
			System.out.println("2.도움말");
			System.out.println("3.저장하기");
			System.out.println("4.불러오기");
			System.out.println("9.종료");
			System.out.println(">");

			Scanner scan = new Scanner(System.in);
			int menu = scan.nextInt();

			switch (menu) {
			case 1: {
				// 만들어뒀던 오목판 출력
				for (int y = 0; y < 12; y++) {
					for (int x = 0; x < 12; x++)
						System.out.printf("%c", board[y][x]);

					System.out.println();
				}
				// 검은돌두기 & 흰돌두기 while문
				while (true) {

					// 검은돌두기
					System.out.println("(ox oy)중 ox,oy를 순서대로 입력하세요");
					System.out.println("(-1 -1)입력시 종료됩니다.");

					int ox = scan.nextInt();
					int oy = scan.nextInt();

					// 종료검사
					if (ox == -1 && oy == -1)
						break;
					// 범위검사1
					else if (!((1 <= ox) && (ox <= 10))) {
						do {
							System.out.println("x축 범위를 벗어났습니다. 1~10중 다시입력하세요");
							ox = scan.nextInt();
							oy = scan.nextInt();

						} while (!(1 <= ox) && (ox <= 10));
					}
					// 범위검사1
					else if (!((1 <= oy) && (oy <= 10))) {
						do {
							System.out.println("y축 범위를 벗어났습니다. 1~10중 다시입력하세요");
							ox = scan.nextInt();
							oy = scan.nextInt();
						} while (!(1 <= oy) && (oy <= 10));
					}
					// 중복검사
					else if (board[oy][ox] == '●' || board[oy][ox] == '○') {
						do {
							System.out.println("오목알이 있는곳엔 둘수없습니다. 다른곳에 두세요");
							ox = scan.nextInt();
							oy = scan.nextInt();
						} while (board[oy][ox] == '●' || board[oy][ox] == '○');
					}

					// 검사완료된 돌두기
					board[oy][ox] = '●';
					for (int y = 0; y < 12; y++) {
						for (int x = 0; x < 12; x++)
							System.out.printf("%c", board[y][x]);

						System.out.println();

					}
					// 흰돌두기
					System.out.println("(ox oy)중 ox,oy를 순서대로 입력하세요");
					System.out.println("(-1 -1)입력시 종료됩니다.");

					ox = scan.nextInt();
					oy = scan.nextInt();

					if (ox == -1 && oy == -1)
						break;
					// 범위검사
					else if (!((1 <= ox) && (ox <= 10))) {
						do {
							System.out.println("x축 범위를 벗어났습니다. 1~10중 다시입력하세요");
							ox = scan.nextInt();
							oy = scan.nextInt();
						} while (!(1 <= ox) && (ox <= 10));
					} else if (!((1 <= oy) && (oy <= 10))) {
						do {
							System.out.println("y축 범위를 벗어났습니다. 1~10중 다시입력하세요");
							ox = scan.nextInt();
							oy = scan.nextInt();
						} while (!(1 <= oy) && (oy <= 10));
					}
					// 중복검사
					else if (board[oy][ox] == '●' || board[oy][ox] == '○') {// 범위조건을 위로올린이유는 범위밖을 입력하고 배열을 받게되면
																			// 배열범위넘어가는오류나옴
						do {
							System.out.println("오목알이 있는곳엔 둘수없습니다. 다른곳에 두세요");
							ox = scan.nextInt();
							oy = scan.nextInt();
						} while (board[oy][ox] == '●' || board[oy][ox] == '○');
					}
					// 검사완료된돌 두기
					board[oy][ox] = '○';
					for (int y = 0; y < 12; y++) {
						for (int x = 0; x < 12; x++)
							System.out.printf("%c", board[y][x]);

						System.out.println();
					} // 흰돌 놓고 전체 오목판 출력코드

				} // 돌두는 while문
				break;

			}
			case 2:

			case 3:
				FileOutputStream fos = new FileOutputStream("res/omokSave");
				PrintWriter fout = new PrintWriter(fos);
				// 숫자로변경
				for (int j = 0; j < 12; j++) {
					for (int i = 0; i < 12; i++) {
						if (board[j][i] == '○')
							board[j][i] = '1';// 백돌은 1
						else if (board[j][i] == '●')
							board[j][i] = '2';// 흑돌은 2
						else
							board[j][i] = '0';// 나머지 문자는 0
					}
				}
				// 숫자로바꾼거 저장
				for (int j = 0; j < 12; j++) {
					for (int i = 0; i < 12; i++)
						fout.printf("%c ", board[j][i]);
					fout.println();
				}
				System.out.println("┌───────────┐");
				System.out.println("│   저장 완료  │");
				System.out.println("└───────────┘");

				fout.close();
				fos.close();
				break;

			case 4:
				FileInputStream fis = new FileInputStream("res/omokSave");
				Scanner fscan = new Scanner(fis);
				// 불러올 파일을 넣을 배열 생성
				int[][] saveLoad = new int[12][12];

				// 숫자로 저장된 오목판 배열에 담기
				for (int j = 0; j < 12; j++)
					for (int i = 0; i < 12; i++)
						saveLoad[j][i] = fscan.nextInt();

//	                     for(int j=0 ;j<12; j++) {
//	                        for(int i=0 ; i<12 ; i++)
//	                           System.out.printf("%d", saveLoad[j][i]);
//	                        System.out.println();
//	                     }   //잘 저장됬나 확인해봄

				// 숫자<ㅡ>바둑알
				for (int j = 0; j < 12; j++)
					for (int i = 0; i < 12; i++) {
						if (saveLoad[j][i] == 1)
							saveLoad[j][i] = '○';// 1은 백돌
						else if (saveLoad[j][i] == 2)
							saveLoad[j][i] = '●';// 2는 흑돌
						else
							saveLoad[j][i] = '┼';// 전체 일단 십자가로 하고 뒤에 테두리 작업하자
					}

				for (int i = 0; i < 10; i++)
					saveLoad[i + 1][0] = '├';
				for (int i = 0; i < 10; i++)
					saveLoad[i + 1][11] = '┤';
				for (int i = 0; i < 10; i++)
					saveLoad[11][i + 1] = '┴';
				for (int i = 0; i < 10; i++)
					saveLoad[0][i + 1] = '┬';// 네 변

				saveLoad[0][0] = '┌';
				saveLoad[0][11] = '┐';
				saveLoad[11][0] = '└';
				saveLoad[11][11] = '┘';// 모서리 바꾸기

				int turnCount = 0;// 저장된 돌갯수카운트해서 시작시 누구 턴인지 확인
				for (int y = 0; y < 12; y++) {
					for (int x = 0; x < 12; x++) {
						System.out.printf("%c", saveLoad[y][x]);// 불러온 오목판 출력
						if (saveLoad[y][x] == '●' || saveLoad[y][x] == '○')
							turnCount++;
					}
					System.out.println();
				}

				// 검은돌두기 & 흰돌두기
				while (true) {
					if (turnCount % 2 == 0) {
						// 검은돌두기, 검은돌차례임
						System.out.println("(ox oy)중 ox,oy를 순서대로 입력하세요");
						System.out.println("(-1 -1)입력시 종료됩니다.");

						int ox = scan.nextInt();
						int oy = scan.nextInt();

						// 종료입력 검사
						if (ox == -1 && oy == -1)
							break;
						// 범위검사
						else if (!((1 <= ox) && (ox <= 10))) {
							do {
								System.out.println("x축 범위를 벗어났습니다. 1~10중 다시입력하세요");
								ox = scan.nextInt();
								oy = scan.nextInt();

							} while (!(1 <= ox) && (ox <= 10));
						} else if (!((1 <= oy) && (oy <= 10))) {
							do {
								System.out.println("y축 범위를 벗어났습니다. 1~10중 다시입력하세요");
								ox = scan.nextInt();
								oy = scan.nextInt();
							} while (!(1 <= oy) && (oy <= 10));
						}
						// 중복검사
						else if (saveLoad[oy][ox] == '●' || saveLoad[oy][ox] == '○') {
							do {
								System.out.println("오목알이 있는곳엔 둘수없습니다. 다른곳에 두세요");
								ox = scan.nextInt();
								oy = scan.nextInt();
							} while (saveLoad[oy][ox] == '●' || saveLoad[oy][ox] == '○');
						}

						// 검사완료된 돌두기
						saveLoad[oy][ox] = '●';
						for (int y = 0; y < 12; y++) {
							for (int x = 0; x < 12; x++)
								System.out.printf("%c", saveLoad[y][x]);

							System.out.println();
						}

						// 흰돌두기
						System.out.println("(ox oy)중 ox,oy를 순서대로 입력하세요");
						System.out.println("(-1 -1)입력시 종료됩니다.");

						ox = scan.nextInt();
						oy = scan.nextInt();

						if (ox == -1 && oy == -1)
							break;
						// 범위검사
						else if (!((1 <= ox) && (ox <= 10))) {
							do {
								System.out.println("x축 범위를 벗어났습니다. 1~10중 다시입력하세요");
								ox = scan.nextInt();
								oy = scan.nextInt();
							} while (!(1 <= ox) && (ox <= 10));
						} else if (!((1 <= oy) && (oy <= 10))) {
							do {
								System.out.println("y축 범위를 벗어났습니다. 1~10중 다시입력하세요");
								ox = scan.nextInt();
								oy = scan.nextInt();
							} while (!(1 <= oy) && (oy <= 10));
						}
						// 중복검사
						else if (saveLoad[oy][ox] == '●' || saveLoad[oy][ox] == '○') {// 범위조건을 위로올린이유는 범위밖을 입력하고 배열을
																						// 받게되면 배열범위넘어가는오류나옴
							do {
								System.out.println("오목알이 있는곳엔 둘수없습니다. 다른곳에 두세요");
								ox = scan.nextInt();
								oy = scan.nextInt();
							} while (saveLoad[oy][ox] == '●' || saveLoad[oy][ox] == '○');
						}
						// 검사완료된돌 두기
						board[oy][ox] = '○';
						for (int y = 0; y < 12; y++) {
							for (int x = 0; x < 12; x++)
								System.out.printf("%c", saveLoad[y][x]);

							System.out.println();
						} // 흰돌 놓고 전체 오목판 출력코드

					} // if문 끝

					else if (!(turnCount % 2 == 0)) {

						// 흰돌두기, 흰돌차례임
						System.out.println("(ox oy)중 ox,oy를 순서대로 입력하세요");
						System.out.println("(-1 -1)입력시 종료됩니다.");

						int ox = scan.nextInt();
						int oy = scan.nextInt();

						if (ox == -1 && oy == -1)
							break;
						// 범위검사
						else if (!((1 <= ox) && (ox <= 10))) {
							do {
								System.out.println("x축 범위를 벗어났습니다. 1~10중 다시입력하세요");
								ox = scan.nextInt();
								oy = scan.nextInt();
							} while (!(1 <= ox) && (ox <= 10));
						} else if (!((1 <= oy) && (oy <= 10))) {
							do {
								System.out.println("y축 범위를 벗어났습니다. 1~10중 다시입력하세요");
								ox = scan.nextInt();
								oy = scan.nextInt();
							} while (!(1 <= oy) && (oy <= 10));
						}
						// 중복검사
						else if (saveLoad[oy][ox] == '●' || saveLoad[oy][ox] == '○') {// 범위조건을 위로올린이유는 범위밖을 입력하고 배열을
																						// 받게되면 배열범위넘어가는오류나옴
							do {
								System.out.println("오목알이 있는곳엔 둘수없습니다. 다른곳에 두세요");
								ox = scan.nextInt();
								oy = scan.nextInt();
							} while (saveLoad[oy][ox] == '●' || saveLoad[oy][ox] == '○');
						}
						// 검사완료된돌 두기
						saveLoad[oy][ox] = '○';
						for (int y = 0; y < 12; y++) {
							for (int x = 0; x < 12; x++)
								System.out.printf("%c", saveLoad[y][x]);

							System.out.println();
						} // 흰돌 놓고 전체 오목판 출력코드

						// 검은돌두기
						System.out.println("(ox oy)중 ox,oy를 순서대로 입력하세요");
						System.out.println("(-1 -1)입력시 종료됩니다.");

						ox = scan.nextInt();
						oy = scan.nextInt();

						// 종료입력 검사
						if (ox == -1 && oy == -1)
							break;
						// 범위검사
						else if (!((1 <= ox) && (ox <= 10))) {
							do {
								System.out.println("x축 범위를 벗어났습니다. 1~10중 다시입력하세요");
								ox = scan.nextInt();
								oy = scan.nextInt();

							} while (!(1 <= ox) && (ox <= 10));
						} else if (!((1 <= oy) && (oy <= 10))) {
							do {
								System.out.println("y축 범위를 벗어났습니다. 1~10중 다시입력하세요");
								ox = scan.nextInt();
								oy = scan.nextInt();
							} while (!(1 <= oy) && (oy <= 10));
						}
						// 중복검사
						else if (saveLoad[oy][ox] == '●' || saveLoad[oy][ox] == '○') {
							do {
								System.out.println("오목알이 있는곳엔 둘수없습니다. 다른곳에 두세요");
								ox = scan.nextInt();
								oy = scan.nextInt();
							} while (saveLoad[oy][ox] == '●' || saveLoad[oy][ox] == '○');
						}

						// 검사완료된 돌두기
						board[oy][ox] = '●';
						for (int y = 0; y < 12; y++) {
							for (int x = 0; x < 12; x++)
								System.out.printf("%c", saveLoad[y][x]);

							System.out.println();
						}

					}

				} // 돌두는 while문

				fscan.close();
				fis.close();

			case 9:
				break Gameover;

			}

		}

	}

}
