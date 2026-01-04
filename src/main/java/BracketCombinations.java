public class BracketCombinations {

    /**
     * Have the function BracketCombinations(num) read num which will be an integer greater than or equal to zero,
     * and return the number of valid combinations that can be formed with num pairs of parentheses. For example,
     * if the input is 3, then the possible combinations of 3 pairs of parenthesis, namely: ()()(), are ()()(), ()(()), (())(), ((())), and (()()).
     * There are 5 total combinations when the input is 3, so your program should return 5.
     * Examples
     * Input: 3
     * Output: 5
     * Input: 2
     * Output: 2
     */

    public static void main(String[] args) {
        System.out.println("Solution.solve(2) = " + Solution.solve(2));
        System.out.println("Solution.solve(3) = " + Solution.solve(3));
        System.out.println("Solution.solve(4) = " + Solution.solve(4));
        System.out.println("Solution.solve(5) = " + Solution.solve(5));
        System.out.println("Solution.solve(6) = " + Solution.solve(6));
        System.out.println("Solution.solve(7) = " + Solution.solve(7));
        System.out.println("Solution.solve(8) = " + Solution.solve(8));
    }

    public static class Solution {

        public static int solve(int num) {
            if (num == 1 || num == 0) {
                return 1;
            }
            int result = 1;

            for (int i = 1; i <= num; i++) {
                result = result * (4 * i + 2) / (i + 2);
            }
            return result;
        }
    }
}
