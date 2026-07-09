// Last updated: 7/9/2026, 3:01:36 PM
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;

        List<Integer>[] rev = new ArrayList[n];

        for (int i = 0; i < n; i++)
            rev[i] = new ArrayList<>();

        int[] out = new int[n];

        for (int i = 0; i < n; i++) {
            out[i] = graph[i].length;
            for (int v : graph[i])
                rev[v].add(i);
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++)
            if (out[i] == 0)
                q.offer(i);

        List<Integer> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            int cur = q.poll();
            ans.add(cur);

            for (int prev : rev[cur]) {
                if (--out[prev] == 0)
                    q.offer(prev);
            }
        }

        Collections.sort(ans);
        return ans;
    }
}