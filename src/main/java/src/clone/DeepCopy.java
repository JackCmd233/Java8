package src.clone;

import src.clone.entity.Student;
import src.clone.entity.Teacher;

import java.util.ArrayList;

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

