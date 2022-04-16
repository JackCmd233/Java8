package src.clone.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Teacher implements Cloneable {
    private String name;
    private int age;
    //保存学生学号
    private List<String> studentNumList;

    @Override
    public Object clone() throws CloneNotSupportedException {
        Teacher teacher = (Teacher) super.clone();

        List<String> temp = new ArrayList<>(studentNumList);
        teacher.setStudentNumList(temp);
        return teacher;
    }

}
