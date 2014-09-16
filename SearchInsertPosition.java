public class Solution {
    public int searchInsert(int[] A, int target) {
        if(A.length==0) return 0;
        int p = 0;
        int q = A.length-1;
        while(q>=p)
        {
            if(target<=A[p]) return p;
            if(target>A[q]) return q+1;
            int mid = (p+q)/2;
            if(A[mid]==target) return mid;
            else if(A[mid]>target) q=mid-1;
            else p=mid+1;

            //another way is
            // if(p==q) return A[p]>=target?p:p+1;
            // int mid = (p+q)/2;
            // if(A[mid]==target) return mid;
            // else if(A[mid]>target) q=mid;
            // else p=mid+1;
        }
        return 0;
    }
}
