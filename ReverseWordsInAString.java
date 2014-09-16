public class Solution {
    public String reverseWords(String s) {
        Deque<String> stack = new LinkedList<String>();
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while(i<=s.length())
        {
            char c = i==s.length()?' ':s.charAt(i);
            if(c==' ')
            {
                if(builder.length()!=0)
                {
                    stack.push(builder.toString());
                    builder = new StringBuilder();
                }
                i++;
                continue;
            }
            builder.append(c);
            i++;
        }
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty())
        {
            res.append(stack.pop());
            res.append(" ");
        }
        return res.length()==0?"":res.toString().substring(0,res.length()-1);
    }
}