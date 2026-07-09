// Last updated: 7/9/2026, 3:01:47 PM
import java.util.*;

class Solution {

    class Pair {
        TreeNode node;
        long index;

        Pair(TreeNode node, long index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        int ans = 0;

        while (!q.isEmpty()) {

            int size = q.size();
            long min = q.peek().index;
            long first = 0, last = 0;

            for (int i = 0; i < size; i++) {

                Pair cur = q.poll();
                long idx = cur.index - min;

                if (i == 0) first = idx;
                if (i == size - 1) last = idx;

                if (cur.node.left != null)
                    q.offer(new Pair(cur.node.left, idx * 2 + 1));

                if (cur.node.right != null)
                    q.offer(new Pair(cur.node.right, idx * 2 + 2));
            }

            ans = Math.max(ans, (int)(last - first + 1));
        }

        return ans;
    }
}