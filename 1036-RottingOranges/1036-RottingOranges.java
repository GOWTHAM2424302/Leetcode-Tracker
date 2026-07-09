// Last updated: 7/9/2026, 3:01:25 PM
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2)
                    q.offer(new int[]{i, j});
                else if (grid[i][j] == 1)
                    fresh++;
            }
        }

        int time = 0;
        int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();

            while (size-- > 0) {
                int[] cur = q.poll();

                for (int[] dir : d) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];

                    if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        fresh--;
                        q.offer(new int[]{x, y});
                    }
                }
            }

            time++;
        }

        return fresh == 0 ? time : -1;
    }
}