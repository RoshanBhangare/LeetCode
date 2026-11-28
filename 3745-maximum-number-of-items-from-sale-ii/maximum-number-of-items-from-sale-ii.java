import java.util.*;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int mx = 0;
        for (int[] it : items) mx = Math.max(mx, it[0]);

        int[] cnt = new int[mx + 1];
        for (int[] it : items) cnt[it[0]]++;

        // mult[f] = number of items whose factor is a multiple of f
        int[] mult = new int[mx + 1];
        for (int f = 1; f <= mx; f++) {
            int s = 0;
            for (int k = f; k <= mx; k += f) s += cnt[k];
            mult[f] = s;
        }

        long m = Long.MAX_VALUE;
        for (int[] it : items) m = Math.min(m, it[1]);

        // {price, number of double-value units}
        List<long[]> units = new ArrayList<>();
        for (int[] it : items) {
            int d = mult[it[0]] - 1;          // excludes the item itself
            if (d > 0 && it[1] < 2 * m) {
                units.add(new long[]{it[1], d});
            }
        }
        units.sort((a, b) -> Long.compare(a[0], b[0]));

        long res = 0, rem = budget;
        for (long[] u : units) {
            long take = Math.min(u[1], rem / u[0]);
            res += 2 * take;
            rem -= take * u[0];
            if (take < u[1]) break;
        }

        return (int) (res + rem / m);
    }
}