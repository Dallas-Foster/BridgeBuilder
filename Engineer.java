package BridgeBuilderAdv;

import java.util.Random; // Importing a randomizer for the easy mode of the engineer



public class Engineer { // We have to initialize the private variables of the engineer class
    private char token;
    private boolean hardMode;

    
    
    public Engineer(boolean hardMode) {
        this.token = '0';
        this.hardMode = hardMode;
    }

    public void makeMove(GameBoard board, int playerLastRow, int playerLastCol) { // This is the engineer move method. It relies on whether easy mode or hard mode is selected
        if (hardMode) {
            makeMoveHardMode(board, playerLastRow, playerLastCol); // call the hard mode method
        } else {
            makeMoveEasyMode(board); // Call the easy mode method
        }
    }

    
    
    private void makeMoveHardMode(GameBoard board, int playerLastRow, int playerLastCol) { // This is the hard move method. Unlike easy mode, it is more calculated based on the players moves
        int size = board.getsize();
        int row = playerLastRow;
        int col = playerLastCol + 1;

        while (row < size) { // As required in hard mode, this will make the move go to the next empty position on the board
            if (col >= size) {
                col = 0;
                row++;
            }
            if (board.isPositionEmpty(row, col)) {
                board.placeToken(row, col, token); // This places the token in the empty position
                return;
            }
            col++;
        }

        // If no empty position is found after the player's last position, select the topmost empty position in the same column
        for (col = 0; col < size; col++) {
            for (row = 0; row < size; row++) {
                if (board.isPositionEmpty(row, col)) { // Checks to see if the coordinate is empty
                    board.placeToken(row, col, token); // Place the token in the topmost empty position in the column
                    return;
                }
            }
        }
    }

    
    
    private void makeMoveEasyMode(GameBoard board) { // This method allows the engineer to make a move in easy mode
        Random random = new Random();
        int size = board.getsize();
        int row, col;

        do { // This generates random coordinates on the game board until an empty one is found
            row = random.nextInt(size); // Random row in range given
            col = random.nextInt(size); // Random column in range given
        } while (!board.isPositionEmpty(row, col));

        board.placeToken(row, col, token); // This places the engineers token randomly on an emptey space on the board
    }

    
    
    public char getToken() {
        return token; // Return the engineers token 
    }
}
