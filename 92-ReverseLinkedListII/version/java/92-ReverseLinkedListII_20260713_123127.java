// Last updated: 7/13/2026, 12:31:27 PM
1class Solution {
2    TreeNode first = null;
3    TreeNode second = null;
4    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
5
6    public void recoverTree(TreeNode root) {
7        inorder(root);
8
9        int temp = first.val;
10        first.val = second.val;
11        second.val = temp;
12    }
13
14    private void inorder(TreeNode root) {
15        if (root == null) return;
16
17        inorder(root.left);
18
19        if (prev.val > root.val) {
20            if (first == null) {
21                first = prev;
22            }
23            second = root;
24        }
25
26        prev = root;
27
28        inorder(root.right);
29    }
30}