package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L322CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }

        List<Integer> coinsList = new ArrayList<>();
        for (int c : coins) {
            if (c <= amount) {
                coinsList.add(c);
            }
        }
        int validCoinValueCount = coinsList.size();
        if (validCoinValueCount == 0) {
            return -1;
        }
        Collections.sort(coinsList);
        // wtf
        if (coinsList.get(coinsList.size() - 1) == Integer.MAX_VALUE && amount == Integer.MAX_VALUE) {
            return 1;
        }

        if (coinsList.size() == 1) {
            if (amount % coinsList.get(0) == 0) {
                return amount / coinsList.get(0);
            }
            return -1;
        }

        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) dp[i] = Integer.MAX_VALUE - 1;
        for (int coin : coinsList)
            for (int i = coin; i <= amount; i++)
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
    }


}
