package src.clone;

import src.clone.entity.DouBi;

import java.io.*;

/**
 * 使用序列化， 深拷贝对象
 */
public class DeepCopyWithSerializable implements Serializable {

    public static void main(String[] args) {
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
            // 创建原始的可序列化对象
            DouBi c1 = new DouBi(100, 100);
            System.out.println("原始的对象 = " + c1);
            DouBi c2 = null;
            // 通过序列化实现深拷贝
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            // 序列化以及传递这个对象
            oos.writeObject(c1);
            oos.flush();
            ByteArrayInputStream bin = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bin);
            // 返回新的对象
            c2 = (DouBi) ois.readObject();
            // 校验内容是否相同
            System.out.println("复制后的对象   = " + c2);
            // 改变原始对象的内容
            c1.setX(200);
            c1.setY(200);
            // 查看每一个现在的内容
            System.out.println("查看原始的对象 = " + c1);
            System.out.println("查看复制的对象 = " + c2);
        } catch (IOException e) {
            System.out.println("Exception in main = " + e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
