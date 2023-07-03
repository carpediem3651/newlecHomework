package function;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class HomeWork_0628__Q1_lottosFunction {

	public static void main(String[] args) throws IOException {
		{
			// ☆☆☆☆☆☆☆☆☆☆☆☆☆☆ 메인메뉴 만들기 ☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆
			Scanner input = new Scanner(System.in);
			int[] lottos = new int[6];

			END: while (true) {
				
				System.out.print("┌──────────────────┐\n");
				System.out.print("│  Lotto 관리 프로그램 │\n");
				System.out.print("└──────────────────┘\n");
				System.out.println("1. 번호 자동 생성");
				System.out.println("2. 번호 수동 생성");
				System.out.println("3. 내 로또 번호 보기");
				System.out.println("4. 종료");
				System.out.print("선택 > ");
				System.out.println();
				System.out.println();
				int menu = input.nextInt();
				
				OVER:
				switch (menu) {
				/* // ☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆ CASE1.자동 lotto 번호 생성☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆ */
				case 1: {

					createAutoLottos(lottos);

					// 빠져나가는 두개의 경우의수를 만든다.
					System.out.println("1. 저장하고 메인메뉴로 가기");
					System.out.println("2. 취소하고 메인메뉴로 가기");
					System.out.println(">_");

					// 1. 저장하고 메인메뉴로가기
					int menu2 = input.nextInt(); // 번호를 입력한다.

					switch (menu2) {
						case 1: { // 저장하고 메인메뉴로 간다.
							FileOutputStream fos = new FileOutputStream("res/lotto/data.txt");
							PrintWriter fout = new PrintWriter(fos);
	
							for (int i = 0; i < lottos.length; i++) // 파일에 로또 점수 입력
								fout.printf("%d ", lottos[i]);
	
							fout.close();
							fos.close();
	
							break OVER; // ※※※※※※※※※※※※※※함수로 묶으면 이걸 어떻게 처리해야할까??
						}

						case 2: { // 취소하고 메인 메뉴로간다.
							break OVER; // ※※※※※※※※※※※※※※함수로 묶으면 이걸 어떻게 처리해야할까??
						}
					} // switch2 case1 close
				} // switch1 case 1 close
				
				// ☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆ CASE1.자동 로또번호 생성 코드 끝☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆
				
				
				// ☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆ CASE2.수동 로또번호 생성 코드☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆
				case 2: { // 번호 수동 생성 시작
					createManualLottos(lottos);

					// 1. 저장하고 메인메뉴로가기
					int menu2 = input.nextInt(); // 번호를 입력한다.
					
					switch (menu2) {
					case 1: { // 저장하고 메인메뉴로 간다.
						FileOutputStream fos = new FileOutputStream("res/lotto/data.txt");
						PrintWriter fout = new PrintWriter(fos);

						for (int i = 0; i < lottos.length; i++) // 파일에 로또 점수 입력
							fout.printf("%d ", lottos[i]); /// ※※※※※※※※※※※※ 글자가 겹쳐서 깨진다 수정
						
						fout.close();
						fos.close();

						break OVER; // ※※※※※※※※※※※※※※함수로 묶으면 이걸 어떻게 처리해야할까??
					}

					case 2: // 취소하고 메인 메뉴로간다.
						break OVER; // ※※※※※※※※※※※※※※함수로 묶으면 이걸 어떻게 처리해야할까??
					} // switch문2 close

					System.out.println();
					
				} 
//				☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆ CASE2.수동 로또 번호생성 코드 끝☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆
				
				// ☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆ CASE3.내 로또 번호보기☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆
				case 3 : {
					FileInputStream fis = new FileInputStream("res/lotto/data.txt");
					Scanner fiscan = new Scanner(fis);
					int[] fileData = new int[lottos.length];
					
//					★★★★★★★★★★★★★★★로또번호 출력★★★★★★★★★★★★★★★
					for(int i=0; i< lottos.length; i++) {						
						
						fileData[i] =  fiscan.nextInt();
						System.out.printf("%d ", fileData[i]);
					}
					
					System.out.println();
					
					fiscan.close();
					fis.close();
					
					break OVER; // ※※※※※※※※※※※※※※함수로 묶으면 이걸 어떻게 처리해야할까??
					
				}//☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆내 로또 번호보기 코드 끝☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆
				
				
				// ☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆ CASE4.종료☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆
				case 4 : {
					break END;
				} // ☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆종료 코드 끝☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆
				
				default : {
					System.out.println("해당하는 숫자가 없습니다. 다시 입력하쇼");
					break OVER;
				}
				
				} //switch문1 끝
			} // while문 끝
			System.out.println("게임을 종료하지");
			
		} //지역화 
	}

	private static void createManualLottos(int[] lottos) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("┌──────────────────┐\n");
		System.out.print("│ lotto번호 수동생성   │\n");
		System.out.print("└──────────────────┘\n");

		System.out.println();

		System.out.print("로또 당첨번호:");

		for (int i = 0; i < lottos.length; i++) {
			lottos[i] = input.nextInt();
			
			// ★★★★★★★★★★★★★★★★중복제거★★★★★★★★★★★★★★★
			for (int j = 0; j < i; j++) { // 로또번호 중복제거 앞번호(i)와 뒷번호(j)를 비교한다.
				if (lottos[i] == lottos[j]) {
					i--; // 로또 번호가 같으면 카운트를 하지 않는다. 무효처리.
					System.out.println("헤헤 중복됐지롱");
					break;
				}
			} 
		}
		
//		   ★★★★★★★★★★★★★★★오름차순 정렬★★★★★★★★★★★★★★★	       
		for (int j = 0; j < lottos.length-1; j++) { // 인덱스 5까지 돌아야 인덱스 6자리까지 정리가 되므로 -1 빼먹지말기. 배열 전체를 순회하는 역할.
		    for (int i = 0; i < (lottos.length - 1) - j; i++) // j를 활용해서 이미 숫자가 고정된 자리를 빼준다
		        if (lottos[i] > lottos[i + 1]) { // 뒷값이 더 크면 값교환
		            int tmp = lottos[i + 1];
		            lottos[i + 1] = lottos[i];
		            lottos[i] = tmp;
		        }
		}
		
		// ★로또번호 출력
		for(int i=0; i<lottos.length; i++)
			System.out.printf("%d ",lottos[i]); 
		System.out.println();
		System.out.println();
		
		// 빠져나가는 두개의 경우의수를 만든다.
		System.out.println("1. 저장하고 메인메뉴로 가기");
		System.out.println("2. 취소하고 메인메뉴로 가기");
		System.out.print(">");		
	}

	private static void createAutoLottos(int[] lottos) {
		System.out.print("┌──────────────────┐\n");
		System.out.print("│ lotto번호 자동생성   │\n");
		System.out.print("└──────────────────┘\n");

		System.out.println();

		Random rand = new Random();

		System.out.print("로또 당첨번호:");

		for (int i = 0; i < lottos.length; i++) {
		   lottos[i] = rand.nextInt(45) + 1; // 로또번호 뽑기
	       
//		   ★★★★★★★★★★★★★★★중복처리★★★★★★★★★★★★★★★
	       for (int j = 0; j < i; j++) { // 로또번호 중복제거 앞번호(i)와 뒷번호(j)를 비교한다.
	    	   if (lottos[i] == lottos[j]) {
					i--; // ★★★★★★★★★★★★★★★★★★★★★★★★ 중복값 처리 제대로 못함 로또 번호가 같으면 카운트를 하지 않는다. 무효처리.
					System.out.println("중복됐지롱 다시해");
					break;
	    	   }		
	       }
		} 
		
//		   ★★★★★★★★★★★★★★★오름차순 정렬★★★★★★★★★★★★★★★	       
		for (int j = 0; j < lottos.length-1; j++) { // 인덱스 5까지 돌아야 인덱스 6자리까지 정리가 되므로 -1 빼먹지말기. 배열 전체를 순회하는 역할.
		    for (int i = 0; i < (lottos.length - 1) - j; i++) // j를 활용해서 이미 숫자가 고정된 자리를 빼준다
		        if (lottos[i] > lottos[i + 1]) { // 뒷값이 더 크면 값교환
		            int tmp = lottos[i + 1];
		            lottos[i + 1] = lottos[i];
		            lottos[i] = tmp;
		        }
		}
		
//		★★★★★★★★★★★★★★★로또번호 출력★★★★★★★★★★★★★★★
		for(int i=0; i<lottos.length; i++)
			System.out.printf("%d ",lottos[i]); 
		 
		System.out.println();
		
	}
} //class
