class Solution {
    public int captureForts(int[] forts) {

        int n = forts.length;
        int ans = 0;

        for (int left = 0; left < n; left++) {

            if (forts[left] == 1 || forts[left] == -1) {

                int count = 0;

                for (int j = left + 1; j < n; j++) {

                    if (forts[j] == 0) {
                        count++;
                    }
                    else {
                        if (forts[j] != forts[left]) {
                            ans = Math.max(ans, count);
                        }
                        break;
                    }
                }
            }
        }

        return ans;
    }
}