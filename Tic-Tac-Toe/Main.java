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
}

