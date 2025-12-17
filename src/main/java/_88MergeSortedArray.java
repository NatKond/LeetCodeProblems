import java.util.Arrays;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
 * and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
 * and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 */

public class _88MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 4, 5, 6, 0};
        int[] nums2 = {3};
        Solution.merge(nums1, 5, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }

    public static class Solution {

        public static void merge(int[] nums1, int m, int[] nums2, int n) {
                for (int k = m + n - 1, j = n - 1, i = m - 1; j >= 0; k--){
                    if (i >= 0 && nums1[i] > nums2[j]){
                        nums1[k] = nums1[i--];
                    }else {
                        nums1[k] = nums2[j--];
                    }
                }

//            Queue<Integer> temp = new LinkedList<>();
//            for (int i = 0, k = 0; i < m + n; i++) {
//                int num;
//                if (temp.isEmpty()) {
//                    if (k == n) {
//                        break;
//                    }
//                    if (i >= m) {
//                        nums1[i] = nums2[k++];
//                        continue;
//                    }
//                    if (nums1[i] <= nums2[k]) {
//                        continue;
//                    }
//                    num = nums2[k++];
//                } else {
//                    if (k < n) {
//                        num = temp.peek() > nums2[k] ? nums2[k++] : temp.poll();
//                    } else {
//                        num = temp.poll();
//                    }
//                }
//                if (i < m) {
//                    temp.add(nums1[i]);
//                }
//                nums1[i] = num;
//            }
        }
    }
}