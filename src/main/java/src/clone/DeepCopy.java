package src.clone;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * 深拷贝
 */
public class DeepCopy {
    public static void main(String[] args) throws Exception {
        Teacher teacher = new Teacher();
        teacher.setName("Delacey");
        teacher.setAge(29);

        ArrayList<String> numList = new ArrayList<>();
        numList.add("A01");
        numList.add("B01");
        teacher.setStudentNumList(numList);

        //原对象
        Student student1 = new Student();
        student1.setName("Dream");
        student1.setAge(18);
        student1.setTeacher(teacher);

        //拷贝之后的新对象
        Student student2 = (Student) student1.clone();
        System.out.println("拷贝后");
        System.out.println(student2.getName());
        System.out.println(student2.getAge());

        System.out.println(student2.getTeacher().getName());
        System.out.println(student2.getTeacher().getAge());
        System.out.println(student2.getTeacher().getStudentNumList());


        System.out.println("修改老师的信息后-------------");

        // 修改老师的信息
        teacher.setName("Jam");
        numList.add("C03");

        System.out.println("修改之前: " + student1.getTeacher().getStudentNumList());
        System.out.println("修改之前: " + student1.getTeacher().getName());

        System.out.println("修改之后: " + student2.getTeacher().getStudentNumList());
        System.out.println("修改之后: " + student2.getTeacher().getName());
    }
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class Teacher implements Cloneable {
    private String name;
    private int age;
    //保存学生学号
    private List<String> studentNumList;

    @Override
    public Object clone() throws CloneNotSupportedException {
        Teacher teacher = (Teacher) super.clone();

        List<String> studentNumList = teacher.getStudentNumList();
        List<String> temp = new ArrayList<>(studentNumList);
        teacher.setStudentNumList(temp);
        return teacher;
    }

}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class Student implements Cloneable {
    private String name;
    private int age;
    private Teacher teacher;

    @Override
    public Object clone() throws CloneNotSupportedException {
        // 浅复制时：
        // Object object = super.clone();
        // return object;

        //super.clone(); 是一个浅拷贝
        // (本质调用的是object.clone())

        // 改为深复制：
        Student result = (Student) super.clone(); //在内存中 新增了一个 保存的引用地址 (在这一步: 还是用的原对象的地址)
        //
        result.setTeacher((Teacher) result.getTeacher().clone());
        return result;
    }

}

