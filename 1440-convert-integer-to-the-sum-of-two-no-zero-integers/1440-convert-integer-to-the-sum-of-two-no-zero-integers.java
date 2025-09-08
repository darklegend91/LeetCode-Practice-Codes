class Solution {
    public int[] getNoZeroIntegers(int n) {
        int ans[] = new int[2];
        int left = 1;
        int right = n-1;
        while (left <= right)
        {
            if ( (check(left) == true) && (check(right) == true))
            {
                ans[0] = left;
                ans[1]= right;
                return ans;
            }
            else
            {
                left++;
                right--;
            }
        }
        return ans;
    }

    public boolean check(int num)
    {
        int digit = 1;
        while(num > 0)
        {
            digit = num%10;
            num = num/10;
        if (digit==0)
        {
            return false;
        }
        }
        return true;
        
    }  
}