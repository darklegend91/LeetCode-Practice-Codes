class Solution {
    public int bestClosingTime(String cstmr) {

        int n = cstmr.length();
        int[] pre = new int[n + 1];
        int[] post = new int[n + 1];

        // Build prefix: count of 'N' before i
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1];
            if (cstmr.charAt(i - 1) == 'N') {
                pre[i]++;
            }
        }

        // Build suffix: count of 'Y' from i to end
        for (int i = n - 1; i >= 0; i--) {
            post[i] = post[i + 1];
            if (cstmr.charAt(i) == 'Y') {
                post[i]++;
            }
        }

        int minPen = Integer.MAX_VALUE;
        int ans = 0;

        // Find best closing hour
        for (int i = 0; i <= n; i++) {
            int totalPenalty = pre[i] + post[i];

            if (totalPenalty < minPen) {
                minPen = totalPenalty;
                ans = i;
            }
        }

        return ans;
    }
}
