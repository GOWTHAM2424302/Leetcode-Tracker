// Last updated: 7/13/2026, 12:31:57 PM
1class Solution {
2    public boolean isSameTree(TreeNode p, TreeNode q) {
3        if (p == null && q == null) {
4            return true;
5        }
6
7        if (p == null || q == null) {
8            return false;
9        }
10
11        if (p.val != q.val) {
12            return false;
13        }
14
15        return isSameTree(p.left, q.left) &&
16               isSameTree(p.right, q.right);
17    }
18}