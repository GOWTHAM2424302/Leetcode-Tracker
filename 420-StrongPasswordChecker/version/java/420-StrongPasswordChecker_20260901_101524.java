// Last updated: 9/1/2026, 10:15:24 AM
1class Solution {
2    public int strongPasswordChecker(String password) {
3        int n = password.length();
4
5        boolean hasLower = false;
6        boolean hasUpper = false;
7        boolean hasDigit = false;
8
9        for (char c : password.toCharArray()) {
10            if (Character.isLowerCase(c)) {
11                hasLower = true;
12            } else if (Character.isUpperCase(c)) {
13                hasUpper = true;
14            } else if (Character.isDigit(c)) {
15                hasDigit = true;
16            }
17        }
18
19        int missingTypes = 0;
20
21        if (!hasLower) missingTypes++;
22        if (!hasUpper) missingTypes++;
23        if (!hasDigit) missingTypes++;
24
25        int replace = 0;
26        int oneMod = 0;
27        int twoMod = 0;
28
29        // Find consecutive repeating characters
30        for (int i = 0; i < n;) {
31            int j = i;
32
33            while (j < n && password.charAt(j) == password.charAt(i)) {
34                j++;
35            }
36
37            int length = j - i;
38
39            if (length >= 3) {
40                replace += length / 3;
41
42                if (length % 3 == 0) {
43                    oneMod++;
44                } else if (length % 3 == 1) {
45                    twoMod++;
46                }
47            }
48
49            i = j;
50        }
51
52        // Password is too short
53        if (n < 6) {
54            return Math.max(6 - n, missingTypes);
55        }
56
57        // Password length is valid
58        if (n <= 20) {
59            return Math.max(replace, missingTypes);
60        }
61
62        // Password is too long
63        int delete = n - 20;
64        int remainingDelete = delete;
65
66        // Delete from groups where length % 3 == 0
67        int use = Math.min(remainingDelete, oneMod);
68        replace -= use;
69        remainingDelete -= use;
70
71        // Delete from groups where length % 3 == 1
72        use = Math.min(remainingDelete, twoMod * 2);
73        replace -= use / 2;
74        remainingDelete -= use;
75
76        // Delete remaining characters
77        replace -= remainingDelete / 3;
78
79        return delete + Math.max(replace, missingTypes);
80    }
81}