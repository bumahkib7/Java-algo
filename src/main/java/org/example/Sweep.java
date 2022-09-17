package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Sweep {
    /*
    explanation of Sweep algorithm:
    1. create a list of all the elements in the array
    2. create a list of all the elements in the array that satisfy the predicate
    3. create a list of all the elements in the array that do not satisfy the predicate
    4. add the elements that satisfy the predicate to the end of the list
    5. return the list

     */


    /*
    what is a predicate?
    A predicate is a function that takes in an element and returns true if the element satisfies the predicate and false if the element does not satisfy the predicate.
     */
    /*
    what is a consumer?
    A consumer is a function that takes in an element and returns nothing.
     */

    /*
    what is a biFunction?
    A biFunction is a function that takes in two elements and returns an element.
     */

    /*
    what is the sweep algorithm?
    The sweep algorithm is an algorithm that takes in an array, a predicate, and a consumer and returns an array.
     */

    /*
    what is the purpose of the sweep algorithm?
    The purpose of the sweep algorithm is to separate the elements in an array that satisfy a predicate from the elements that do not satisfy the predicate.

     */

    /*
    what is a function?
    A function is a mapping from one set to another set.
     */

    /*
    what is an Iterable?
    An Iterable is an object that can be iterated over.
     */
    public static <T> void sweep(Iterable<T> values, Predicate<T> ok, Consumer<T> action) {
        for (T t : values) if (ok.test(t)) action.accept(t);
    }

    public static <T, R> R sweepValue(Iterable<T> values, Predicate<T> ok, BiFunction<T, R, R> action) {
        R value = null;
        for (T t : values) if (ok.test(t)) value = action.apply(t, value);
        return value;
    }

    //create a sweepProgram
    public static <T,R> R SweepProgram(Iterable<T> values, Predicate<T> ok, BiFunction<T, R, R> action, R value) {
        List<T> list = new ArrayList<>();
        for (T t : values) if (ok.test(t)) value = action.apply(t, value);
        return value;
    }

    public static void test09() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
        Sweep.sweep(list, t -> t % 2 == 0, System.out::println);
        System.out.println();
        Sweep.sweep(list, Functions::isPrime, t -> System.out.println(t + " "));

    }

    public static void test10() {
        List<Integer> list1 = Arrays.asList(16, 4, 12, 21, 20, 15, 23, 64, 23);
        Integer t1 = Sweep.sweepValue(list1, t -> true, (a, b) ->
        {
            return b == null ? a : a < b ? a : b;
        });
        System.out.println(t1);

        Integer t2 = Sweep.sweepValue(list1, t -> true, (a, b) -> {
            return b == null ? a : b + a;
        });
        System.out.println(t2);
    }


    public static <T, R> List<R> sweepList(Iterable<T> values, Predicate<T> ok, Function<T, R> action) {
        List<R> list3 = new ArrayList<>();

        for (T t : values) if (ok.test(t)) list3.add(action.apply(t));

        return list3;
    }


    public static void test11() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

        List<Integer> list1 = Sweep.sweepList(list, Functions::isPrime, t -> t);

        Sweep.sweep(list, t -> t % 2 == 0, System.out::println);
        System.out.println();

        Sweep.sweep(list, Functions::isPrime, t -> System.out.println(t + " "));
        System.out.println();


    }


    public static void test12(){
        //print list on the screen in unordered way
        List<Integer> list = Arrays.asList(1, 22, 3, 59, 5, 6, 25, 8, 9, 35, 11, 12, 134, 14, 15, 16, 17, 153, 19, 20);
        //create and print a sublist between 30 and 50
        List<Integer> list1 = Sweep.sweepList(list, t -> t > 30 && t < 50, t -> t);
        System.out.println(list1);
        //print the lists mean value
        Integer t1 = Sweep.sweepValue(list, t -> true, (a, b) -> {
            return b == null ? a : b + a;
        });
        System.out.println(t1 / list.size());
        //print the theoretical standard deviation
        Integer t2 = Sweep.SweepProgram(list, t -> true, (a, b) -> {
            return b == null ? a : b + a;
        }, 0);

    }



    public static void main(String[] args) {
        test09();
        test10();
    }


}

class Functions {

    public static <T> boolean isPrime(T t) {
        int n = (int) t;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean isEven(T t) {
        int n = (int) t;
        return n % 2 == 0;
    }

    public static int crossSum(Long n) {
        while (n < 9) {
            n = n / 10 + n % 10;

        }
        return 0;
    }
}