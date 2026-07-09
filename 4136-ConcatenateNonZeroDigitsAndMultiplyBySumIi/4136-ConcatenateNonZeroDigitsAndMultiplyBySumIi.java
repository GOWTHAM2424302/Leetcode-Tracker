// Last updated: 7/9/2026, 3:00:45 PM
import java.util.*;

class Solution {
    static final long MOD = 1_000_000_007L;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        List<Integer> posList = new ArrayList<>();
        List<Integer> digitList = new ArrayList<>();

        long[] prefixSum = new long[n + 1];

        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';

            prefixSum[i + 1] = prefixSum[i];

            if (d != 0) {
                prefixSum[i + 1] += d;
                posList.add(i);
                digitList.add(d);
            }
        }

        int k = posList.size();

        int[] positions = new int[k];
        long[] hash = new long[k + 1];
        long[] pow10 = new long[k + 1];

        pow10[0] = 1;

        for (int i = 0; i < k; i++) {
            positions[i] = posList.get(i);
            pow10[i + 1] = (pow10[i] * 10) % MOD;
            hash[i + 1] = (hash[i] * 10 + digitList.get(i)) % MOD;
        }

        int[] answer = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {
            int l = queries[q][0];
            int r = queries[q][1];

            int left = lowerBound(positions, l);
            int right = upperBound(positions, r);

            if (left == right) {
                answer[q] = 0;
                continue;
            }

            int len = right - left;

            long x = (hash[right] -
                    hash[left] * pow10[len] % MOD + MOD) % MOD;

            long sum = prefixSum[r + 1] - prefixSum[l];

            answer[q] = (int)((x * (sum % MOD)) % MOD);
        }

        return answer;
    }

    private int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] >= target)
                r = mid;
            else
                l = mid + 1;
        }

        return l;
    }

    private int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] > target)
                r = mid;
            else
                l = mid + 1;
        }

        return l;
    }
}