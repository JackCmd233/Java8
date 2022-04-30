package src.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReduceTest01 {
    public static void main(String[] args) {
        List<Person2> Person2List = new ArrayList<Person2>();
        Person2List.add(new Person2("Tom", 8900, 23, "male", "New York"));
        Person2List.add(new Person2("Jack", 7000, 25, "male", "Washington"));
        Person2List.add(new Person2("Lily", 7800, 21, "female", "Washington"));
        Person2List.add(new Person2("Anni", 8200, 24, "female", "New York"));
        Person2List.add(new Person2("Owen", 9500, 25, "male", "New York"));
        Person2List.add(new Person2("Alisa", 7900, 26, "female", "New York"));

        // 求工资之和方式1：
        Optional<Integer> sumSalary = Person2List.stream().map(Person2::getSalary).reduce(Integer::sum);
        // 求工资之和方式2：
        Integer sumSalary2 = Person2List.stream().reduce(0, (sum, p) -> sum += p.getSalary(),
                (sum1, sum2) -> sum1 + sum2);
        // 求工资之和方式3：
        Integer sumSalary3 = Person2List.stream().reduce(0, (sum, p) -> sum += p.getSalary(), Integer::sum);

        // 求最高工资方式1：
        Integer maxSalary = Person2List.stream().reduce(0, (max, p) -> max > p.getSalary() ? max : p.getSalary(),
                Integer::max);
        // 求最高工资方式2：
        Integer maxSalary2 = Person2List.stream().reduce(0,
                (max, p) -> max > p.getSalary() ? max : p.getSalary(),
                (max1, max2) -> max1 > max2 ? max1 : max2);

        // 三个参数
        Integer reduce = Person2List.stream().reduce(0,
                (max, p) -> {
                    /* 这段会执行*/
                    System.out.println("执行累加器");
                    return max > p.getSalary() ? max : p.getSalary();
                },
                (max1, max2) -> {
                    /* 不会执行的 */
                    System.out.println("combiner");
                    return max1;
                });

        System.out.println("工资之和：" + sumSalary.get() + "," + sumSalary2 + "," + sumSalary3);
        System.out.println("最高工资：" + maxSalary + "," + maxSalary2);
    }
}


class Person2 {
    private String name;  // 姓名
    private int salary; // 薪资
    private int age; // 年龄
    private String sex; //性别
    private String area;  // 地区

    // 构造方法
    public Person2(String name, int salary, int age, String sex, String area) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.sex = sex;
        this.area = area;
    }

    public Person2() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}