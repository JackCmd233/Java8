package src.clone;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * 浅拷贝
 */
@Getter
@Setter
class ShallowCopy implements Cloneable {
    String name;
    int likes;
    List<String> numList;

    public static void main(String[] args) {

        // 创建对象
        ShallowCopy obj1 = new ShallowCopy();

        // 初始化变量
        obj1.name = "Runoob";
        obj1.likes = 111;
        ArrayList<String> listTemp = new ArrayList<>();
        listTemp.add("Temp1");
        obj1.numList = listTemp;

        // 打印输出
        System.out.println(obj1);
        System.out.println(obj1);

        try {

            // 创建 obj1 的拷贝
            ShallowCopy obj2 = (ShallowCopy) obj1.clone();

            System.out.println("============修改集合的值==========");
            listTemp.add("Temp2");

            System.out.println(obj2);
            System.out.println(obj2);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public ShallowCopy clone() {
        try {
            ShallowCopy clone = (ShallowCopy) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "ShallowCopy{" +
                "name='" + name + '\'' +
                ", likes=" + likes +
                ", numList=" + numList +
                '}';
    }
}