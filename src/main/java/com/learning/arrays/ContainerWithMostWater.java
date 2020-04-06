package com.learning.arrays;

public class ContainerWithMostWater {


    public int maxArea(int[] height) {
        if(height.length == 0) return 0;
        if(height.length == 1) return height[0];
        int max_area = 0;
        int left = 0;
        int right = height.length -1;
        while(left < right){
            //[1,8,6,2,5,4,8,3,7]
            int area = (right -left) * Math.min(height[left], height[right]);
            max_area = Math.max(max_area, area);
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }

        return max_area;

    }

    public static void main(String[] args) {
        ContainerWithMostWater main = new ContainerWithMostWater();
        System.out.println(main.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
