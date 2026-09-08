// Last updated: 9/8/2026, 12:23:10 PM
1import java.util.*;
2
3class Solution {
4    public List<List<Integer>> palindromePairs(String[] words) {
5        List<List<Integer>> result = new ArrayList<>();
6        Map<String, Integer> map = new HashMap<>();
7
8        for (int i = 0; i < words.length; i++) {
9            map.put(words[i], i);
10        }
11
12        for (int i = 0; i < words.length; i++) {
13            String word = words[i];
14
15            for (int j = 0; j <= word.length(); j++) {
16                String left = word.substring(0, j);
17                String right = word.substring(j);
18
19                if (isPalindrome(left)) {
20                    String reversed = new StringBuilder(right).reverse().toString();
21
22                    if (map.containsKey(reversed) && map.get(reversed) != i) {
23                        result.add(Arrays.asList(map.get(reversed), i));
24                    }
25                }
26
27                if (j != word.length() && isPalindrome(right)) {
28                    String reversed = new StringBuilder(left).reverse().toString();
29
30                    if (map.containsKey(reversed) && map.get(reversed) != i) {
31                        result.add(Arrays.asList(i, map.get(reversed)));
32                    }
33                }
34            }
35        }
36
37        return result;
38    }
39
40    private boolean isPalindrome(String s) {
41        int left = 0;
42        int right = s.length() - 1;
43
44        while (left < right) {
45            if (s.charAt(left) != s.charAt(right)) {
46                return false;
47            }
48
49            left++;
50            right--;
51        }
52
53        return true;
54    }
55}