// Last updated: 9/8/2026, 12:13:09 PM
1import java.util.*;
2
3class Solution {
4    public boolean wordPattern(String pattern, String s) {
5        String[] words = s.split(" ");
6
7        if (pattern.length() != words.length) {
8            return false;
9        }
10
11        Map<Character, String> map = new HashMap<>();
12        Set<String> used = new HashSet<>();
13
14        for (int i = 0; i < pattern.length(); i++) {
15            char ch = pattern.charAt(i);
16
17            if (map.containsKey(ch)) {
18                if (!map.get(ch).equals(words[i])) {
19                    return false;
20                }
21            } else {
22                if (used.contains(words[i])) {
23                    return false;
24                }
25
26                map.put(ch, words[i]);
27                used.add(words[i]);
28            }
29        }
30
31        return true;
32    }
33}