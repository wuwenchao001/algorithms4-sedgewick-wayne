package com.chao.chapter1.session4;

import java.math.BigInteger;
import java.util.Arrays;

public class Exercise2_threeSum_overflow_bigInt {
    public static int threeSumCount(int[] arr) {
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            count += twoSumCount(arr, -arr[i], i + 1);
        }
        return count;
    }

    // this way is much more efficient than the three level for nesting
    private static int twoSumCount(int[] arr, int target, int startIdx) {
        int count = 0;
        int left = startIdx, right = arr.length - 1;
        while (left < right) {
            BigInteger sum = BigInteger.valueOf(arr[left]).add(BigInteger.valueOf(arr[right]));
            if (sum.compareTo(BigInteger.valueOf(target)) == 0) {
                count++;
                left++;
                right--;
            } else if (sum.compareTo(BigInteger.valueOf(target)) < 0) {
                left++;
            } else {
                right--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {-2147483647, -2, -1, -1, 0, 1, 2, 100, 2147483647}; // replace with your array
        System.out.println(threeSumCount(arr));

        main2();
    }




    public static int threeSumCount2(int[] arr) {
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            count += twoSumCount2(arr, -arr[i], i + 1);
        }
        return count;
    }

    private static int twoSumCount2(int[] arr, int target, int startIdx) {
        int count = 0;
        int left = startIdx, right = arr.length - 1;
        while (left < right) {
            BigInteger sum = BigInteger.valueOf(arr[left]).add(BigInteger.valueOf(arr[right]));
            if (sum.compareTo(BigInteger.valueOf(target)) == 0) {
                // Increase count for all pairs with same sum
                //
                // It seems the twoSumCount() is more simple to code
                // While here, save the time to calculate "sum" and "target" repeatedly
                int leftVal = arr[left], rightVal = arr[right];
                int leftCount = 0, rightCount = 0;
                // But, still, performance vary from input situations,
                // maybe these code within two while check won't be used,
                // when repeated numbers get more, it becomes useful.
                while (left < right && arr[left] == leftVal) {
                    left++;
                    leftCount++;
                }
                while (left <= right && arr[right] == rightVal) {
                    right--;
                    rightCount++;
                }
                count += leftCount * rightCount;
            } else if (sum.compareTo(BigInteger.valueOf(target)) < 0) {
                left++;
            } else {
                right--;
            }
        }
        return count;
    }

    public static void main2() {
        int[] arr = {2147483647, -2147483648, -1, 1}; // replace with your array
        System.out.println(threeSumCount2(arr));
    }

}

