// Last updated: 9/1/2026, 9:39:02 AM
1class Solution {
2
3    static class State {
4        int row;
5        int col;
6        int energy;
7        int moves;
8        int mask;
9
10        State(int row, int col, int energy, int moves, int mask) {
11            this.row = row;
12            this.col = col;
13            this.energy = energy;
14            this.moves = moves;
15            this.mask = mask;
16        }
17    }
18
19    public int minMoves(String[] classroom, int energy) {
20        int m = classroom.length;
21        int n = classroom[0].length();
22
23        int startRow = 0;
24        int startCol = 0;
25        int litterCount = 0;
26
27        int[][] litterId = new int[m][n];
28
29        for (int i = 0; i < m; i++) {
30            Arrays.fill(litterId[i], -1);
31
32            for (int j = 0; j < n; j++) {
33                char cell = classroom[i].charAt(j);
34
35                if (cell == 'S') {
36                    startRow = i;
37                    startCol = j;
38                } else if (cell == 'L') {
39                    litterId[i][j] = litterCount++;
40                }
41            }
42        }
43
44        if (litterCount == 0) {
45            return 0;
46        }
47
48        int targetMask = (1 << litterCount) - 1;
49
50        Queue<State> queue = new LinkedList<>();
51
52        queue.offer(
53            new State(
54                startRow,
55                startCol,
56                energy,
57                0,
58                0
59            )
60        );
61
62        boolean[][][][] visited =
63            new boolean[m][n][energy + 1][1 << litterCount];
64
65        visited[startRow][startCol][energy][0] = true;
66
67        int[] dr = {-1, 1, 0, 0};
68        int[] dc = {0, 0, -1, 1};
69
70        while (!queue.isEmpty()) {
71            State current = queue.poll();
72
73            if (current.mask == targetMask) {
74                return current.moves;
75            }
76
77            if (current.energy == 0) {
78                continue;
79            }
80
81            for (int d = 0; d < 4; d++) {
82                int nr = current.row + dr[d];
83                int nc = current.col + dc[d];
84
85                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
86                    continue;
87                }
88
89                char cell = classroom[nr].charAt(nc);
90
91                if (cell == 'X') {
92                    continue;
93                }
94
95                int newEnergy = current.energy - 1;
96                int newMask = current.mask;
97
98                if (cell == 'L') {
99                    int id = litterId[nr][nc];
100                    newMask |= (1 << id);
101                }
102
103                if (cell == 'R') {
104                    newEnergy = energy;
105                }
106
107                if (visited[nr][nc][newEnergy][newMask]) {
108                    continue;
109                }
110
111                visited[nr][nc][newEnergy][newMask] = true;
112
113                queue.offer(
114                    new State(
115                        nr,
116                        nc,
117                        newEnergy,
118                        current.moves + 1,
119                        newMask
120                    )
121                );
122            }
123        }
124
125        return -1;
126    }
127}