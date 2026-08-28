// Last updated: 8/28/2026, 9:26:14 AM
1class Solution {
2    public String isPossible(int n, int[] freqIn, String cur, char mid, String target){
3        int[] freq = freqIn.clone(); // copy, since C++ passes freq by value here
4
5        // build the largest possible arrangement of remaining chars (descending order)
6        for(int i=25; i>=0; i--){
7            while(freq[i] > 0){
8                cur += (char)('a'+i);
9                freq[i]--;
10            }
11        }
12
13        if(mid!='#'){
14            // odd-length palindrome: left half + mid + reverse(left half)
15            String temp = cur;
16            cur += mid;
17            temp = new StringBuilder(temp).reverse().toString();
18            cur += temp;
19        }
20        else {
21            // even-length palindrome: left half + reverse(left half)
22            String temp = cur;
23            temp = new StringBuilder(temp).reverse().toString();
24            cur += temp;
25        }
26
27        // feasibility check: only valid if this (largest possible) candidate beats target
28        return cur.compareTo(target) > 0 ? cur : "";
29    }
30
31    public String lexPalindromicPermutation(String s, String target) {
32        int n = s.length();
33
34        int[] freq = new int[26];
35
36        if(n==1){
37            if(s.compareTo(target) > 0) return s;
38            else return "";
39        }
40
41        for(char c : s.toCharArray())
42            freq[c-'a']++;
43
44        char mid = '#';
45        int oddCount = 0;
46
47        for(int i=0; i<26; i++){
48            if(freq[i]%2 != 0){
49                // odd count -> this becomes the middle character
50                mid = (char)('a'+i);
51                freq[i]--;
52                oddCount++;
53            }
54
55            freq[i] /= 2; // each char used freq[i]/2 times in the left half
56
57            if(oddCount>=2) return ""; // more than one odd-frequency char -> can't form a palindrome
58        }
59
60        n /= 2; // we only need to construct the left half now
61
62        String res = "", prefix = "";
63
64        // greedily build the left half, position by position
65        for(int i=0; i<n; i++){
66
67            String cur = prefix;
68            boolean isThereAny = false;
69
70            // try smallest character first ('a' -> 'z')
71            for(int j=0; j<26; j++){
72
73                if(freq[j] > 0){
74
75                    freq[j]--;
76                    cur += (char)('a'+j);
77
78                    // check if this prefix can still lead to a palindrome > target
79                    String isPos = isPossible(n, freq, cur, mid, target);
80
81                    if(!isPos.equals("")){
82                        prefix = cur;      // keep this character, lock in the prefix
83                        isThereAny = true;
84
85                        if(res.equals(""))
86                            res = isPos;
87                        else
88                            res = res.compareTo(isPos) < 0 ? res : isPos; // track smallest valid candidate
89
90                        break;
91                    }
92
93                    // this character doesn't work, undo and try the next one
94                    freq[j]++;
95                    cur = cur.substring(0, cur.length()-1);
96                }
97            }
98
99            if(!isThereAny)
100                return ""; // no character works at this position -> impossible
101        }
102
103        return res; 
104    }
105}