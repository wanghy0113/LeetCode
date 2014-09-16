public void solve(char[][] board) {
        int m = board.length;
        if(m==0) return;
        int n = board[0].length;
        if(n==0) return;
        
        for(int i=0;i<n;i++)
        {
            if(board[0][i]=='O') dsf(board, 0, i);
            if(board[m-1][i]=='O') dsf(board, m-1, i);
        }
        for(int i=1;i<m-1;i++)
        {
            if(board[i][0]=='O') dsf(board, i, 0);
            if(board[i][n-1]=='O') dsf(board,i,n-1);
        }
        convert(board, m, n);
    }
    
    public void dsf(char[][] board, int x, int y)
    {
        board[x][y] = '+';
        if(x>1&&board[x-1][y]=='O') dsf(board, x-1, y);
        if(x<board.length-2&&board[x+1][y]=='O') dsf(board, x+1, y);
        if(y>1&&board[x][y-1]=='O') dsf(board, x, y-1);
        if(y<board[0].length-2&&board[x][y+1]=='O') dsf(board, x, y+1);
    }
    
    public void convert(char[][] board, int m, int n)
    {
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]=='O') board[i][j]='X';
                else if(board[i][j]=='+') board[i][j]='O';
            }
        }
    }