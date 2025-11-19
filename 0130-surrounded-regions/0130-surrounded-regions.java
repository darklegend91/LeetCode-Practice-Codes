class Node
{
    int row , col;
    Node( int r , int c)
    {
        row = r;
        col =c;
    }
}


class Solution {
    int[][] directions = {
        {0,1},
        {-1,0},
        {1,0},
        {0,-1}
    };

    boolean isValid( int r , int c , int rows , int cols)
    {
        return (r >=0 && c>=0 && r< rows && c< cols);
    }

    public void solve(char[][] board) {
        int rows = board.length;
        if (rows ==0) return;
        int cols = board[0].length;

        Queue<int[]> q = new ArrayDeque<>();


        //Push all border O's to queue
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                q.offer(new int[]{i, 0});
            }
            if (board[i][cols - 1] == 'O') {
                q.offer(new int[]{i, cols - 1});
            }
        }

        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') {
                q.offer(new int[]{0, j});
            }
            if (board[rows - 1][j] == 'O') {
                q.offer(new int[]{rows - 1, j});
            }
        }

        //BfS for all border O's
        while (!q.isEmpty())
        {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            if (board[r][c] != 'O') continue;

            board[r][c] = 'T';

            for (int[] dir : directions)
            {
                int nr = r+ dir[0];
                int nc = c+ dir[1];

                if ( isValid(nr , nc , rows , cols) && board[nr][nc] == 'O')
                {
                    q.offer(new int[] {nr,nc});
                }
            }
        }

        //mark in the last
        for (int i = 0 ; i< rows; i++)
        {
            for (int j = 0 ; j< cols; j++)
            {
                if (board[i][j] == 'O')
                {
                    board[i][j] = 'X';
                }

                 if (board[i][j] == 'T')
                {
                    board[i][j] = 'O';
                }
            }
        }
    }
}