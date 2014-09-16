public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        StringBuilder builder = new StringBuilder();
        generate(res, builder, 0 ,0, n);
        return res;
    }
    
    public void generate(List<String> res, StringBuilder builder, int n1, int n2, int n)
    {
        if(n1==n&&n2==n)
        {
            res.add(builder.toString());
            return;
        }
        if(n1!=n)
        {
            StringBuilder newBuilder = new StringBuilder(builder);
            newBuilder.append("(");
            generate(res, newBuilder, n1+1, n2, n);
        }
        if(n2<n1)
        {
            StringBuilder newBuilder = new StringBuilder(builder);
            newBuilder.append(")");
            generate(res, newBuilder, n1, n2+1, n);
        }
    }
}