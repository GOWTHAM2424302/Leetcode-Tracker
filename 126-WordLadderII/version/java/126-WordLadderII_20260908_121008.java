// Last updated: 9/8/2026, 12:10:08 PM
1import java.util.*;
2
3class Solution {
4
5    public List<List<String>> findLadders(String beginWord, String endWord,
6                                          List<String> wordList) {
7
8        Set<String> dict = new HashSet<>(wordList);
9        List<List<String>> result = new ArrayList<>();
10
11        if (!dict.contains(endWord)) {
12            return result;
13        }
14
15        Map<String, List<String>> parents = new HashMap<>();
16        Queue<String> queue = new LinkedList<>();
17        Set<String> visited = new HashSet<>();
18
19        queue.offer(beginWord);
20        visited.add(beginWord);
21
22        boolean found = false;
23
24        while (!queue.isEmpty() && !found) {
25            int size = queue.size();
26            Set<String> levelVisited = new HashSet<>();
27
28            for (int i = 0; i < size; i++) {
29                String word = queue.poll();
30                char[] chars = word.toCharArray();
31
32                for (int j = 0; j < chars.length; j++) {
33                    char original = chars[j];
34
35                    for (char c = 'a'; c <= 'z'; c++) {
36                        if (c == original) continue;
37
38                        chars[j] = c;
39                        String nextWord = new String(chars);
40
41                        if (dict.contains(nextWord) && !visited.contains(nextWord)) {
42
43                            if (!levelVisited.contains(nextWord)) {
44                                queue.offer(nextWord);
45                                levelVisited.add(nextWord);
46                            }
47
48                            parents
49                                .computeIfAbsent(nextWord, k -> new ArrayList<>())
50                                .add(word);
51
52                            if (nextWord.equals(endWord)) {
53                                found = true;
54                            }
55                        }
56                    }
57
58                    chars[j] = original;
59                }
60            }
61
62            visited.addAll(levelVisited);
63        }
64
65        if (found) {
66            List<String> path = new ArrayList<>();
67            path.add(endWord);
68            backtrack(endWord, beginWord, parents, path, result);
69        }
70
71        return result;
72    }
73
74    private void backtrack(String word, String beginWord,
75                           Map<String, List<String>> parents,
76                           List<String> path,
77                           List<List<String>> result) {
78
79        if (word.equals(beginWord)) {
80            List<String> completePath = new ArrayList<>(path);
81            Collections.reverse(completePath);
82            result.add(completePath);
83            return;
84        }
85
86        if (!parents.containsKey(word)) return;
87
88        for (String parent : parents.get(word)) {
89            path.add(parent);
90            backtrack(parent, beginWord, parents, path, result);
91            path.remove(path.size() - 1);
92        }
93    }
94}