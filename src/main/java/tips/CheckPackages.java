package tips;

import java.util.Arrays;

public class CheckPackages {
    public static void main(String[] args) {
        Package[] packs = Package.getPackages();
        Arrays.stream(packs).forEach(System.out::println);
    }
}
