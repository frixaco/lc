package lc226;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        var result = solution.invertTree(
                new TreeNode(4,
                        new TreeNode(2,
                                new TreeNode(1), new TreeNode(3)),
                        new TreeNode(7,
                                new TreeNode(6), new TreeNode(9))));

        System.out.println(result.val);
        System.out.println(result.left.val);
        System.out.println(result.right.val);
        System.out.println(result.left.left.val);
        System.out.println(result.left.right.val);
        System.out.println(result.right.left.val);
        System.out.println(result.right.right.val);
    }

    public TreeNode invertTree(TreeNode root) {
        /*
         * --------4
         * ---- / -- \
         * -- 2 ----- 7
         * - / \ -- / \
         * -1 - 3 6 -- 9
         */

        if (root == null) {
            return null;
        }

        /*
         * val: 4
         * left: invert(7, 6, 9) (l)
         * right: invert(2, 1, 3) (r)
         * 
         * (l)
         * val: 7
         * left: invert(9)
         * right: invert(6)
         * 
         * val: 9
         * left: null
         * right: null
         * 
         * val: 6
         * left: null
         * right: null
         * 
         * (r)
         * val: 2
         * left: invert(3)
         * right: invert(1)
         * 
         * val: 3
         * left: null
         * right: null
         * 
         * val: 1
         * left: null
         * right: null
         */

        TreeNode result = new TreeNode(root.val);
        result.left = invertTree(root.right);
        result.right = invertTree(root.left);

        return result;
    }
}
