import java.util.Map;

public class _13RomanToInteger {

    public static void main(String[] args) {
        System.out.println("Solution.romanToInt(\"III\") = " + Solution.romanToInt("III"));
        System.out.println("Solution.romanToInt(\"LVIII\") = " + Solution.romanToInt("LVIII"));
        System.out.println("Solution.romanToInt(\"MCMXCIV\") = " + Solution.romanToInt("MCMXCIV"));
    }

    static class Solution {
        public static int romanToInt(String s) {
            Map<Character,Integer> romanNumbers = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);
            char[] sCharArray = s.toCharArray();
            int number = 0;
            for (int i = 0; i < sCharArray.length; i++){
                if (i == sCharArray.length - 1){
                    number += romanNumbers.get(sCharArray[sCharArray.length - 1]);
                    continue;
                }
                int firstNumber = romanNumbers.get(sCharArray[i]);
                int secondNumber = romanNumbers.get(sCharArray[i+1]);
                if (firstNumber < secondNumber){
                    number += (secondNumber - firstNumber);
                    i++;
                }else {
                    number += firstNumber;
                }
            }
            return number;
        }
    }
}
