import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class lc_336 {
    static boolean isValidSudoku(char[][] board) {

        int n = 9;

        for (char[] row : board) {
            Set<Character> set = new HashSet<>();
            for (char current : row) {
                if (current != '.' && !set.add(current))
                    return false;
            }
        }

        for (int i = 0; i < n; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.' && !set.add(board[j][i]))
                    return false;
            }
        }

        for (int row = 0; row < n; row += 3) {
            Set<Character> set = new HashSet<>();
            for (int col = 0; col < n; col += 3) {
                for (int i = row; i < row + 3; i++) {
                    for (int j = col; j < col + 3; j++) {
                        if (board[i][j] != '.' && !set.add(board[i][j]))
                            return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = input.next().charAt(0);
            }
        }

        System.out.println(isValidSudoku(board));
        input.close();
    }
}
