// Last updated: 9/23/2026, 9:28:04 AM
1class StreamChecker {
2    static class TrieNode {
3        TrieNode[] child = new TrieNode[26];
4        boolean end;
5    }
6
7    TrieNode root = new TrieNode();
8    StringBuilder stream = new StringBuilder();
9
10    public StreamChecker(String[] words) {
11        for (String word : words) {
12            TrieNode node = root;
13            for (int i = word.length() - 1; i >= 0; i--) {
14                int idx = word.charAt(i) - 'a';
15                if (node.child[idx] == null) {
16                    node.child[idx] = new TrieNode();
17                }
18                node = node.child[idx];
19            }
20            node.end = true;
21        }
22    }
23
24    public boolean query(char letter) {
25        stream.append(letter);
26
27        TrieNode node = root;
28
29        for (int i = stream.length() - 1; i >= 0; i--) {
30            int idx = stream.charAt(i) - 'a';
31
32            if (node.child[idx] == null) {
33                return false;
34            }
35
36            node = node.child[idx];
37
38            if (node.end) {
39                return true;
40            }
41        }
42
43        return false;
44    }
45}