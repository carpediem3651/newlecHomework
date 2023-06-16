package day20230616;

public class OmokProgram {

	public static void main(String[] args) {
		for(int j=0; j<12; j++) {
			for(int i=0; i<12; i++)
				// 첫째 줄
				if(j==0&&i==0)
					System.out.print("┌");
				else if(j==0&&i==11)
					System.out.print("┐");
				else if(j==11&&i==0)
					System.out.print("└");
				else if(j==11&&i==11)
					System.out.print("┘");
				else if(j==0)
					System.out.print("┬");
				else if(j==11)
					System.out.print("┴");
				else if(i==0)
					System.out.print("├");
				else if(i==11)
					System.out.print("┤");
				else 
					System.out.print("┼");
			
			
		}
	}

}
