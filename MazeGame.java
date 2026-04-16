import java.util.*;

public class MazeGame {
    static char[][] maze = {
        {'P', '.', '.', '#', '.'},
        {'.', '#', '.', '#', '.'},
        {'.', '#', '.', '.', '.'},
        {'.', '.', '#', '#', '.'},
        {'#', '.', '.', 'E', '.'}
    };

    static int playerRow = 0;
    static int playerCol = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("🎮 Maze Escape Game");
        System.out.println("Use W (up), S (down), A (left), D (right)");

        while (true) {
            printMaze();

            System.out.print("Move: ");
            char move = sc.next().toLowerCase().charAt(0);

            int newRow = playerRow;
            int newCol = playerCol;

            if (move == 'w') newRow--;
            else if (move == 's') newRow++;
            else if (move == 'a') newCol--;
            else if (move == 'd') newCol++;

            if (isValidMove(newRow, newCol)) {
                maze[playerRow][playerCol] = '.';
                playerRow = newRow;
                playerCol = newCol;

                if (maze[playerRow][playerCol] == 'E') {
                    System.out.println("🎉 You escaped the maze!");
                    break;
                }

                maze[playerRow][playerCol] = 'P';
            } else {
                System.out.println("❌ Invalid move!");
            }
        }
    }

    static boolean isValidMove(int r, int c) {
        return r >= 0 && r < maze.length &&
               c >= 0 && c < maze[0].length &&
               maze[r][c] != '#';
    }

    static void printMaze() {
        for (char[] row : maze) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}