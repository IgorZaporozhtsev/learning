package cources.stepic.base.GCS.Post_2;

public class Salary implements Sendable <Integer>{
    String from;
    String to;
    Integer salary;

      public Salary(String from, String to, Integer salary) {
        this.from = from;
        this.to = to;
        this.salary = salary;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public Integer getContent() {
        return salary;
    }

    public Salary(String from, String to, int salary) {

        this.from = from;
        this.to = to;
        this.salary = salary;
    }
}
