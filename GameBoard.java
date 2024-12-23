package BridgeBuilderAdv;

public class GameBoard { // Set the public class as GameBoard and initialize the private variables
	private char[][] board;
	private int size; 
	
	private void initializeCleanBoard() { // Private helper method that initializes the clean board. It sets all empty positions to '.' 
        for (int row = 0; row < size; row++) { // It uses nested for loops to iterate over each position in the board. The outer loop iterates over the rows, and the inner loop iterates over the columns.
            for (int col = 0; col < size; col++) {
                board[row][col] = '.'; // Inside the loops, the function assigns the character '.' to the position on the board specified by the current row and column.
            }
        }
    }
	
	public GameBoard(int size) {
        this.size = size;
        this.board = new char[size][size]; // Initialize the board with the size that the user inputs
        initializeCleanBoard(); // Calls the helper method to initialize the clean board
    }
	
	

	public void placeToken(int row, int col, char token) { // Method that places the specified token at the specified row and column if the position is within the board boundaries
	    if (row >= 0 && row < size && col >= 0 && col < size) { // Makes sure the row is greater than equal to at least 0, while being smaller than the size, and ensure the columns are greater than zero while also being less than the size
	        board[row][col] = token;
	    }
	}
	
	
	
	public boolean isPositionEmpty(int row, int col) { // Method that checks is a inputed coordinate is empty
        if (row >= 0 && row < size && col >= 0 && col < size) { // First checks to see if the coordinate is valid
            return board[row][col] == '.'; // If so, it returns the empty position token
        }
        return false; // If the position is not empty it returns false		
	}
	
	
	
	public int getsize() { // Getter method that gets the chosen size of the gameboard
		return size; // Returns the size to the main class
	}
	
	
	
	public void displayBoard() { // Method that will continuously update and display the gameboard as moves are made
		System.out.print(" "); // Printing a space to create some visual padding.
        for (int col = 0; col < size; col++) { // Enters a loop that iterates over the columns of the board.
            System.out.print(" " + (char) ('A' + col)); // Within the loop, it prints the column labels. Each label corresponds to a column in the board and is displayed as a letter from 'A' onwards, incremented by the column index.
        }
        System.out.println();

        for (int row = 0; row < size; row++) { // Next, it enters another loop that iterates over the rows of the board. Within this loop, it first prints the row index, which represents the current row number.
            System.out.print(row);
            for (int col = 0; col < size; col++) { // It then enters a nested loop that iterates over the columns of the board.
                System.out.print(" " + board[row][col]); // Within the loop it prints out the row and column labels as a combination to make the board
            }
            System.out.println();
        }
    }

	
	
	public int checkForWinDirection(Player player) { // This method checks how the user wins the game, and indicates points methods how much to award the user based on the type of win
        // Check for left-to-right win
        for (int row = 0; row < size; row++) {
            boolean win = true;
            for (int col = 0; col < size; col++) {
                if (board[row][col] != player.getToken()) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return 1;
            }
        }

        // Check for bottom-to-top win
        for (int col = 0; col < size; col++) {
            boolean win = true;
            for (int row = 0; row < size; row++) {
                if (board[row][col] != player.getToken()) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return 2;
            }
        }

        // Check for diagonal win (top left to bottom right)
        boolean diagonalWin = true;
        for (int i = 0; i < size; i++) {
            if (board[i][i] != player.getToken()) {
                diagonalWin = false;
                break;
            }
        }
        if (diagonalWin) {
            return 3;
        }

        return 0;
    }
	
	
	
	public boolean checkForTie() { // Method that checks if there is a tie on the game board
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (board[row][col] == '.') {
                    return false; // Board is not full, game is not tied
                }
            }
        }
        return true; // Board is full, game is tied
    }
}

/**
 * Approach to designing the code: 
 * Upon getting this assignment, the first thing I did was watch the given video of the game in action so that I could get a sense of what the finished product should look like.
 * I started working on the GameBoard class as it was the one with the largest list of methods to create, followed by the player and engineer classes
 * 
 * Challenges faced: 
 * One significant challenge I faced was trying to use sets as a way of more efficiently checking for things such as empty or filled positions.
 * I wanted to use sets because I thought it would be a more streamlined and efficient rather than making the program check manually using nested loops instead of just being able to pop them from a list.
 * It proved a little too difficult for me and I opted to just continue with the bruteforce method which uses the nested loops
 * 
 * Error Checking: 
 * In terms of error checking, I watched the video given on the assignment tab and did the same outputs. The I compared results until I was satisfied that they were alike
 */

