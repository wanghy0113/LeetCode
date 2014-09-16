public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> last = new ArrayList<Integer>();
        int i = 1;
        while(i<=numRows)
        {
            if(i==1)
            {
                last.add(1);
                res.add(last);
            }
            else
            {
                List<Integer> list = new ArrayList<Integer>();
                list.add(1);
                for(int j=0;j<last.size()-1;j++)
                {
                    list.add(last.get(j)+last.get(j+1));
                }
                list.add(1);
                res.add(list);
                last = list;
            }
             i++;
        }
        return res;
    }
}