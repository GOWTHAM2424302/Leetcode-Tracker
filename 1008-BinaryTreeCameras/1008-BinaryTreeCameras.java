// Last updated: 7/9/2026, 3:01:31 PM
class Solution {

    private int cameras = 0;

    // 0 = has camera
    // 1 = covered
    // 2 = needs camera
    private int dfs(TreeNode root) {
        if (root == null) {
            return 1;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        if (left == 2 || right == 2) {
            cameras++;
            return 0;
        }

        if (left == 0 || right == 0) {
            return 1;
        }

        return 2;
    }

    public int minCameraCover(TreeNode root) {
        if (dfs(root) == 2) {
            cameras++;
        }
        return cameras;
    }
}