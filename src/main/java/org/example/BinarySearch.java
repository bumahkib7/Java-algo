package org.example;

public class BinarySearch {


    static <T extends Comparable<T>> int BinarySearched(T [] arr, T elem){
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while(low <= high){
            mid = (low + high) / 2;
            if(arr[mid].compareTo(elem) < 0){
                low = mid + 1;
            }else if(arr[mid].compareTo(elem) > 0){
                high = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
