class Solution {
    public int coinChange(int[] coins, int amount) {

        // dp[i] = minimum coins needed to make amount i
        int[] dp = new int[amount + 1];

        // Initially, assume every amount is impossible
        // amount + 1 acts like infinity
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
        }

        dp[0] = 0;

        // Calculate minimum coins for every amount
        for (int i = 1; i <= amount; i++) {

            for (int coin : coins) {

                if (coin <= i) {
                    dp[i] = Math.min(dp[i],
                                     dp[i - coin] + 1);
                }
            }
        }

        // If amount is still impossible
        if (dp[amount] == amount + 1) {
            return -1;
        }

        return dp[amount];
    }
}