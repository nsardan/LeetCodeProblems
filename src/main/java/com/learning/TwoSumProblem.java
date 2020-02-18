package com.learning;

public class TwoSumProblem {
    public static void main(String[] args) {
        int ans[] =twoSum(new int[]{1,4,2,3}, 3);
        System.out.println(ans[0]);
        System.out.println(ans[1]);


        //System.out.println(twoSum(new int[]{1,4,2,3}, 3)[1]);
    }

    public static int[] twoSum(int[] nums, int target) {

        int MOD = 2047;
        int arr[] = new int[2048];
        int len=nums.length;
        for(int i=0;i<len;i++)
        {
            int key = target - nums[i] & MOD;
            if(arr[key]!=0)
            {
                return new int[]{arr[key]-1,i};
            }
            arr[nums[i] & MOD]=i+1;
        }
        return null;
    }
}
