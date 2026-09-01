// Last updated: 9/1/2026, 10:39:57 PM
1class Solution {
2    public String getHint(String secret, String guess) {
3        int bulls = 0;
4        int cows = 0;
5
6        int[] count = new int[10];
7
8        for (int i = 0; i < secret.length(); i++) {
9            char s = secret.charAt(i);
10            char g = guess.charAt(i);
11
12            if (s == g) {
13                bulls++;
14            } else {
15                if (count[s - '0'] < 0) {
16                    cows++;
17                }
18
19                if (count[g - '0'] > 0) {
20                    cows++;
21                }
22
23                count[s - '0']++;
24                count[g - '0']--;
25            }
26        }
27
28        return bulls + "A" + cows + "B";
29    }
30}