public class Solution {
    public int maxPoints(Point[] points) {
        int maxNumber = 0;
        if(points.length==0)
        {
            return maxNumber;
        }
        
        for(int i=0;i<points.length;i++)
        {
            int maxCurrent = 1;
            int same = 0;
            HashMap<Double,Integer> map = new HashMap<Double,Integer>(); 
            comehere:
            for(int j=i+1;j<points.length;j++)
            {
                if(points[i].x==points[j].x&&points[i].y==points[j].y)
                {
                    same++;
                    continue comehere;
                }
                double slope = getSlope(points[i],points[j]);
                if(!map.containsKey(slope))
                {
                   map.put(slope,1); 
                }
                int num = map.get(slope);
                if(num+1>maxCurrent)
                {
                    maxCurrent = num+1;
                }
                map.put(slope,num+1);
            }
            maxCurrent = maxCurrent + same;
            if(maxCurrent>maxNumber)
            {
                maxNumber = maxCurrent;
            }
        }
        return maxNumber;
        
    }
    
    public double getSlope(Point point1, Point point2)
    {
        if(point1.x==point2.x)
        {
            return Double.MAX_VALUE;
        }
        if(point1.y==point2.y)
        {
            return 0;
        }
        return (double)(point1.y-point2.y)/(double)(point1.x-point2.x);
    }
}