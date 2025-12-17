public class _45JumpGameII {

    public static void main(String[] args) {
        System.out.println("Solution.jump(new int[]{2, 3, 1, 1, 4}) = " + Solution.jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println("Solution.jump(new int[]{2, 3, 0, 1, 4}) = " + Solution.jump(new int[]{2, 3, 0, 1, 4}));
        System.out.println("Solution.jump(new int[]{2, 3, 1}) = " + Solution.jump(new int[]{2, 3, 1}));
        System.out.println("Solution.jump(new int[]{3, 2, 1}) = " + Solution.jump(new int[]{3, 2, 1}));
        System.out.println("Solution.jump(new int[]{3}) = " + Solution.jump(new int[]{3}));
        System.out.println("Solution.jumpGreedy(new int[]{2, 3, 1, 1, 4}) = " + Solution.jumpGreedy(new int[]{2, 3, 1, 1, 4}));
        System.out.println("Solution.jumpGreedy(new int[]{2, 3, 0, 1, 4}) = " + Solution.jumpGreedy(new int[]{2, 3, 0, 1, 4}));
        System.out.println("Solution.jumpGreedy(new int[]{2, 3, 1}) = " + Solution.jumpGreedy(new int[]{2, 3, 1}));
        System.out.println("Solution.jumpGreedy(new int[]{3, 2, 1}) = " + Solution.jumpGreedy(new int[]{3, 2, 1}));
        System.out.println("Solution.jumpGreedy(new int[]{3}) = " + Solution.jumpGreedy(new int[]{3}));
    }

    static class Solution {

        public static int jump(int[] nums) {
            int count = 0;
            int target = nums.length - 1;
            while (target != 0) {
                int max = 1;
                int nextTarget = target - 1;
                for (int i = target - 1; i >= 0; i--) {
                    if (i + nums[i] >= target && nums[i] > max) {
                        max = target - i;
                        nextTarget = i;
                    }
                }
                target = nextTarget;
                count++;
            }
            return count;
        }

        public static int jumpGreedy(int[] nums) {
            int count = 0;
            int reachable = 0;
            int jumpEnd = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                if (i + nums[i] > reachable) {
                    reachable = i + nums[i];
                }
                if (i == jumpEnd){
                    jumpEnd = reachable;
                    count++;
                    if (jumpEnd == nums.length - 1) {
                        break;
                    }
                }
            }
            return count;
        }
    }
}
