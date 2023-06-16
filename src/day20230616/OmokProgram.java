package day20230616;

public class OmokProgram {

	public static void main(String[] args) {
//		전략 모든 경우의수를 구해주고 특수한 경우를 가장 먼저 보편적인 경우를 가장 나중에 세워준다.
		for(int j=0;j<10;j++) { 
		    for(int i=0;i<10;i++) {
		    	if(j==0&&i==0)
		    		System.out.print("┌");
		    	else if(j==0&&i==9)
		    		System.out.print("┐");
		    	else if(j==9&&i==0)
		    		System.out.print("└");
		    	else if(j==9&&i==9)
		    		System.out.print("┘");
		    	else if(j==0)
		    		System.out.print("┬");
		    	else if(j==9)
		    		System.out.print("┴");
		    	else
		    		System.out.print("┼");
		   }
		    System.out.println();
		}		
	}
}
