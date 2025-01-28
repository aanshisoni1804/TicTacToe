import java.util.Scanner;

class TicTacToe1 {
    public static void main(String[] args) {
		
        System.out.println();
		System.out.println("----------------------------");
        System.out.println("WELCOME TO TIC-TAC-TOE GAME!");
		System.out.println("----------------------------");
        System.out.println();
		System.out.println("INSTRUCTION FOR THE GAME :");
		System.out.println();
		System.out.println("Cell 1 represents first row and first column");
		System.out.println("Cell 2 represents first row and second column");
		System.out.println("Cell 3 represents first row and third column");
		System.out.println("Cell 4 represents second row and first column");
		System.out.println("Cell 5 represents second row and second column");
		System.out.println("Cell 6 represents second row and third column");
		System.out.println("Cell 7 represents third row and first column");
		System.out.println("Cell 8 represents third row and second column");
		System.out.println("Cell 9 represents third row and third column");
		System.out.println();
		System.out.println();
		// creating a 3*3 character array which will be used as the game board
        char[][] board = new char[3][3];

		// Filling character array with empty spaces
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }
		
		// defining variables
        char currentPlayer = 'X'; // Starts with player 'X'
        boolean gameOver = false; // Initially, the game is not over 
        int moves = 0; // Tracking the number of moves
		
		// Creates Scanner object sc for taking input
        Scanner sc = new Scanner(System.in); 

        while (gameOver==false) // game is not over
		{
            // Printing the board initially so that the player knows where to place their turn
            printBoard(board);
            System.out.print("Player " + currentPlayer + " enter cell number: ");
            
			/*
			//splits the input string using a comma delimiter.
            String[] positions = input.split("[,\\s]+"); // Split using comma or space as delimiter
            
			// converting string to Integer and adjusting the positions
			int row = Integer.parseInt(positions[0]) - 1;
            int col = Integer.parseInt(positions[1]) - 1;
			
            System.out.println();
			*/

			// takes input from user
			int input = sc.nextInt();
            int row = (input - 1) / 3;  // since number of rows are 3
            int col = (input - 1) % 3; // since number of columns are 3
            System.out.println();		
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                moves++;
				
				// Checking for win or draw condition
				// gameOver is set to true if either of the 2 conditions is true
                gameOver = haveWon(board, currentPlayer) || (moves == 9);
                if (gameOver) { // game is over
                    if (haveWon(board, currentPlayer)) { // when player wins
                        System.out.println("Player " + currentPlayer + " has won.");
                    } 
					else {
						// when moves==9
                        System.out.println("It's a draw!");
                    }
                } 
				else {
                    // Switching players
					if (currentPlayer=='X'){
						currentPlayer='O';
					}
					else{
						currentPlayer='X';
					}
                }
            } 
			else {
                System.out.println("Invalid move. Try again!");
            }
        }
        printBoard(board);
    }

    public static boolean haveWon(char[][] board, char player) {
		// char [][] board represents the game board 
		// char player represents which player (X or O)
		// returns true if the player has won, else false
		
        // checking winning conditions for rows
		
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }
		
		// checking winning conditions for columns
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }
		
		// checking winning conditions for diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }
	
	// Printing the board
    public static void printBoard(char[][] board) {
        System.out.println("-------------");
        for (int row = 0; row < board.length; row++) {
            System.out.print("| ");
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println("\n-------------");
        }
    }
}
