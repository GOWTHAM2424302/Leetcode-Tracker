// Last updated: 8/14/2026, 12:07:11 AM
1class Solution {
2    static class Node {char leftChar; char rightChar; int length; int prefix; int suffix;
3int best;
4        Node(char leftChar, char rightChar, int length, int prefix, int suffix, int best) {
5            this.leftChar = leftChar;
6            this.rightChar = rightChar;
7            this.length = length;
8            this.prefix = prefix;
9            this.suffix = suffix;
10            this.best = best;
11        }
12    }
13
14    private Node[] tree;
15
16    private Node merge(Node left, Node right) {
17        int length = left.length + right.length;
18        int prefix = left.prefix;
19
20        if (left.rightChar == right.leftChar && left.prefix == left.length) {
21            prefix = left.length + right.prefix;
22        }
23
24        int suffix = right.suffix;
25
26        if (left.rightChar == right.leftChar && right.suffix == right.length) {
27            suffix = right.length + left.suffix;
28        }
29
30        int best = Math.max(left.best, right.best);
31
32        if (left.rightChar == right.leftChar) {
33            best = Math.max(best, left.suffix + right.prefix);
34        }
35
36        return new Node(left.leftChar, right.rightChar, length, prefix, suffix, best);
37    }
38
39    private void build( int node, int start, int end, String s) {
40        if (start == end) {
41            tree[node] = new Node( s.charAt(start), s.charAt(start), 1, 1, 1, 1);
42            return;
43        }
44
45        int mid = (start + end) / 2;
46
47        build(node * 2, start, mid, s);
48        build(node * 2 + 1, mid + 1, end, s);
49
50        tree[node] = merge(tree[node * 2],tree[node * 2 + 1]
51        );
52    }
53
54    private void update( int node, int start, int end, int index, char ch) {
55        if (start == end) {
56            tree[node] = new Node(ch, ch, 1, 1, 1, 1);
57            return;
58        }
59
60        int mid = (start + end) / 2;
61
62        if (index <= mid) {
63            update(node * 2, start, mid, index, ch);
64        } else {
65            update(node * 2 + 1, mid + 1, end, index, ch);
66        }
67
68        tree[node] = merge(
69            tree[node * 2],
70            tree[node * 2 + 1]
71        );
72    }
73
74    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
75        int n = s.length();
76        tree = new Node[4 * n];
77        build(1, 0, n - 1, s);
78        int[] answer = new int[queryIndices.length];
79
80        for (int i = 0; i < queryIndices.length; i++) {
81            update(1, 0, n - 1, queryIndices[i], queryCharacters.charAt(i));
82            answer[i] = tree[1].best;
83        }
84
85        return answer;
86    }
87}