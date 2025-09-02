public class Main {
    public static void main(String[] args) {
        char[][] grid = {
            { 'X', 'O', 'X' },
            { 'O', 'X', 'O' },
            { 'X', 'X', 'O' }
        };

        for (int i = 0; i<3; i++) {
            for(int j = 0; j<3; j++) {
                System.out.print(grid[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
