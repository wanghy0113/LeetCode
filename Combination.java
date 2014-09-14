public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> sol = new ArrayList<Integer>();
        dsf(res, sol, 1,k,n);
        return res;
    }
    
    public void dsf(List<List<Integer>> res, List<Integer> sol, int index, int k, int n)
    {
        if(k==0)
        {
            res.add(sol);
            return;
        }
        for(int i=index;i<=n;i++)
        {
            List<Integer> list = new ArrayList<Integer>(sol);
            list.add(i);
            dsf(res, list, i+1, k-1, n);
        }
    }
}