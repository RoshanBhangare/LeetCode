class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int maxFactor = 0;
        for (int[] item : items) {
            if (item[0] > maxFactor) {
                maxFactor = item[0];
            }
        }

        int[] factorCount = new int[maxFactor + 1];
        for (int[] item : items) {
            factorCount[item[0]]++;
        }

        // bonus[f] = number of items j with factor[j] divisible by f (excluding one self-match if present)
        int[] bonus = new int[maxFactor + 1];
        for (int f = 1; f <= maxFactor; f++) {
            int totalMultiples = 0;
            for (int mult = f; mult <= maxFactor; mult += f) {
                totalMultiples += factorCount[mult];
            }
            if (factorCount[f] > 0) {
                bonus[f] = totalMultiples - 1;
            }
        }

        int[] dp = new int[budget + 1];

        for (int[] item : items) {
            int f = item[0];
            int price = item[1];
            if (price > budget) {
                continue;
            }

            // First copy of this item type: costs `price`, gives 1 + bonus[f] items
            for (int b = budget; b >= price; b--) {
                dp[b] = Math.max(dp[b], dp[b - price] + 1 + bonus[f]);
            }

            // Additional copies of this item type: each costs `price`, gives 1 item
            for (int b = price; b <= budget; b++) {
                dp[b] = Math.max(dp[b], dp[b - price] + 1);
            }
        }

        int ans = 0;
        for (int val : dp) {
            if (val > ans) {
                ans = val;
            }
        }
        return ans;
    }
}