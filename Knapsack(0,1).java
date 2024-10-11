class Knapsack {

    static int getMaxValue(int capacity, int weights[], int values[], int itemCount) {
        int[][] dp = new int[itemCount + 1][capacity + 1];

        for (int i = 0; i <= itemCount; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0)
                    dp[i][w] = 0;
                else if (weights[i - 1] <= w)
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }
        return dp[itemCount][capacity];
    }

    public static void main(String args[]) {
        int values[] = new int[] { 60, 100, 120 };
        int weights[] = new int[] { 10, 20, 30 };
        int capacity = 50;
        int itemCount = values.length;
        System.out.println(getMaxValue(capacity, weights, values, itemCount));
    }
}
