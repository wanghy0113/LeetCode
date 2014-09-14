public class Solution {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        int[] loc = new int[num.length];
        List<Integer> sol = new ArrayList<Integer>();
        dsf(res, sol, num, loc, 0);
        return res;
        
    }
    
    public void dsf(List<List<Integer>> res, List<Integer> sol, int[] num, int[] loc, int level)
    {
        if(level==num.length)
        {
            res.add(sol);
            return;
        }
        for(int i=0;i<num.length;i++)
        {
            if(loc[i]==0)
            {
                loc[i] = 1;
                List<Integer> list = new ArrayList<Integer>(sol);
                list.add(num[i]);
                dsf(res, list, num, loc, level+1);
                loc[i] = 0;
            }
        }
    }
}