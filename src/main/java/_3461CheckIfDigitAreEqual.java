
public class _3461CheckIfDigitAreEqual {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Solution.hasSameDigits(\"14356\") = " + Solution.hasSameDigits("14356"));
        System.out.println("Solution.hasSameDigits(\"121\") = " + Solution.hasSameDigits("121"));
    }

    static class Solution {

        public static boolean hasSameDigits(String s) {
            StringBuilder output = new StringBuilder();
            int temp;

            while (s.length() > 2 ){
                for (int i = 0; i < s.length() - 1; i++){
                    temp = s.charAt(i) - '0' + s.charAt(i + 1) - '0';
                    System.out.println(Character.getNumericValue(s.charAt(i)) + " + " + Character.getNumericValue(s.charAt(i + 1)) + " = " + temp);
                    output.append(temp % 10);
                    System.out.println("output = " + output);
                }
                s = output.toString();
                output.setLength(0);
                System.out.println("-".repeat(5));
            }

            return s.charAt(0) == s.charAt(1);
        }
    }
}
