// Last updated: 9/11/2026, 9:41:22 AM
1class Solution {
2    String[] ones = {
3        "", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
4        "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen",
5        "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
6    };
7
8    String[] tens = {
9        "", "", "Twenty", "Thirty", "Forty", "Fifty",
10        "Sixty", "Seventy", "Eighty", "Ninety"
11    };
12
13    public String numberToWords(int num) {
14        if (num == 0) {
15            return "Zero";
16        }
17
18        return convert(num).trim().replaceAll("\\s+", " ");
19    }
20
21    private String convert(int num) {
22        StringBuilder sb = new StringBuilder();
23
24        if (num >= 1000000000) {
25            sb.append(convert(num / 1000000000)).append(" Billion ");
26            num %= 1000000000;
27        }
28
29        if (num >= 1000000) {
30            sb.append(convert(num / 1000000)).append(" Million ");
31            num %= 1000000;
32        }
33
34        if (num >= 1000) {
35            sb.append(convert(num / 1000)).append(" Thousand ");
36            num %= 1000;
37        }
38
39        if (num >= 100) {
40            sb.append(convert(num / 100)).append(" Hundred ");
41            num %= 100;
42        }
43
44        if (num >= 20) {
45            sb.append(tens[num / 10]).append(" ");
46            num %= 10;
47        }
48
49        if (num > 0) {
50            sb.append(ones[num]).append(" ");
51        }
52
53        return sb.toString();
54    }
55}