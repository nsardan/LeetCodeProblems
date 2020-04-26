package com.learning.arrays.twodimensional;

import java.util.Arrays;

public class KthClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int K) {
        int row = points.length;
        int[] distanceArray = new int[row];
        int[][] finalAnswer = new int[K][2];

        for(int i = 0; i < row; i++){
            distanceArray[i] = calculateDistance(points[i]);
        }
        Arrays.sort(distanceArray);

        int maxDistance = distanceArray[K-1];
        int t = 0;
        for(int i = 0; i < row; i++){
            if (calculateDistance(points[i]) <= maxDistance)
                finalAnswer[t++] = points[i];
        }
        return finalAnswer;




    }

    public int calculateDistance(int[] rowPoints){
        return rowPoints[0]*rowPoints[0] + rowPoints[1]*rowPoints[1];
    }



    public static void main(String[] args) {
        int[][] points = {{6,10},{-3,3},{-2,5},{0,2}};
        int k = 3;
        //[[3,3],[-2,4]]
        //[[6,10],[-3,3],[-2,5],[0,2]]
        KthClosestPointsToOrigin main = new KthClosestPointsToOrigin();
        int[][] closestPoints = main.kClosest(points, k);

        for(int i = 0; i < closestPoints.length; i ++){
            for(int j = 0; j < closestPoints[0].length; j++){
                System.out.println(closestPoints[i][j]);
            }
        }
    }
}
