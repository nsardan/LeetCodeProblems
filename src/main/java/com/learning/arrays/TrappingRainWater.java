package com.learning.arrays;

public class TrappingRainWater {

    public int trap(int[] height) {
        if (height.length < 3) return 0;

        int ans = 0;
        int left = 0, right = height.length - 1;

        // find the left and right edge which can hold water
        //0,1,0,2,1,0,1,3,2,1,2,1
        while (left < right && height[left] <= height[left + 1]) left++;
        while (left < right && height[right] <= height[right - 1]) right--;

        while (left < right) {
            int min = height[left];
            int max = height[right];
            if (min <= max) {
                // add volum until an edge larger than the left edge
                while (left < right && min >= height[++left]) {
                    ans += min - height[left];
                    System.out.println(ans);
                }
            } else {
                // add volum until an edge larger than the right volum
                while (left < right && height[--right] <= max) {
                    ans += max - height[right];
                    System.out.println(ans);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        Integer ans = 6;
        TrappingRainWater main = new TrappingRainWater();
        System.out.println(ans.equals(main.trap(height)));
    }
}
