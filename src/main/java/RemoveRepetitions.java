import java.util.*;
import java.util.stream.Collectors;

public class RemoveRepetitions {

    public static void main(String[] args) {
        Comparator<Integer> numberComparator = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        };
        int[] arr = {7,7,2,4,3,4,5,6,6,1};
        System.out.println("Solution.solve(arr) = " + Arrays.toString(Solution.solve(arr)));
    }

    static class Solution{
        static int[] solve(int[] arr) {
            List<Integer> collect = Arrays.stream(arr).boxed().collect(Collectors.toList());
            List<Integer> numbers = new ArrayList<>();
          for (Integer i : arr) {
              if (numbers.contains(i)) {
                  numbers.remove(i);
              } else{
                  numbers.add(i);
              }
          }
          return numbers.stream().mapToInt(i -> i).toArray();
        }
    }
}
