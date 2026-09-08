// Last updated: 9/8/2026, 10:23:32 AM
1class Solution {
2
3    public boolean isAdditiveNumber(String num) {
4        int n = num.length();
5
6        for (int i = 1; i <= n / 2; i++) {
7            if (num.charAt(0) == '0' && i > 1) {
8                break;
9            }
10
11            for (int j = 1; Math.max(i, j) <= n - i - j; j++) {
12
13                if (num.charAt(i) == '0' && j > 1) {
14                    break;
15                }
16
17                String num1 = num.substring(0, i);
18                String num2 = num.substring(i, i + j);
19
20                if (isValid(num, i + j, num1, num2)) {
21                    return true;
22                }
23            }
24        }
25
26        return false;
27    }
28
29    private boolean isValid(String num, int start, String num1, String num2) {
30        while (start < num.length()) {
31            String sum = add(num1, num2);
32
33            if (!num.startsWith(sum, start)) {
34                return false;
35            }
36
37            start += sum.length();
38            num1 = num2;
39            num2 = sum;
40        }
41
42        return true;
43    }
44
45    private String add(String a, String b) {
46        StringBuilder result = new StringBuilder();
47
48        int i = a.length() - 1;
49        int j = b.length() - 1;
50        int carry = 0;
51
52        while (i >= 0 || j >= 0 || carry > 0) {
53            int sum = carry;
54
55            if (i >= 0) {
56                sum += a.charAt(i--) - '0';
57            }
58
59            if (j >= 0) {
60                sum += b.charAt(j--) - '0';
61            }
62
63            result.append(sum % 10);
64            carry = sum / 10;
65        }
66
67        return result.reverse().toString();
68    }
69}
70