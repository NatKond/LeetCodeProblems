import java.util.*;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 * Example 1: Input: nums = [-1,0,1,2,-1,-4] Output: [[-1,-1,2],[-1,0,1]]
 * Explanation: nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0. nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0. The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 */

public class _TripletsProblem {

    public static void main(String[] args) {
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Solution.solve(nums1) = " + Arrays.deepToString(Solution.solve(nums1)));
        System.out.println("Solution.solveImproved(nums1) = " + Arrays.deepToString(Solution.solveImproved(nums1)));
        int[] nums2 = {1, 2, 3, 4, 5};
        System.out.println("Solution.solve(nums2) = " + Arrays.deepToString(Solution.solve(nums2)));
        System.out.println("Solution.solveImproved(nums2) = " + Arrays.deepToString(Solution.solveImproved(nums2)));
        int[] nums3 = {0, 0, 0, 0, 0};
        System.out.println("Solution.solve(nums3) = " + Arrays.deepToString(Solution.solve(nums3)));
        System.out.println("Solution.solveImproved(nums3) = " + Arrays.deepToString(Solution.solveImproved(nums3)));
        int[] nums4 = {3, -2, 1, 0, -1, 2, -3};
        System.out.println("Solution.solve(nums4) = " + Arrays.deepToString(Solution.solve(nums4)));
        System.out.println("Solution.solveImproved(nums4) = " + Arrays.deepToString(Solution.solveImproved(nums4)));
        int[] nums5 = {3, -2};
        System.out.println("Solution.solve(nums5) = " + Arrays.deepToString(Solution.solve(nums5)));
        System.out.println("Solution.solveImproved(nums5) = " + Arrays.deepToString(Solution.solveImproved(nums5)));
        int[] nums6 = {-1, -2, -3, -1, -1, -1, 0, 1, 2, 2, 2, 3, 1, 1};
        System.out.println("Solution.solve(nums6) = " + Arrays.deepToString(Solution.solve(nums6)));
        System.out.println("Solution.solveImproved(nums6) = " + Arrays.deepToString(Solution.solveImproved(nums6)));

    }

    public static class Solution {

        // complexity O(n) = n^2*lon(n)
        public static int[][] solve(int[] nums) {
            if (nums.length < 3) {
                return new int[0][];
            }
            Arrays.sort(nums);
            if (nums[0] > 0 || nums[nums.length - 1] < 0) {
                return new int[0][];
            } else if (nums[0] == 0 && nums[nums.length - 1] == 0) {
                return new int[][]{{0, 0, 0}};
            }

            Map<String, List<Integer>> resultMap = new HashMap<>();
            int j, k, max, middle, min;

            for (int i = 0; i < nums.length - 2 && nums[i] < 0; i++) {
                j = nums.length - 1;
                while (j > i) {
                    int thirdNum = (nums[i] + nums[j]) * -1;

                    if ((k = Arrays.binarySearch(nums, i + 1, j, thirdNum)) > 0) {
                        min = nums[i];
                        max = Math.max(nums[j], nums[k]);
                        middle = Math.min(nums[j], nums[k]);
                        resultMap.putIfAbsent("" + min + middle + max, List.of(min, middle, max));
                    }
                    j--;
                }
            }
            int[][] result = new int[resultMap.size()][];
            var ref = new Object() {
                int count = 0;
            };
            resultMap.forEach((key, value) -> result[ref.count++] = new int[]{value.get(0), value.get(1), value.get(2)});
            return result;
        }

        // complexity O(n) = n^2
        public static int[][] solveImproved(int[] nums) {
            if (nums.length < 3) {
                return new int[0][];
            }

            Arrays.sort(nums);
            if (nums[0] > 0 || nums[nums.length - 1] < 0) {
                return new int[0][];
            } else if (nums[0] == 0 && nums[nums.length - 1] == 0) {
                return new int[][]{{0, 0, 0}};
            }

            int left, right, sum;
            List<int[]> result = new ArrayList<>();
            for (int i = 0; i < nums.length - 2 && nums[i] < 0; i++) {

                left = i + 1;
                right = nums.length - 1;
                while (left < right) {
                    sum = nums[i] + nums[left] + nums[right];
                    if (sum == 0) {
                        result.add(new int[]{nums[i], nums[left], nums[right]});
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                    } else if (sum < 0) {
                        left++;
                    } else {
                        right--;
                    }
                }

                while (nums[i] == nums[i + 1] && i < nums.length - 2 && nums[i] < 0) {
                    i++;
                }
            }
            return result.toArray(new int[result.size()][]);
        }
    }
}
