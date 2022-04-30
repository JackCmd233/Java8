package src.stream;

import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class ReduceTest02 {
    public static void main(String[] args) {
        /*ArrayList<Integer> accResult = Stream.of(1, 3, 5, 7)
                .reduce(new ArrayList<>(),
                        new BiFunction<ArrayList<Integer>, Integer, ArrayList<Integer>>() {
                            @Override
                            public ArrayList<Integer> apply(ArrayList<Integer> sum, Integer item) {
                                System.out.println("item= " + item + "   sum=" + sum);
                                sum.add(item);
                                System.out.println("sum =" + sum);
                                System.out.println("这是 BiFunction");
                                return sum;
                            }
                        },
                        new BinaryOperator<ArrayList<Integer>>() {
                            @Override
                            public ArrayList<Integer> apply(ArrayList<Integer> sum2,
                                                            ArrayList<Integer> integers2) {
                                sum2.addAll(integers2);
                                System.out.println("sum2: " + sum2);
                                System.out.println("integers2: " + integers2);
                                System.out.println("这是 BinaryOperator");
                                return sum2;
                            }
                        });
        System.out.println("accResult: " + accResult);*/

        ArrayList<Integer> accResult = Stream.of(1, 3, 5, 7).parallel()
                .reduce(new ArrayList<>(),
                        new BiFunction<ArrayList<Integer>, Integer, ArrayList<Integer>>() {
                            @Override
                            public ArrayList<Integer> apply(ArrayList<Integer> integers, Integer item) {
                                integers.add(item);
                                return integers;
                            }
                        }, new BinaryOperator<ArrayList<Integer>>() {
                            @Override
                            public ArrayList<Integer> apply(ArrayList<Integer> integers,
                                                            ArrayList<Integer> integers2) {
                                integers.addAll(integers2);
                                System.out.println("thread name=" + Thread.currentThread().getName() + " ==== integers=" + integers);
                                System.out.println("integers2: " + integers2);
                                System.out.println("In BinaryOperator");
                                return integers;
                            }
                        });
        //打印结果几乎每次都不同
        System.out.println("accResult: " + accResult);
    }
}
