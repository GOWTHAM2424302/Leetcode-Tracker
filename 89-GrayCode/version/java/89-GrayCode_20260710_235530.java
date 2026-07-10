// Last updated: 7/10/2026, 11:55:30 PM
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    public boolean hasPathSum(TreeNode root, int targetSum) {
18        if (root == null) {
19            return false;
20        }
21
22        if (root.left == null && root.right == null) {
23            return targetSum == root.val;
24        }
25
26        return hasPathSum(root.left, targetSum - root.val) ||
27               hasPathSum(root.right, targetSum - root.val);
28    }
29}