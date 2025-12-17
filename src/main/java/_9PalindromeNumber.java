/**
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 */

public class _9PalindromeNumber {

    public static void main(String[] args) {

        System.out.println("Solution.isPalindrome(1221) = " + Solution.isPalindrome(1221));
        System.out.println("Solution.isPalindrome(34543) = " + Solution.isPalindrome(34543));
        System.out.println("Solution.isPalindrome(1) = " + Solution.isPalindrome(1));
        System.out.println("Solution.isPalindrome(22) = " + Solution.isPalindrome(22));
        System.out.println("Solution.isPalindrome(11) = " + Solution.isPalindrome(11));
        System.out.println("Solution.isPalindrome(-11) = " + Solution.isPalindrome(-11));
        System.out.println("Solution.isPalindrome(10) = " + Solution.isPalindrome(10));

    }

    static class Solution {
        static public boolean isPalindrome(int x) {
            String value = String.valueOf(x);
            int i = 0, j = value.length() - 1;
            while (i < j) {
                if (value.charAt(i++) != value.charAt(j--)) {
                    return false;
                }
            }
            return true;
        }
    }
}