import java.util.*;

/**
 * Civil engineers are simulating rainfall on a digital elevation model to study water flow.
 * You are given a 2D array of integers heights representing terrain heights and two integers startRow and startCol indicating the water's starting point.
 * Simulate the water flow from the starting point with these rules:
 * 1. Water flows to adjacent cells (up, down, left, right) if the adjacent cell's height is less than or equal to the current cell's height.
 * 2. The flow stops when no adjacent cell has a lower or equal height.
 * Return a 2D array of integers where each cell contains the time step when it becomes wet, starting at 0 for the initial cell.
 * If a cell remains dry, its value should be -1. The dimensions of the output array should match those of the input heights
 * Note: You are not expected to provide the most optimal solution, but a solution with time complexity not worse than (heights. length? heights[01. length?) will fit within the execution time limit.
 * heights = [
 * [3, 2, 1],
 * [6, 5, 4]
 * [9, 8, 7]
 * ]
 * startRow = 1, startCol = 1,
 * solution (heights, startRow, startCol) = [
 * [-1, 1, 2],
 * [-1, 0, 1],
 * [-1, -1, -1]
 * ]
 **/

public class _RiverChallenge {

    public static void main(String[] args) {
        int[][] heights1 = {
                {3, 2, 1},
                {6, 5, 4},
                {9, 8, 7}
        };
        // int startRow = 1, startCol = 1;
        int[][] result = Solution.solve(heights1, 1, 1);
        System.out.println("Solution.solve(heights1, 1, 1) = " + Solution.print(Solution.solve(heights1, 1, 1)));
        int[][] heights2 = {
                {3, 2, 1, 3},
                {6, 5, 4, 2},
                {9, 8, 7, 1},
                {9, 8, 7, 1}
        };
        System.out.println("Solution.solve(heights2, 1, 0) = " + Solution.print(Solution.solve(heights2, 1, 0)));
    }

    public static class Solution {

        public static int[][] solve(int[][] heights, int startRow, int startCol) {
            int[][] result = new int[heights.length][heights[0].length];

            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] = -1;
                }
            }
            result[startRow][startCol] = 0;
            Queue<int[]> q = new LinkedList<>(List.of(new int[]{startRow, startCol}));
            int[] currentCoord;
            int currentRow;
            int currentCol;
            int source;
            while (!q.isEmpty()) {
                currentCoord = q.poll();
                currentRow = currentCoord[0];
                currentCol = currentCoord[1];
                source = result[currentRow][currentCol];

                if (currentRow - 1 >= 0 && result[currentRow - 1][currentCol] == -1
                        && heights[currentRow - 1][currentCol] < heights[currentRow][currentCol]) {
                    result[currentRow - 1][currentCol] = source + 1;
                    q.add(new int[]{currentRow - 1, currentCol});
                }

                if (currentRow + 1 < heights.length && result[currentRow + 1][currentCol] == -1
                        && heights[currentRow + 1][currentCol] < heights[currentRow][currentCol]) {
                    result[currentRow + 1][currentCol] = source + 1;
                    q.add(new int[]{currentRow + 1, currentCol});
                }

                if (currentCol - 1 >= 0 && result[currentRow][currentCol - 1] == -1
                        && heights[currentRow][currentCol - 1] < heights[currentRow][currentCol]) {
                    result[currentRow][currentCol - 1] = source + 1;
                    q.add(new int[]{currentRow, currentCol - 1});
                }

                if (currentCol + 1 < heights[currentRow].length && result[currentRow][currentCol + 1] == -1
                        && heights[currentRow][currentCol + 1] < heights[currentRow][currentCol]) {
                    result[currentRow][currentCol + 1] = source + 1;
                    q.add(new int[]{currentRow, currentCol + 1});
                }
            }
            return result;
        }

        public static String print(int[][] heights) {
            StringBuilder sb = new StringBuilder();
            sb.append("\n[\n");
            for (int i = 0; i < heights.length; i++) {
                sb.append("\t[");
                for (int j = 0; j < heights[i].length; j++) {
                    if (j == heights[i].length - 1) {
                        sb.append("%2d".formatted(heights[i][j]));
                    } else {
                        sb.append("%2d".formatted(heights[i][j])).append(", ");
                    }
                }
                sb.append("],\n");
            }
            sb.append("]");
            return sb.toString();
        }
    }
}

