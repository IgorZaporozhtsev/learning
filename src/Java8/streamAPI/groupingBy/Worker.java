package Java8.streamAPI.groupingBy;


import java.util.Objects;

public class Worker{
    private final String name;
    private final int age;
    private final int salary;
    private final String position;

    public Worker(String name, int age, int salary, String position) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return age == worker.age &&
            salary == worker.salary &&
            Objects.equals(name, worker.name) &&
            Objects.equals(position, worker.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, salary, position);
    }

    @Override
    public String toString() {
        return "Worker{" +
            "name='" + name + '\'' +
            ", age=" + age +
            ", salary=" + salary +
            ", position='" + position + '\'' +
            '}';
    }
}
