import java.util.Scanner;

public class tictactoe {
	public static int row, col;
	public static Scanner scan = new Scanner(System.in);
	public static char[][] board = new char[3][3];
	
	public static char turn = 'x';
	
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board [i][j] = '_';
			}
		}
		Play();
	}
	
	public static void Play() {
		boolean playing = true;
		PrintBoard();
		while (playing) {
			System.out.println("Please enter your row:");
			row = scan.nextInt() - 1;
			System.out.println("Please enter your column:");
			col = scan.nextInt() -1 ;
			board[row][col] = turn;
			if (GameOver(row, col)) {
				playing = false;
				System.out.println("Game over! Player " + turn + " wins!");
			}
			
			PrintBoard();
			if (turn == 'x') {
				turn = 'o';
			}else {
				turn = 'x';
			}
		}
	}
	
	public static void PrintBoard() {
		for (int i = 0; i < 3; i++) {
			System.out.println();
			for (int j = 0; j < 3; j++) {
				if (j == 0) {
					System.out.print("| ");
				}
				System.out.print(board[i][j] + " | ");
			}
		}
		System.out.println();
	}
	
	public static boolean GameOver(int rMove, int cMove) {
		if (board[0][cMove] == board[2][cMove] && board[rMove][0] == board[rMove][0]) {
			return true;
		}
		else if (board[rMove][0] == board[rMove][1] && board[rMove][0] == board[rMove][2]) {
			return true;
		}
		else if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[1][1] != '_') {
			return true;
		}
		else if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[1][1] != '_') {
			return true;
		}
		else {
			return false;
		}
	}
}
