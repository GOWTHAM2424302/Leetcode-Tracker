// Last updated: 7/10/2026, 11:54:58 PM
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
17    public List<List<Integer>> levelOrderBottom(TreeNode root) {
18        List<List<Integer>> result = new LinkedList<>();
19
20        if (root == null) {
21            return result;
22        }
23
24        Queue<TreeNode> queue = new LinkedList<>();
25        queue.offer(root);
26
27        while (!queue.isEmpty()) {
28            int size = queue.size();
29            List<Integer> level = new ArrayList<>();
30
31            for (int i = 0; i < size; i++) {
32                TreeNode node = queue.poll();
33                level.add(node.val);
34
35                if (node.left != null) {
36                    queue.offer(node.left);
37                }
38
39                if (node.right != null) {
40                    queue.offer(node.right);
41                }
42            }
43
44            ((LinkedList<List<Integer>>) result).addFirst(level);
45        }
46
47        return result;
48    }
49}