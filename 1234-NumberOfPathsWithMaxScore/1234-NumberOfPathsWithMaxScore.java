// Last updated: 7/9/2026, 3:01:21 PM
class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int MOD = 1000000007;

        int[][] dp = new int[n][n];
        int[][] ways = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        dp[n - 1][n - 1] = 0;
        ways[n - 1][n - 1] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                char c = board.get(i).charAt(j);

                if (c == 'X' || (i == n - 1 && j == n - 1))
                    continue;

                int maxScore = -1;
                long count = 0;

                // From below
                if (i + 1 < n && dp[i + 1][j] != -1) {
                    if (dp[i + 1][j] > maxScore) {
                        maxScore = dp[i + 1][j];
                        count = ways[i + 1][j];
                    } else if (dp[i + 1][j] == maxScore) {
                        count = (count + ways[i + 1][j]) % MOD;
                    }
                }

                // From right
                if (j + 1 < n && dp[i][j + 1] != -1) {
                    if (dp[i][j + 1] > maxScore) {
                        maxScore = dp[i][j + 1];
                        count = ways[i][j + 1];
                    } else if (dp[i][j + 1] == maxScore) {
                        count = (count + ways[i][j + 1]) % MOD;
                    }
                }

                // From diagonal
                if (i + 1 < n && j + 1 < n && dp[i + 1][j + 1] != -1) {
                    if (dp[i + 1][j + 1] > maxScore) {
                        maxScore = dp[i + 1][j + 1];
                        count = ways[i + 1][j + 1];
                    } else if (dp[i + 1][j + 1] == maxScore) {
                        count = (count + ways[i + 1][j + 1]) % MOD;
                    }
                }

                if (maxScore == -1)
                    continue;

                if (c != 'E') {
                    maxScore += c - '0';
                }

                dp[i][j] = maxScore;
                ways[i][j] = (int) (count % MOD);
            }
        }

        if (ways[0][0] == 0)
            return new int[]{0, 0};

        return new int[]{dp[0][0], ways[0][0]};
    }
}
