class Solution {
    public boolean lemonadeChange(int[] bills) {
        
        // Variable defination
        int five = 0;
        int ten = 0;
        int twenty = 0;


        // logic

        for (int x : bills)
        {
            // Bill is of 5 value
            if (x == 5)
            {
                five++;
            }
            // Bill is of ten value
            else if ( x== 10)
            {
                if (five != 0)
                {
                    five--;
                    ten++;
                }else
                {
                    return false;
                }
            }
            //Bill is of twenty value
            else if (x==20)
            {
                if (five != 0 && ten!= 0)
                {
                    five--;
                    ten--;
                    twenty++;
                }else if (five >=3)
                {
                    five = five -3;
                    twenty++;
                }else
                {
                    return false;
                }
            }
        }

        return true;
    }
}