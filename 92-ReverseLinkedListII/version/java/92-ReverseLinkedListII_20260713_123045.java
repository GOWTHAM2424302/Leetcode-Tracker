// Last updated: 7/13/2026, 12:30:45 PM
1class Solution {
2    public boolean isValidBST(TreeNode root) {
3        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
4    }
5
6    private boolean validate(TreeNode node, long min, long max) {
7        if (node == null) return true;
8
9        if (node.val <= min || node.val >= max) {
10            return false;
11        }
12
13        return validate(node.left, min, node.val) &&
14               validate(node.right, node.val, max);
15    }
16}