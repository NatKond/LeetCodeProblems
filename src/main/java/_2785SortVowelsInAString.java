import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class _2785SortVowelsInAString {

    public static void main(String[] args) {
        System.out.println(Solution.sortVowels("lEetcOde"));
    }
    static class Solution {
        public static String sortVowels(String s) {
            Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O','U');
            List<Character> vowelsList = new ArrayList<>();
            List<Integer> vowelsListIndex = new ArrayList<>();
            char[] chars = s.toCharArray();
            for(int i = 0; i < chars.length; i++){
                if (vowels.contains(chars[i])){
                    vowelsList.add(chars[i]);
                    vowelsListIndex.add(i);
                }
            }
            Collections.sort(vowelsList);
            for(int i = 0; i < vowelsListIndex.size(); i++){
                chars[vowelsListIndex.get(i)] = vowelsList.get(i);
            }
            return new String(chars);
        }
    }
}

