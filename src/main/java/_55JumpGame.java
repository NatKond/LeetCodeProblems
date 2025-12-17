public class _55JumpGame {

    public static void main(String[] args) {
        System.out.println("Solution.canJump(new int[]{2, 3, 1, 1, 4}) = " + Solution.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println("Solution.canJump(new int[]{0, 4}) = " + Solution.canJump(new int[]{0, 4}));
        System.out.println("Solution.canJump(new int[]{0}) = " + Solution.canJump(new int[]{0}));
        System.out.println("Solution.canJump(new int[]{2,0}) = " + Solution.canJump(new int[]{2, 0}));
        System.out.println("Solution.canJumpGreedy(new int[]{2, 3, 1, 1, 4}) = " + Solution.canJumpGreedy(new int[]{2, 3, 1, 1, 4}));
        System.out.println("Solution.canJumpGreedy(new int[]{0, 4}) = " + Solution.canJumpGreedy(new int[]{0, 4}));
        System.out.println("Solution.canJumpGreedy(new int[]{0}) = " + Solution.canJumpGreedy(new int[]{0}));
        System.out.println("Solution.canJumpGreedy(new int[]{2, 0}) = " + Solution.canJumpGreedy(new int[]{2, 0}));
        System.out.println("Solution.canJumpGreedyReverse(new int[]{2, 3, 1, 1, 4}) = " + Solution.canJumpGreedyReverse(new int[]{2, 3, 1, 1, 4}));
        System.out.println("Solution.canJumpGreedyReverse(new int[]{0, 4}) = " + Solution.canJumpGreedyReverse(new int[]{0, 4}));
        System.out.println("Solution.canJumpGreedyReverse(new int[]{0}) = " + Solution.canJumpGreedyReverse(new int[]{0}));
        System.out.println("Solution.canJumpGreedyReverse(new int[]{2, 0}) = " + Solution.canJumpGreedyReverse(new int[]{2, 0}));
    }

    static class Solution {
        public static boolean canJump(int[] nums) {
            for(int i = nums.length - 2; i > -1 ; i--){
                if (nums[i] == 0){
                    int k = 0;
                    while (nums[i - k] <= k){
                        if (i - ++k < 0){
                            return false;
                        }
                    }
                    i -= k;
                }
            }
            return true;
        }

        public static boolean canJumpGreedy(int[] nums) {
            int reachable = 0;
            for(int i = 0; i < nums.length; i++) {
                if(i > reachable) return false;
                reachable = Math.max(reachable, i + nums[i]);
            }
            return true;
        }

        public static boolean canJumpGreedyReverse(int[] nums) {
            int target = nums.length - 1;
            for(int i = nums.length - 2; i > -1; i--) {
                if(i + nums[i] == target){
                    target = i;
                }
            }
            return target == 0;
        }
    }
}

