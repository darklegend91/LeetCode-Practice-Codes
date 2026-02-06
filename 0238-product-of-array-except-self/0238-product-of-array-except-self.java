class Solution {
    public int[] productExceptSelf(int[] nums) {
        int res[] = new int[nums.length];
        int zeroCount=0;
        int product =1;
        for (int x: nums)
        {
            if ( x== 0)
            {
                zeroCount++;
            }else
            {
            product *= x;
            }
        }

        for(int i = 0 ; i< nums.length; i++)
        {
            
                if (zeroCount >1)
                {
                    res[i] = 0;
                }
                else if ( zeroCount ==1)
                {
                    res[i] = (nums[i] ==0) ? product : 0;
                }
                else
                {
                    res[i] = product /nums[i];
                }
        }
    return res;
    }
}