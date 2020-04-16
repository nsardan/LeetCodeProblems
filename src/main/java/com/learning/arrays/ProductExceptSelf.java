package com.learning.arrays;

public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        res[0] = 1;

        for(int i = 1; i< nums.length; i++){
            res[i] = res[i-1]*nums[i-1];
        }

        int right = nums[nums.length-1];
        for(int i = nums.length -2; i >=0 ; i--){
            res[i] = right*res[i];
            right = right*nums[i];
        }
        return res;

    }

    public static void main(String[] args) {
        ProductExceptSelf main = new ProductExceptSelf();
        int[] res = main.productExceptSelf(new int[]{1,2,3,4});
        for (int i : res) System.out.println(i);
    }

}
