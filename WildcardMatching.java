//this is a typical backtrack problem
public class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;
        int start = -1;
        int point = -1;
        while(i!=s.length())
        {
            // if(j==p.length())
            // {
            //     if(star!=-1)
            //     {
            //         j=star+1;
            //         i = ++point;
            //         continue;
            //     }
            // }
            //to reduce lines, we first handle when j<p.length(), then if all possiblities don't satisfy, 
            //we return false
            if(j<p.length())
            {
                char sc = s.charAt(i);
                char pc = p.charAt(j);
                if(pc=='?'||pc==sc)
                {
                    i++;
                    j++;
                    continue;
                }
                if(pc=='*')
                {
                    start =j++;
                    point = i;
                    continue;
                }
            }
            if(start!=-1)
            {
                j = start+1;
                i=++point;
                continue;
            }
            return false;
        }
        while(j!=p.length()&&p.charAt(j)=='*') j++;
        return j==p.length();
    }
}