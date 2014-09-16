public class Solution {
    int res = 0;
    public int totalNQueens(int n) {
        int[] loc = new int[n];
        dfs(loc, 0, n);
        return res;
    }
    
    public void dfs(int[] loc, int level, int n)
    {
        if(n==level)
        {
            res++;
            return;
        }
        for(int i=0;i<n;i++)
        {
            if(fit(loc, level, i))
            {
                loc[level] = i;
                dfs(loc, level+1, n);
            }
        }
    }
    
    public boolean fit(int[] loc, int level, int i)
    {
        for(int k=0;k<level;k++)
        {
            if(loc[k]==i||Math.abs(level-k)==Math.abs(loc[k]-i)) return false;
        }
        return true;
    }
    
}