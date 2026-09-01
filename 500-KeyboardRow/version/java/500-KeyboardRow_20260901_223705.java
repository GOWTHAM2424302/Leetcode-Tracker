// Last updated: 9/1/2026, 10:37:05 PM
1import java.util.*;
2
3class Solution {
4
5    public List<String> basicCalculatorIV(
6            String expression,
7            String[] evalvars,
8            int[] evalints) {
9
10        Map<String, Integer> values = new HashMap<>();
11
12        for (int i = 0; i < evalvars.length; i++) {
13            values.put(evalvars[i], evalints[i]);
14        }
15
16        Parser parser = new Parser(expression, values);
17        Map<List<String>, Integer> result = parser.parseExpression();
18
19        List<List<String>> terms = new ArrayList<>(result.keySet());
20
21        terms.sort((a, b) -> {
22            if (a.size() != b.size()) {
23                return b.size() - a.size();
24            }
25
26            for (int i = 0; i < a.size(); i++) {
27                int cmp = a.get(i).compareTo(b.get(i));
28                if (cmp != 0) {
29                    return cmp;
30                }
31            }
32
33            return 0;
34        });
35
36        List<String> answer = new ArrayList<>();
37
38        for (List<String> term : terms) {
39            int coefficient = result.get(term);
40
41            if (coefficient == 0) {
42                continue;
43            }
44
45            StringBuilder sb = new StringBuilder();
46            sb.append(coefficient);
47
48            for (String variable : term) {
49                sb.append("*").append(variable);
50            }
51
52            answer.add(sb.toString());
53        }
54
55        return answer;
56    }
57
58    class Parser {
59        String s;
60        int index = 0;
61        Map<String, Integer> values;
62
63        Parser(String s, Map<String, Integer> values) {
64            this.s = s;
65            this.values = values;
66        }
67
68        Map<List<String>, Integer> parseExpression() {
69            Map<List<String>, Integer> result = parseTerm();
70
71            while (index < s.length()) {
72                skipSpaces();
73
74                if (index >= s.length() || s.charAt(index) == ')') {
75                    break;
76                }
77
78                char op = s.charAt(index++);
79                Map<List<String>, Integer> next = parseTerm();
80
81                if (op == '+') {
82                    result = add(result, next, 1);
83                } else {
84                    result = add(result, next, -1);
85                }
86            }
87
88            return result;
89        }
90
91        Map<List<String>, Integer> parseTerm() {
92            Map<List<String>, Integer> result = parseFactor();
93
94            while (index < s.length()) {
95                skipSpaces();
96
97                if (index >= s.length() ||
98                    s.charAt(index) == '+' ||
99                    s.charAt(index) == '-' ||
100                    s.charAt(index) == ')') {
101                    break;
102                }
103
104                if (s.charAt(index) == '*') {
105                    index++;
106                    Map<List<String>, Integer> next = parseFactor();
107                    result = multiply(result, next);
108                }
109            }
110
111            return result;
112        }
113
114        Map<List<String>, Integer> parseFactor() {
115            skipSpaces();
116
117            Map<List<String>, Integer> result = new HashMap<>();
118
119            if (s.charAt(index) == '(') {
120                index++;
121                result = parseExpression();
122                index++; // skip ')'
123            } else {
124                int start = index;
125
126                while (index < s.length() &&
127                        (Character.isLetterOrDigit(s.charAt(index)))) {
128                    index++;
129                }
130
131                String token = s.substring(start, index);
132
133                if (Character.isDigit(token.charAt(0))) {
134                    result.put(new ArrayList<>(), Integer.parseInt(token));
135                } else if (values.containsKey(token)) {
136                    result.put(new ArrayList<>(), values.get(token));
137                } else {
138                    List<String> variable = new ArrayList<>();
139                    variable.add(token);
140                    result.put(variable, 1);
141                }
142            }
143
144            return result;
145        }
146
147        void skipSpaces() {
148            while (index < s.length() && s.charAt(index) == ' ') {
149                index++;
150            }
151        }
152
153        Map<List<String>, Integer> add(
154                Map<List<String>, Integer> a,
155                Map<List<String>, Integer> b,
156                int sign) {
157
158            Map<List<String>, Integer> result = new HashMap<>(a);
159
160            for (Map.Entry<List<String>, Integer> entry : b.entrySet()) {
161                result.put(
162                    entry.getKey(),
163                    result.getOrDefault(entry.getKey(), 0)
164                            + sign * entry.getValue()
165                );
166            }
167
168            return result;
169        }
170
171        Map<List<String>, Integer> multiply(
172                Map<List<String>, Integer> a,
173                Map<List<String>, Integer> b) {
174
175            Map<List<String>, Integer> result = new HashMap<>();
176
177            for (Map.Entry<List<String>, Integer> x : a.entrySet()) {
178                for (Map.Entry<List<String>, Integer> y : b.entrySet()) {
179
180                    List<String> variables = new ArrayList<>(x.getKey());
181                    variables.addAll(y.getKey());
182
183                    Collections.sort(variables);
184
185                    int coefficient =
186                            x.getValue() * y.getValue();
187
188                    result.put(
189                        variables,
190                        result.getOrDefault(variables, 0)
191                                + coefficient
192                    );
193                }
194            }
195
196            return result;
197        }
198    }
199}