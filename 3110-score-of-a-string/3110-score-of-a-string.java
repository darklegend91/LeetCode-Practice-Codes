class Solution {
    public int scoreOfString(String s) {
        int score = 0;

        char[] arr = s.toCharArray();

        for (int i = 0 ; i< arr.length -1; i++)
        {
            int ch1 = arr[i];
            int ch2 = arr[i+1];

            score += Math.abs(ch2-ch1);
        }

        return score;
    }
}