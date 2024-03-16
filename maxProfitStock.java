public class maxProfitStock {
    public static int profit(int[] prices) {
        if (prices.length == 0 || prices.length < 2) {
            return 0;
        }
        int min = prices[0];
        int maxPro = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                int currPro = prices[i] - min;
                maxPro = Math.max(maxPro, currPro);
            }
        }
        return maxPro;
    }

    public static void main(String args[]) {
        int[] prices = { 2, 4, 1 };
        System.out.println(profit(prices));

    }
}
