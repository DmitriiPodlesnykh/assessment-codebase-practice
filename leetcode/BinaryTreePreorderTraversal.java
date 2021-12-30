/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class BinaryTreePreorderTraversal {
    
    private final List<Integer> result = new ArrayList<>();
    
    /**
      * https://leetcode.com/problems/binary-tree-preorder-traversal/
      *
      * Runtime: 1 ms, faster than 10.87% of Java online submissions for Binary Tree Preorder Traversal.
      * Memory Usage: 38.9 MB, less than 11.91% of Java online submissions for Binary Tree Preorder Traversal.
      */
    public List<Integer> preorderTraversal(TreeNode root) {
        preorderAdd(root);
        return result;
    }
    
    private void preorderAdd(TreeNode element) {
        if (element != null) {
            result.add(element.val);
            preorderAdd(element.left);
            preorderAdd(element.right);
        }
    }
    
}
