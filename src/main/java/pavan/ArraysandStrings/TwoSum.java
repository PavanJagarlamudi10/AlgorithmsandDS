package src.main.java.pavan.ArraysandStrings;
//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

//You may assume that each input would have exactly one solution, and you may not use the same element twice.

//You can return the answer in any order.

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    
    public static void main(String[] args) {
        int[] input = {9, 3, 4, 5 , 7};
        int target = 8;
        int[] result = findIndices(input, target);
        int[] optResult = findIndicesOptimized(input, target);
        System.out.println(result[0] + " " + result[1]);
        System.out.println(optResult[0] + " " + optResult[1]);
    }

    // T: O(n^2) | Space: O(1)
    private static int[] findIndices(int[] input, int target) {
        for(int i=0; i<input.length; i++) {
            for(int j=i+1; j<input.length; j++)
                if(input[i] + input[j] == target) {
                    return new int[] {i, j};
                }
        }
        return new int[] {-1, -1};
    }

    // Better approach - Time: O(n), Space: O(n)
    private static int[] findIndicesOptimized(int[] input, int target) {
        Map<Integer, Integer> map = new HashMap<Integer ,Integer>();
        for(int i=0; i<input.length; i++) {
            int complement = target - input[i];
            if(map.containsKey(complement))
                return new int[] {map.get(complement), i};
            else
                map.put(input[i], i); // not found push the value and index
        }
        return new int[] {-1, -1};
    }
}