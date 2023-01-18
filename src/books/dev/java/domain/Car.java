package books.dev.java.domain;

public record Car(Color color, Engine engine, Drive drive, int passengers) implements Vehicle{}
