// Last updated: 7/10/2026, 11:50:50 PM
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
17    public List<Integer> inorderTraversal(TreeNode root) {
18        List<Integer> result = new ArrayList<>();
19        inorder(root, result);
20        return result;
21    }
22
23    private void inorder(TreeNode node, List<Integer> result) {
24        if (node == null) {
25            return;
26        }
27
28        inorder(node.left, result);
29        result.add(node.val);
30        inorder(node.right, result);
31    }
32}