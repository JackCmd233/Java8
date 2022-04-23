package src.lambda;

public class innerClassTest {
    public static void main(String[] args) {
        //将抽象类Wrapper中的方法在大括号中实现了
        //这样便可以省略一个类的书写
        //并且，匿名内部类还能用于接口上
        Solution.executeFunc(new Wrapper() {
            @Override
            public void myPrint(String w) {
                System.out.println("内部类打印:" + w);
            }
        }, "TestInnerClass");

        // lambda写法
        Solution.executeFunc(w -> {
            // 个性化拓展，例如在打印之前记录时间什么的
            System.out.println(w);
        }, "TestLambda");



    }
}

/**
 * 实现打印功能
 */
class Solution {
    /**
     * 控制台打印
     *
     * @param w
     */
    static void executeFunc(Wrapper w, String word) {
        w.myPrint(word);
    }
}


interface Wrapper {
    void myPrint(String w);
}