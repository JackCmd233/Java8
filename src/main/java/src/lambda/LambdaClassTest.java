package src.lambda;

import java.util.function.BiConsumer;

public class LambdaClassTest {
    public static void main(String[] args) {
        //方法引用
        BiConsumer<Wrapper2, String> executeFunc = Solution2::executeFunc;
        //传入参数,并且执行
        executeFunc.accept((str) -> {
            System.out.println("使用Lambda表达式打印:" + str);
        }, "TestLambda"); 
    }
}

class Solution2 {
    public static void executeFunc(Wrapper2 w, String word) {
        w.myPrint(word);
    }

}

interface Wrapper2 {
    void myPrint(String w);
}











