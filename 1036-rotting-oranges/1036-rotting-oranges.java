class Node
{
    int row;
    int col;
    int time;

    Node(int r , int c , int t)
    {
        row = r;
        col = c;
        time = t;
    }
}

class Solution {

    //Direction Matrix
    int [][] directions =
        {
            {0,1},
            {1,0},
            {0,-1},
            {-1,-0}
        };

    //Invalid Function
    public boolean isValid(int i , int j ,int rows ,int cols)
    {
        return (i>= 0 && j>=0 && i< rows && j< cols);
    }

    //Main solution function
    public int orangesRotting(int[][] grid) {
        int time = 0;
        int fresh = 0;

        Queue<Node>  q =  new ArrayDeque<>();
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0 ; i<rows ; i++)
        {
            for (int j = 0 ; j< cols;j++)
            {
                if (grid[i][j]==2)
                {
                    q.offer(new Node(i , j , 0));
                } 
                else if (grid[i][j]==1)
                {
                    fresh++;
                }
            }
        }
        
        //Minimum time declared
        int min_time = 0;

        //
        while(!q.isEmpty())
        {
           Node curr = q.poll();
           for (int[]dir : directions)
           {
                int new_row = curr.row+ dir[0];
                int new_col = curr.col+ dir[1];

                if (isValid(new_row , new_col , rows , cols) && grid[new_row][new_col] ==1)
                {
                    //Rot the orange
                    grid[new_row][new_col] =2;
                    q.offer(new Node(new_row , new_col , curr.time+1));
                    min_time = curr.time+1;
                    fresh-=1;
                }
           } 
        }
        return (fresh == 0) ? min_time :-1; //last return when all orange are rotten

    }
}