package java8.basics;

public interface InterfaceDefault {
    double calculate(int x);
    default double sqrt(int x) { return Math.sqrt(x); }
}
