// Last updated: 9/2/2026, 9:36:26 AM
1class Solution {
2    public TreeNode addOneRow(TreeNode root, int val, int depth) {
3        if (depth == 1) {
4            TreeNode newRoot = new TreeNode(val);
5            newRoot.left = root;
6            return newRoot;
7        }
8
9        addRow(root, val, depth, 1);
10        return root;
11    }
12
13    private void addRow(TreeNode node, int val, int depth, int level) {
14        if (node == null) {
15            return;
16        }
17
18        if (level == depth - 1) {
19            TreeNode oldLeft = node.left;
20            TreeNode oldRight = node.right;
21
22            node.left = new TreeNode(val);
23            node.left.left = oldLeft;
24
25            node.right = new TreeNode(val);
26            node.right.right = oldRight;
27
28            return;
29        }
30
31        addRow(node.left, val, depth, level + 1);
32        addRow(node.right, val, depth, level + 1);
33    }
34}