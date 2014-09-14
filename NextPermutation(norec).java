public class Solution {
    public void nextPermutation(int[] num) {
        if(num==null||num.length==0||num.length==1) return;
        int index = 0;
        for(int i=num.length-1;i>0;--i)
        {
            if(num[i-1]<num[i])
            {
                index = i-1;
                for(int j=index+1;j<num.length;j++)
                {
                    if(j==num.length-1||(num[j]>num[index]&&num[j+1]<=num[index]))
                    {
                        int temp = num[j];
                        num[j] = num[index];
                        num[index] = temp;
                        swap(num, index+1, num.length-1);
                        return;
                    }
                }
            }
        }
        swap(num, 0, num.length-1);
        return;
    }
    
    public void swap(int[] num, int p, int q)
    {
        if(q<=p) return;
        for(int i=p;i<=(p+q)/2;i++)
        {
            int temp = num[i];
            num[i] = num[q-i+p];
            num[q-i+p] = temp;
        }
    }
}