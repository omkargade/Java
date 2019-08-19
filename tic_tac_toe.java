import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class tic_tac_toe {
	
	public static int checkWin(List<Integer> cv) {
		if(cv.get(0)==1&&cv.get(1)==1&&cv.get(2)==1||cv.get(3)==1&&cv.get(4)==1&&cv.get(5)==1||cv.get(6)==1&&cv.get(7)==1&&cv.get(8)==1)
			return 1;
		if(cv.get(0)==1&&cv.get(3)==1&&cv.get(6)==1||cv.get(1)==1&&cv.get(4)==1&&cv.get(7)==1||cv.get(2)==1&&cv.get(5)==1&&cv.get(8)==1)
			return 1;
		if(cv.get(0)==1&&cv.get(4)==1&&cv.get(8)==1||cv.get(2)==1&&cv.get(4)==1&&cv.get(6)==1)
			return 1;
		
		if(cv.get(0)==2&&cv.get(1)==2&&cv.get(2)==2||cv.get(3)==2&&cv.get(4)==2&&cv.get(5)==2||cv.get(6)==2&&cv.get(7)==2&&cv.get(8)==2)
			return 2;
		if(cv.get(0)==2&&cv.get(3)==2&&cv.get(6)==2||cv.get(1)==2&&cv.get(4)==2&&cv.get(7)==2||cv.get(2)==2&&cv.get(5)==2&&cv.get(8)==2)
			return 2;
		if(cv.get(0)==2&&cv.get(4)==2&&cv.get(8)==2||cv.get(2)==2&&cv.get(4)==2&&cv.get(6)==2)
			return 2;
		
		return 0;
	}
	
	//clear screen function
	public static void clearScreen() {  
		//cannot find working method
	}
	
	//displays the board
	static void display(List<Integer> cv) {
		clearScreen();
		for(int j=0,i=0;i<9;j++,i++) {
			if(j>2) {
				System.out.println();
				j=0;
			}
			if(cv.get(i)==1)
				System.out.print("X");
			else if(cv.get(i)==2)
				System.out.print("O");
			else
				System.out.print("-");
		}
	}
	
	public static void main(String[] args){
		List<Integer> cv = new ArrayList<Integer>();
		for(int i=1;i<=9;i++)
			cv.add(0);
		
		Scanner sc = new Scanner(System.in);
		int player = 1;
		int winner = 0;
		while(true) {
			display(cv);
			winner = checkWin(cv);
			if(winner==1) {
				System.out.println("\nPlayer X won!");
				sc.close();
				System.exit(0);
			}
			else if(winner==2) {
				System.out.println("\nPlayer O won!");
				sc.close();
				System.exit(0);
			}
			if(player==1) {
				System.out.println("\nPlayer X");
				int place = sc.nextInt();
				if(place<1||place>9||cv.get(place-1)==1||cv.get(place-1)==2)
				{System.out.println("Enter valid place");
				continue;}
				cv.remove(place-1);
				cv.add(place-1, 1);
				player=2;
			}
			else {
				System.out.println("\nPlayer O");
				int place = sc.nextInt();
				if(place<1||place>9||cv.get(place-1)==1||cv.get(place-1)==2)
				{System.out.println("Enter valid place");
				continue;}
				cv.remove(place-1);
				cv.add(place-1, 2);
				player=1;
			}
		}
	}

}
