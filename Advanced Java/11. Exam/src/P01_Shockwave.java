import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01_Shockwave {

    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String[] size = console.readLine().split("\\s+");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);

        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = 0;
            }
        }
        
        while (true) {
            String input = console.readLine();
            if ("Here We Go".equals(input)) {
                break;
            }

            String[] split = input.split("\\s+");
            int startRow = Integer.parseInt(split[0]);
            int startCol = Integer.parseInt(split[1]);
            int endRow = Integer.parseInt(split[2]);
            int endCol = Integer.parseInt(split[3]);

            for (int i = startRow; i <= endRow; i++) {
                for (int j = startCol; j <= endCol; j++) {
                    matrix[i][j]++;
                }
            }
        }

        for (int[] row : matrix) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
