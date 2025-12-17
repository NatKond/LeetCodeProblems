import java.util.Scanner;

public class _LongestWord {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print(Solution.solve("fun&!! time"));
    }

    public static class Solution{
        public static String solve(String sen) {
            String[] words = sen.replaceAll("\\p{Punct}", "").trim().split(" ");
            String max = "";
            for (String word: words){
                if(word.length() > max.length()){
                    max = word;
                }
            }
            return max;
        }
    }

}
