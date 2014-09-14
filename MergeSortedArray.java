public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        for(int i=m-1;i>=0;i--)
        {
            A[i+n] = A[i];
        }
        int i = n;
        int j = 0;
        int k = 0;
        while(k<m+n)
        {
            if(i==m+n)
            {
                A[k++] = B[j++];
                continue;
            }
            if(j==n)
            {
                A[k++] = A[i++];
                continue;
            }
            if(A[i]<B[j]) A[k++]=A[i++];
            else A[k++]=B[j++];
        }
    }
}