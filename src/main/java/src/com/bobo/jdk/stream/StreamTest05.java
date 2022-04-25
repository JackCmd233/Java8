package src.com.bobo.jdk.stream;

import java.util.Arrays;

public class StreamTest05 {

    public static void main(String[] args) {
        String[] strArray1 = new String[]{"a", "b", "c", "d"};
        Arrays.stream(strArray1).forEach(System.out::println);


        System.out.println("===================");

        int[] intArray1 = new int[]{1, 2, 3, 4};
        Arrays.stream(intArray1).forEach(System.out::println);




//        String[] arr1 = {"aa", "bb", "cc"};
//        Stream<String> arr11 = Stream.of(arr1);
//        Integer[] arr2 = {1, 2, 3, 4};
//        Stream<Integer> arr21 = Stream.of(arr2);
//        //arr21.forEach(System.out::println);
//        // 注意：基本数据类型的数组是不行的
//        int[] arr3 = {1, 2, 3, 4};
//        Stream.of(arr3).forEach(System.out::println);
//
//
//        System.out.println("========================");

/*        String[] str = {"a", "b", "c"};
        Arrays.stream(str).forEach(System.out::println);// 逐行打出 "a" "b" "c"

        int[] number = {1, 2, 3};
        Arrays.stream(number).forEach(System.out::println);// 逐行打出 1 2 3

        double[] doubles = {1.1, 2.2, 3.3}; //逐行打出 1.1  2.2   3.3
        Arrays.stream(doubles).forEach(System.out::println);*/


//        String[] str = {"a", "b", "c"};
//        Stream.of(str).forEach(System.out::println);// 逐行打出 "a" "b" "c"
//
//        int[] number = {1, 2, 3};
//        // 这里打出的是数组指针，其实内容是只含有一个整体的[1,2,3]数组流
//        Stream.of(number).forEach(System.out::println);
//
//        // 当然我们可以把它继续展开成我们想要的数组流, 这样就会逐行打出 1 2 3 啦
//        Stream.of(number).flatMapToInt(Arrays::stream).forEach(System.out::println);
    }
}
