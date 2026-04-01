class Solution {
    public int[] productExceptSelf(int[] nums) {
     int[] arr1 = new int[nums.length+1];
     int[] arr2 = new int[nums.length+1];
     int [] result = new int[nums.length];

     arr1[0]=1;
     arr2[nums.length]=1;

     for(int i=1;i<=nums.length;i++){
        arr1[i]=nums[i-1]*arr1[i-1];
     }   

    for(int j=nums.length-1;j>=0;j--){
        arr2[j]=arr2[j+1]*nums[j];
        result[j] = arr2[j+1]*arr1[j];
    }

    return result;

    }
}  
