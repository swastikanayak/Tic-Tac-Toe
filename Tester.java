import java.util.Scanner;
//ID: 201501423
//Name: Swastika Nayak
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to Tic Tac Toe");
		System.out.println("Enter the mode you wish to play");
		System.out.println("Click 1 for human vs human mode");
		System.out.println("Click 2 for human vs computer mode");
		System.out.println("Click 3 for computer vs human mode");
		System.out.println("Whenever you write your input make sure of the convention:1 1 implies 1st row,1st column");
		int mode = input.nextInt();
        GameBoard.play(mode);
	}
}
