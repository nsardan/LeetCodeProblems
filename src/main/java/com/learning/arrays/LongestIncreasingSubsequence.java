package com.learning.arrays;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int len = 1;
        if(nums.length == 0) return 0;
        if(1 == nums.length) return len;
        int[] tail_nums = new int[nums.length];
        tail_nums[0] = nums[0];
        for(int i = 1 ; i < nums.length; i++){
            int key = nums[i];
            if(key < tail_nums[0]){

                tail_nums[0] = key;
            }
            else if(key > tail_nums[len-1]){

                tail_nums[len++] = key;
            }
            else{
                tail_nums[ceilIndex(tail_nums, -1, len-1, key)] = key;
            }

        }
        return len;
    }

    private int ceilIndex(int[] tail_nums, int l, int r, int key) {
        while(r - l > 1){
            int mid = l + (r - l) / 2;
            if(tail_nums[mid] >= key){
                r = mid;
            }else{
                l = mid;
            }
        }
        return r;
    }


    public static void main(String[] args) {
        int[] nums = {4,10,4,3,8,9};
        LongestIncreasingSubsequence longest = new LongestIncreasingSubsequence();
        int anser = longest.lengthOfLIS(nums);
        System.out.println(anser);

    }
}
