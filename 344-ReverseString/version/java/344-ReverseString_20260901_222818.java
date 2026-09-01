// Last updated: 9/1/2026, 10:28:18 PM
1class Solution {
2    public TreeNode constructMaximumBinaryTree(int[] nums) {
3        return build(nums, 0, nums.length - 1);
4    }
5
6    private TreeNode build(int[] nums, int left, int right) {
7        if (left > right) {
8            return null;
9        }
10
11        int maxIndex = left;
12
13        // Find maximum element
14        for (int i = left + 1; i <= right; i++) {
15            if (nums[i] > nums[maxIndex]) {
16                maxIndex = i;
17            }
18        }
19
20        // Create root node
21        TreeNode root = new TreeNode(nums[maxIndex]);
22
23        // Build left and right subtrees
24        root.left = build(nums, left, maxIndex - 1);
25        root.right = build(nums, maxIndex + 1, right);
26
27        return root;
28    }
29}