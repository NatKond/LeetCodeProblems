import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class _653TwoSumIV_InputAsBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(5);
        System.out.println("Solution.findTarget(root, 8) = " + Solution.findTarget(root, 8));
        System.out.println("Solution.findTarget(root, 6) = " + Solution.findTarget(root, 6));

    }

    static class Solution {

        static public boolean findTarget(TreeNode root, int k) {
            Set<Integer> treeValues = new HashSet<>();
            getArray(root, treeValues);
            Iterator<Integer> iterator = treeValues.iterator();
            while (iterator.hasNext()) {
                int value = iterator.next();
                iterator.remove();
                if (treeValues.contains(k - value)){
                    return true;
                }
            }
            return false;
        }

        static private void getArray(TreeNode current, Set<Integer> treeValues) {
            treeValues.add(current.val);
            if (current.right != null) {
                getArray(current.right, treeValues);
            }
            if (current.left != null) {
                getArray(current.left, treeValues);
            }
        }
    }
}

class TreeNode {

    int val;

    TreeNode left;

    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


