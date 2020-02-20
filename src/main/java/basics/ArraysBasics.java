package basics;

import java.util.Arrays;
import java.util.List;

public class ArraysBasics{

     public static void main(String []args){
        int[] arr = { 4, 2, 1 };
        System.out.println(Arrays.toString(arr)); // [4, 2, 1]
        int[] arr2 = new int[4];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i * 2;
        }
        System.out.println(Arrays.toString(arr2)); // [0, 2, 4, 6]
        
        List<Integer> list = Arrays.asList(0, 2, 4, 6);
        System.out.println(list); // [0, 2, 4, 6]
        System.out.println(Arrays.binarySearch(arr2, 2)); // 1
        System.out.println(Arrays.binarySearch(arr2, 3)); // -3
        // binarySearch returns index of the search key, if it is contained in the array
        // otherwise, (-(insertion point) - 1)
        // the insertion point is defined as the point at which the key would be inserted into the array
        System.out.println(Arrays.binarySearch(arr2, 0, 2, 2)); // 1
        System.out.println(Arrays.binarySearch(arr2, 0, 2, 4)); // -3
        // search in a range [from, to)
        
        int[] arr3 = new int[6];
        arr3[0] = 7; arr3[1] = 6; arr3[2] = 5;
        int[] arr4 = Arrays.copyOf(arr3, 3);
        System.out.println(Arrays.toString(arr3)); // [7, 6, 5, 0, 0, 0]
        System.out.println(Arrays.toString(arr4)); // [7, 6, 5]
        System.out.println(Arrays.toString(Arrays.copyOf(arr3, 2))); // [7, 6]
        System.out.println(Arrays.toString(Arrays.copyOf(arr3, 9))); // [7, 6, 5, 0, 0, 0, 0, 0, 0]
        arr4 = Arrays.copyOfRange(arr3, 1, 5);
        System.out.println(Arrays.toString(arr4)); // [6, 5, 0, 0]
        // copy from a range [from, to)
        
        System.out.println(Arrays.equals(arr, arr2)); // false
        int[] arr5 = { 7, 6, 5, 0, 0, 0 };
        System.out.println(Arrays.equals(arr3, arr5)); // true
        
        Arrays.fill(arr5, 3);
        System.out.println(Arrays.toString(arr5)); // [3, 3, 3, 3, 3, 3]
        Arrays.fill(arr5, 2, 5, 7);
        System.out.println(Arrays.toString(arr5)); // [3, 3, 7, 7, 7, 3]
        // fill to a range [from, to)
        
        Arrays.sort(arr5);
        System.out.println(Arrays.toString(arr5)); // [3, 3, 3, 7, 7, 7]
        arr5 = new int[] { 2, 6, 3, 9, 4, 7, 5 };
        Arrays.sort(arr5, 2, 5);
        // sort within a range [from, to)
        System.out.println(Arrays.toString(arr5)); // [2, 6, 3, 4, 9, 7, 5]
        Arrays.sort(arr5);
        System.out.println(Arrays.toString(arr5)); // [2, 3, 4, 5, 6, 7, 9]
        // to sort an primitive type array in reverse order, you can only sort it in ascending order and then manually reverse
        
        int[][] pairs = new int[][] { {2,2}, {3,1}, {1,3}, {2,4}, {5,2}, {1,1}, {3,4} };
        for (int[] pair : pairs) System.out.print(Arrays.toString(pair) + ", ");
        System.out.println();
        Arrays.sort(pairs, (a,b) -> (a[0]-b[0])); // ascending according to the first number
        for (int[] pair : pairs) System.out.print(Arrays.toString(pair) + ", ");
        System.out.println();
        Arrays.sort(pairs, (a,b) -> (b[0]-a[0])); // descending according to the first number
        for (int[] pair : pairs) System.out.print(Arrays.toString(pair) + ", ");
        System.out.println();
        Arrays.sort(pairs, (a,b) -> (b[0]==a[0] ? a[1]-b[1] : a[0]-b[0])); // strictly ascending
        for (int[] pair : pairs) System.out.print(Arrays.toString(pair) + ", ");
        System.out.println();
        Arrays.sort(pairs, (a,b) -> (b[0]==a[0] ? b[1]-a[1] : b[0]-a[0])); // strictly descending
        for (int[] pair : pairs) System.out.print(Arrays.toString(pair) + ", ");
        System.out.println();
     }
}

/*
java.lang.Object
    java.util.Arrays

public class Arrays
extends Object
*/