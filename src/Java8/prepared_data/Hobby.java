package Java8.prepared_data;

import java.util.Objects;

public class Hobby {
    String name;
    int yearsSpent;
    HobbyType types;

    public Hobby(String name, int yearsSpent, HobbyType types) {
        this.name = name;
        this.yearsSpent = yearsSpent;
        this.types = types;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearsSpent() {
        return yearsSpent;
    }

    public void setYearsSpent(int yearsSpent) {
        this.yearsSpent = yearsSpent;
    }

    public HobbyType getTypes() {
        return types;
    }

    public void setTypes(HobbyType types) {
        this.types = types;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hobby hobby = (Hobby) o;
        return yearsSpent == hobby.yearsSpent &&
            Objects.equals(name, hobby.name) &&
            Objects.equals(types, hobby.types);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, yearsSpent, types);
    }
}
