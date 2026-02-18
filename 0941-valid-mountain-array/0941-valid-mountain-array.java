class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if (n < 3) return false;

        int breakpt = 0;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] >= arr[i + 1]) {
                breakpt = i;
                break;
            }
        }

        if (breakpt == 0 || breakpt == n - 1) return false;


        for (int i = breakpt; i < n - 1; i++) {
            if (arr[i] <= arr[i + 1]) {
                return false;
            }
        }

        return true;
    }
}
