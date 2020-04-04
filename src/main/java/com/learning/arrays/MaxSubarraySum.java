package com.learning.arrays;

public class MaxSubarraySum {


    public int maxSubArray(int[] nums) {
        //divide and conqure
        int ans = maxSumArray(nums,0, nums.length-1);
        return ans;
    }

    public int maxSumArray(int[] nums, int left, int right){
        if(left == right) return nums[left];
        int mid = (left + right)/2;
        return Math.max(Math.max(maxSumArray(nums, left,mid), maxSumArray(nums, mid+1,right)),maxCrossingArray(nums,left,mid,right));
    }

    public int maxCrossingArray(int[] nums, int left, int mid, int right){
        int sum = 0;
        int left_sum = Integer.MIN_VALUE;

        for(int i = mid; i >= left; i--){
            sum = sum + nums[i];
            if(sum > left_sum){
                left_sum = sum;
            }
        }
        sum = 0;
        int right_sum = Integer.MIN_VALUE;
        for(int i = mid+1; i <= right; i++){
            sum = sum + nums[i];
            if(sum > right_sum) right_sum = sum;
        }

        return left_sum+right_sum;
    }

    public static void main(String[] args) {
        int question[] = {-2,1,-3,4,-1,2,1,-5,4};
        MaxSubarraySum main = new MaxSubarraySum();

        int ans =  main.maxSubArray(question);
        System.out.println(ans);
    }
}
