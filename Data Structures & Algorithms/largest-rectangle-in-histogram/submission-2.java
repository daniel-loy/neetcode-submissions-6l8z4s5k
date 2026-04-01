class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights.length==0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        stack.push(0);
        map.put(0,0);
        int max = 0;
        for(int i=1;i<heights.length;i++){
            if(heights[i-1]<heights[i]){
                stack.push(i);
                map.put(i,i);
            }
            else if(heights[i-1]==heights[i]){
                stack.push(i);
                map.put(i,map.get(i-1));
            }
            else{
                int newLeft = i;
                while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                    System.out.println(heights[stack.peek()]+" "+map.get(stack.peek()));
                    max=Math.max(max,(i-map.get(stack.peek()))*heights[stack.peek()]);
                    newLeft=map.get(stack.peek());
                    stack.pop();
                }
                stack.push(i);
                map.put(i,newLeft);                 
            }
        }
        while(!stack.isEmpty()){
            System.out.println(heights[stack.peek()]+" "+map.get(stack.peek()));
            max=Math.max(max,(heights.length-map.get(stack.peek()))*heights[stack.peek()]);
            stack.pop();
    }
    return max;
    }
}
// class Solution {
//     public int largestRectangleArea(int[] heights) {
//         if (heights.length == 0) {
//             return 0;
//         }

//         Stack<Integer> stack = new Stack<>();
//         HashMap<Integer, Integer> map = new HashMap<>();
//         stack.push(0);
//         map.put(0, 0);

//         int max = 0;

//         for (int i = 1; i < heights.length; i++) {
//             if (heights[i - 1] < heights[i]) {
//                 stack.push(i);
//                 map.put(i, i);
//             } else if (heights[i - 1] == heights[i]) {
//                 stack.push(i);
//                 map.put(i, map.get(i - 1)); // Inherit left boundary
//             } else {
//                 int newLeft = i;
                
//                 while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
//                     int top = stack.pop();
//                     int left = map.get(top);
//                     max = Math.max(max, (i - left) * heights[top]);
//                     newLeft = Math.min(newLeft, left);
//                 }
//                 stack.push(i);
//                 map.put(i, newLeft); // Assign correct left boundary after pops
//             }
//         }

//         while (!stack.isEmpty()) {
//             int top = stack.pop();
//             int left = map.get(top);
//             max = Math.max(max, (heights.length - left) * heights[top]);
//         }

//         return max;
//     }
// }

