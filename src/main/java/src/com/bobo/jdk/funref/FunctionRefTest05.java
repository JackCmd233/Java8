package src.com.bobo.jdk.funref;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionRefTest05 {

    public static void main(String[] args) {
        Function<String, Integer> function = (s) -> {
            return s.length();
        };
        System.out.println(function.apply("hello"));

        // 通过方法引用来实现
        Function<String, Integer> function1 = String::length;
        System.out.println(function1.apply("hahahaha"));

        BiFunction<String, Integer, String> function3 = String::substring;
        //Function<String,Integer> function2 = String::substring;

        Function<String, Integer> function2 = String::length;
        function2.apply("HelloWorld");
        //System.out.println(msg);

        System.out.println("");
    }
}
