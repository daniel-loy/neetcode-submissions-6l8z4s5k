class Solution {
    int min = Integer.MAX_VALUE;
    public int swimInWater(int[][] grid) {
        PriorityQueue<List<Integer>> pr = new PriorityQueue<>((a,b)->grid[a.get(0)][a.get(1)] - grid[b.get(0)][b.get(1)]);
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(0);
        list.add(grid[0][0]);
        pr.add(list);
        while(!pr.isEmpty()){
            List<Integer> poped = pr.poll();
            int row = poped.get(0);
            int col = poped.get(1);
            int prevmin = poped.get(2);

            if(row==grid.length-1 && col == grid[0].length-1){
                return Math.max(grid[row][col],prevmin);
            }
            int[] rowoffset = {-1,0,1,0};
            int[] coloffset = {0,1,0,-1};

            for(int i=0;i<4;i++){
                int newrow = row+rowoffset[i];
                int newcol = col+coloffset[i];
                if(newrow<0 || newrow>=grid.length || newcol<0 || newcol>=grid[0].length || grid[newrow][newcol]==-1){
                    continue;
                }
                List<Integer> newlist = new ArrayList<>();
                newlist.add(newrow);
                newlist.add(newcol);
                newlist.add(Math.max(grid[newrow][newcol],prevmin));
                pr.add(newlist);  
                }
             grid[row][col]=-1;
    }

    return 0;

    }

 
}
