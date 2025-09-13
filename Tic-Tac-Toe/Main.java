import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        char[] inputArray = input.toCharArray(); // Converting the input into a character array to loop over
        char[][] grid = new char[3][3]; // Creating the grid for the game
        int position = 0; // Position in the input array

        // Looping over the character array to see which character needs to be placed into the grid 
        for(int i=0; i<3;i++) {
            for (int j=0; j<3;j++) {
                grid[i][j] = inputArray[position];
                position++;
            }
        }

        printGrid(grid); // Calling the print method to print the grid
        if (impossibleGameState(grid)) {System.out.println("Impossible");}
        else if(xWins(grid)) {System.out.println("X wins");}
        else if (oWins(grid)) {System.out.println("O wins");}
        else if(gameNotFinished(grid)) {System.out.println("Game not finished");}
        else {System.out.println("Draw");} // Will print if all the above states return false
        
    }

    public static void printGrid(char[][] grid ) {
        System.out.println("---------");
        // Looping over the grid to print
        for(int i=0; i<3;i++) {
            System.out.print("| ");
            for (int j=0; j<3;j++) {
               System.out.print(grid[i][j]+" ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static boolean gameNotFinished(char[][] grid) { // When neither side has three in a row but the grid still has empty cells
        for( int i=0; i<3; i++) {
            for( int j=0; j<3; j++ ) {
                if(grid[i][j]==('_')|| grid[i][j]==(' ')) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean xWins(char[][] grid) { // When the grid has three X’s in a row (including diagonals)
        if(grid[0][0] == 'X' && grid[0][1] == 'X' && grid[0][2] == 'X') { // Top row all have X's
            return true;
        }
        else if (grid[1][0] == 'X' && grid[1][1] == 'X' && grid[1][2] == 'X') { // Middle row all have X's
            return true;
        }
        else if (grid[2][0] == 'X' && grid[2][1] == 'X' && grid[2][2] == 'X') { // Bottom row all have X's
            return true;
        }
        else if (grid[0][0] == 'X' && grid[1][0] == 'X' && grid[2][0] == 'X') { // First column all have X's
            return true;
        }
        else if (grid[0][1] == 'X' && grid[1][1] == 'X' && grid[2][1] == 'X') { // Second column all have X's
            return true;
        }
        else if (grid[0][2] == 'X' && grid[1][2] == 'X' && grid[2][2] == 'X') { // Third column all have X's
            return true;
        }
        else if(grid[0][0] == 'X' && grid[1][1] == 'X' && grid[2][2] == 'X') { // Diagonal from the left have all X's
            return true;
        }
        else if(grid[0][2] == 'X' && grid[1][1] == 'X' && grid[2][0] == 'X') { // Diagonal from the right all have X's
            return true;
        }
        else { return false; }
    }

    public static boolean oWins(char[][] grid) { // When the grid has three X’s in a row (including diagonals)
        if(grid[0][0] == 'O' && grid[0][1] == 'O' && grid[0][2] == 'O') { // Top row all have O's
            return true;
        }
        else if (grid[1][0] == 'O' && grid[1][1] == 'O' && grid[1][2] == 'O') { // Middle row all have O's
            return true;
        }
        else if (grid[2][0] == 'O' && grid[2][1] == 'O' && grid[2][2] == 'O') { // Bottom row all have O's
            return true;
        }
        else if (grid[0][0] == 'O' && grid[1][0] == 'O' && grid[2][0] == 'O') { // First column all have X's
            return true;
        }
        else if (grid[0][1] == 'O' && grid[1][1] == 'O' && grid[2][1] == 'O') { // Second column all have X's
            return true;
        }
        else if (grid[0][2] == 'O' && grid[1][2] == 'O' && grid[2][2] == 'O') { // Third column all have X's
            return true;
        }
        else if(grid[0][0] == 'O' && grid[1][1] == 'O' && grid[2][2] == 'O') { // Diagonal from the left have all O's
            return true;
        }
        else return grid[0][2] == 'O' && grid[1][1] == 'O' && grid[2][0] == 'O'; // Diagonal from the right all have O's
        
    }

    public static boolean impossibleGameState(char[][] grid) { // When the grid has three X’s in a row as well as three O’s in a row, or there are a lot more X's than O's or vice versa
        int xCount =0;
        int oCount=0;
        for(int i = 0; i<3;i++) {
            for(int j = 0; j<3;j++) {
                switch (grid[i][j]) {
                    case 'X':
                        xCount++;
                        break;
                    case 'O':
                        oCount ++;
                        break;
                    default:
                        continue;
                }
            }
        }
        return (xWins(grid) == true && oWins(grid) == true)|| ((xCount - oCount) > 1 || (oCount - xCount) > 1);
    }

}

