class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals == null || newInterval == null) return new int[][]{};

        int x = newInterval[0];
        int y = newInterval[1];
        boolean flag = false;

        List<int[]> list = new ArrayList<>();
        for(int[] interval : intervals){
            int a = interval[0];
            int b = interval[1];

            if(b<x){
                list.add(interval);
            }else if(y<a){
                
                if(!flag){
                    list.add(new int[]{x,y});
                    flag = true;
                }
                list.add(interval);
            }else{
                x = Math.min(x, a);
                y = Math.max(y, b);
            }
        }

        if(!flag) list.add(new int[]{x,y});
        return list.toArray(new int[list.size()][]);
    }
}
/*



[1 2] [3   5]     [8   10]   
         4           9]
[1 2] [3               10]


*/