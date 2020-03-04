package java8.lambda;

@FunctionalInterface
public interface ConverterDemo<F, T> {
    T convert (F from);
}
