package src.clone.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Cloneable {
    private String name;
    private int age;
    private Teacher teacher;

    @Override
    public Object clone() throws CloneNotSupportedException {

        // 改为深拷贝
        Student result = (Student) super.clone();//在内存中 新增了一个 保存的引用地址 (在这一步 浅拷贝 还是用的原对象的地址)
        //因为引用了Teacher类， 所以Teacher类必须实现深拷贝（创建一个全新的内存空间，并且值和原来的对象保持一致）
        result.setTeacher((Teacher) result.getTeacher().clone());
        return result;
    }
}
