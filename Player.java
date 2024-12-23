package BridgeBuilderAdv;

public class Player { // This is the class for the player/user
	private char token; // Initialize the private char token (it is given as a + symbol)
    private int score; // Initialize the private int score (will start at 0 and increment based on the rounds and scoring methods)

    public Player() {
        this.token = '+';
        this.score = 0;
    }
    
    
    public void makeMove(GameBoard board, int row, int col) { // Method for making a move on the game board at the specified row and column
        if (board.isPositionEmpty(row, col)) { // This checks if the chosen coordinate on the gameboard is empty 
            board.placeToken(row, col, token); // If the coordinate on the gameboard is empty, this will place the users token on it
            board.displayBoard(); // This will display the updated board with the tokens
        }
   // If an invalid position is given, it will trigger an error handler in the main method
    }
    
    
    public char getToken() { // Getter method for the users token
        return token;
    }

    
    
    public int getScore() { // Getter method for the users score
        return score;
    }

    
    
    public void addScore(int increment) { // This method will increment the players score by a specified value, which is associated with the different ways of winning the game
        score += increment;
    }
}
