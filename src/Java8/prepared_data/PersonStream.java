package Java8.prepared_data;

import java.util.List;
import java.util.Objects;

public class PersonStream {
    String first_name;
    String last_name;
    String profession;
    int age;
    List<Hobby> hobbies;


    public PersonStream(String first_name, String last_name, String profession, int age, List<Hobby> hobbies) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.profession = profession;
        this.age = age;
        this.hobbies = hobbies;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonStream user = (PersonStream) o;
        return age == user.age &&
            Objects.equals(first_name, user.first_name) &&
            Objects.equals(last_name, user.last_name) &&
            Objects.equals(profession, user.profession) &&
            Objects.equals(hobbies, user.hobbies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first_name, last_name, profession, age, hobbies);
    }
}
