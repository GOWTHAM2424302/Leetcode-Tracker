// Last updated: 9/1/2026, 10:31:55 PM
1class Solution {
2    public String[] findWords(String[] words) {
3        String row1 = "qwertyuiop";
4        String row2 = "asdfghjkl";
5        String row3 = "zxcvbnm";
6
7        List<String> result = new ArrayList<>();
8
9        for (String word : words) {
10            String lower = word.toLowerCase();
11
12            String row = "";
13
14            char first = lower.charAt(0);
15
16            if (row1.indexOf(first) != -1) {
17                row = row1;
18            } else if (row2.indexOf(first) != -1) {
19                row = row2;
20            } else {
21                row = row3;
22            }
23
24            boolean valid = true;
25
26            for (char ch : lower.toCharArray()) {
27                if (row.indexOf(ch) == -1) {
28                    valid = false;
29                    break;
30                }
31            }
32
33            if (valid) {
34                result.add(word);
35            }
36        }
37
38        return result.toArray(new String[0]);
39    }
40}