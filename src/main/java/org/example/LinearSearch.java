package org.example;

public class LinearSearch {

    //Basic linear Search through an array
    static <T> int linSearch(T [] arr, T elem){
        for(int i = 0; i < arr.length; i++){
            if(arr[i].equals(elem)){
                return i;
            }

        }
        return 0;

    }


}
