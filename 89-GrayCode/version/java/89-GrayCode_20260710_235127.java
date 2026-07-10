// Last updated: 7/10/2026, 11:51:27 PM
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
17    public boolean isSymmetric(TreeNode root) {
18        if (root == null) {
19            return true;
20        }
21
22        return isMirror(root.left, root.right);
23    }
24
25    private boolean isMirror(TreeNode left, TreeNode right) {
26        if (left == null && right == null) {
27            return true;
28        }
29
30        if (left == null || right == null) {
31            return false;
32        }
33
34        return left.val == right.val
35                && isMirror(left.left, right.right)
36                && isMirror(left.right, right.left);
37    }
38}