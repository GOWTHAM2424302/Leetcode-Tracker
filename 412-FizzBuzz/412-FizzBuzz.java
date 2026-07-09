// Last updated: 7/9/2026, 3:01:57 PM
import java.util.*;

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            res.add(i % 15 == 0 ? "FizzBuzz" :
                    i % 3 == 0 ? "Fizz" :
                    i % 5 == 0 ? "Buzz" :
                    String.valueOf(i));
        return res;
    }
}