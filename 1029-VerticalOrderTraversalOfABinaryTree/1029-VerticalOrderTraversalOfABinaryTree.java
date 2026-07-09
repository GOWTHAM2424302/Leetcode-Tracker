// Last updated: 7/9/2026, 3:01:28 PM
import java.util.*;

class Solution {

    class Node {
        TreeNode node;
        int row, col;

        Node(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(root, 0, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            map.putIfAbsent(cur.col, new ArrayList<>());
            map.get(cur.col).add(new int[]{cur.row, cur.node.val});

            if (cur.node.left != null)
                q.offer(new Node(cur.node.left, cur.row + 1, cur.col - 1));

            if (cur.node.right != null)
                q.offer(new Node(cur.node.right, cur.row + 1, cur.col + 1));
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (List<int[]> list : map.values()) {
            Collections.sort(list, (a, b) -> {
                if (a[0] == b[0])
                    return a[1] - b[1];
                return a[0] - b[0];
            });

            List<Integer> temp = new ArrayList<>();
            for (int[] x : list)
                temp.add(x[1]);

            ans.add(temp);
        }

        return ans;
    }
}
