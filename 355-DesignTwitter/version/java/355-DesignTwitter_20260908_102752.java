// Last updated: 9/8/2026, 10:27:52 AM
1class WordFilter {
2
3    private Map<String, Integer> map;
4
5    public WordFilter(String[] words) {
6        map = new HashMap<>();
7
8        for (int index = 0; index < words.length; index++) {
9            String word = words[index];
10            int n = word.length();
11
12            // Store every suffix + "#" + prefix combination
13            for (int i = 0; i <= n; i++) {
14                String suffix = word.substring(i);
15
16                for (int j = 0; j <= n; j++) {
17                    String prefix = word.substring(0, j);
18
19                    map.put(suffix + "#" + prefix, index);
20                }
21            }
22        }
23    }
24
25    public int f(String pref, String suff) {
26        return map.getOrDefault(suff + "#" + pref, -1);
27    }
28}