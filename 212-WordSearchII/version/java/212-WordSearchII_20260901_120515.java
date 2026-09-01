// Last updated: 9/1/2026, 12:05:15 PM
1import java.util.*;
2
3class Solution {
4
5    static class TrieNode {
6        TrieNode[] children = new TrieNode[26];
7        String word;
8    }
9
10    public List<String> findWords(char[][] board, String[] words) {
11        List<String> result = new ArrayList<>();
12
13        // Build Trie
14        TrieNode root = new TrieNode();
15
16        for (String word : words) {
17            TrieNode node = root;
18
19            for (char ch : word.toCharArray()) {
20                int index = ch - 'a';
21
22                if (node.children[index] == null) {
23                    node.children[index] = new TrieNode();
24                }
25
26                node = node.children[index];
27            }
28
29            node.word = word;
30        }
31
32        // Search each cell
33        for (int i = 0; i < board.length; i++) {
34            for (int j = 0; j < board[0].length; j++) {
35                dfs(board, i, j, root, result);
36            }
37        }
38
39        return result;
40    }
41
42    private void dfs(char[][] board, int row, int col,
43                     TrieNode node, List<String> result) {
44
45        char ch = board[row][col];
46
47        // Invalid cell or no matching Trie path
48        if (ch == '#' || node.children[ch - 'a'] == null) {
49            return;
50        }
51
52        node = node.children[ch - 'a'];
53
54        // Word found
55        if (node.word != null) {
56            result.add(node.word);
57            node.word = null; // Avoid duplicates
58        }
59
60        // Mark as visited
61        board[row][col] = '#';
62
63        int[] dr = {-1, 1, 0, 0};
64        int[] dc = {0, 0, -1, 1};
65
66        for (int k = 0; k < 4; k++) {
67            int newRow = row + dr[k];
68            int newCol = col + dc[k];
69
70            if (newRow >= 0 && newRow < board.length &&
71                newCol >= 0 && newCol < board[0].length) {
72
73                dfs(board, newRow, newCol, node, result);
74            }
75        }
76
77        // Restore cell
78        board[row][col] = ch;
79    }
80}
81