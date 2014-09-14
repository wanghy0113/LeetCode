public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(S);
        List<Integer> sol = new ArrayList<Integer>();
        res.add(sol);
        dsf(res, sol, S, 0,0);
        return res;
    }
    
    public void dsf(List<List<Integer>> res, List<Integer> sol, int[] S,int index, int level)
    {
        if(level<S.length)
        {
            for(int i=index;i<S.length;i++)
            {
                List<Integer> newSol = new ArrayList<Integer>(sol);
                newSol.add(S[i]);
                res.add(newSol);
                dsf(res, newSol, S, i+1, level+1);
            }
        }
    }
}