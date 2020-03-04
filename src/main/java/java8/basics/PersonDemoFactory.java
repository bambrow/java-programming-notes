package java8.basics;

public interface PersonDemoFactory<P extends PersonDemo> {
    P create(String name, int age);
}
