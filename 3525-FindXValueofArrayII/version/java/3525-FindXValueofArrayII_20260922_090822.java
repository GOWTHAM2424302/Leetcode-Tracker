// Last updated: 9/22/2026, 9:08:22 AM
1class Solution {
2    static class Node {
3        int prod;
4        int[] cnt;
5
6        Node(int k) {
7            cnt = new int[k];
8        }
9    }
10
11    int n, k;
12    Node[] tree;
13
14    Node merge(Node a, Node b) {
15        Node res = new Node(k);
16
17        res.prod = (a.prod * b.prod) % k;
18
19        for (int r = 0; r < k; r++) {
20            res.cnt[r] += a.cnt[r];
21        }
22
23        for (int r = 0; r < k; r++) {
24            int nr = (a.prod * r) % k;
25            res.cnt[nr] += b.cnt[r];
26        }
27
28        return res;
29    }
30
31    Node makeNode(int value) {
32        Node node = new Node(k);
33
34        int v = value % k;
35        node.prod = v;
36        node.cnt[v] = 1;
37
38        return node;
39    }
40
41    void build(int idx, int l, int r, int[] nums) {
42        if (l == r) {
43            tree[idx] = makeNode(nums[l]);
44            return;
45        }
46
47        int mid = (l + r) / 2;
48
49        build(idx * 2, l, mid, nums);
50        build(idx * 2 + 1, mid + 1, r, nums);
51
52        tree[idx] = merge(tree[idx * 2], tree[idx * 2 + 1]);
53    }
54
55    void update(int idx, int l, int r, int pos, int value) {
56        if (l == r) {
57            tree[idx] = makeNode(value);
58            return;
59        }
60
61        int mid = (l + r) / 2;
62
63        if (pos <= mid) {
64            update(idx * 2, l, mid, pos, value);
65        } else {
66            update(idx * 2 + 1, mid + 1, r, pos, value);
67        }
68
69        tree[idx] = merge(tree[idx * 2], tree[idx * 2 + 1]);
70    }
71
72    Node query(int idx, int l, int r, int ql, int qr) {
73        if (ql <= l && r <= qr) {
74            return tree[idx];
75        }
76
77        int mid = (l + r) / 2;
78
79        if (qr <= mid) {
80            return query(idx * 2, l, mid, ql, qr);
81        }
82
83        if (ql > mid) {
84            return query(idx * 2 + 1, mid + 1, r, ql, qr);
85        }
86
87        Node left = query(idx * 2, l, mid, ql, qr);
88        Node right = query(idx * 2 + 1, mid + 1, r, ql, qr);
89
90        return merge(left, right);
91    }
92
93    public int[] resultArray(int[] nums, int k, int[][] queries) {
94        this.n = nums.length;
95        this.k = k;
96
97        tree = new Node[4 * n];
98
99        build(1, 0, n - 1, nums);
100
101        int[] ans = new int[queries.length];
102
103        for (int i = 0; i < queries.length; i++) {
104            int index = queries[i][0];
105            int value = queries[i][1];
106            int start = queries[i][2];
107            int x = queries[i][3];
108
109            update(1, 0, n - 1, index, value);
110
111            Node res = query(1, 0, n - 1, start, n - 1);
112
113            ans[i] = res.cnt[x];
114        }
115
116        return ans;
117    }
118}