// Last updated: 7/9/2026, 3:01:45 PM
class Solution {
    int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++)
            parent[i] = i;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (find(u) == find(v))
                return edge;

            union(u, v);
        }

        return new int[0];
    }

    private int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    private void union(int a, int b) {
        parent[find(a)] = find(b);
    }
}