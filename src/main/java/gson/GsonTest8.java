package gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gson.schema.PersonWeight;

/**
 * Tests with special float/double values that are not permitted by JSON.
 */

public class GsonTest8 {
    public static void main(String[] args) {
        PersonWeight p1 = new PersonWeight("David", Float.POSITIVE_INFINITY);
        Gson g1 = new Gson();
        try {
            System.out.println(g1.toJson(p1));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        // Infinity is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.

        GsonBuilder builder = new GsonBuilder();
        builder.serializeSpecialFloatingPointValues();
        Gson g2 = builder.create();
        System.out.println(g2.toJson(p1));
        // {"name":"David","weight":Infinity}

        PersonWeight p2 = new PersonWeight("David", Float.NEGATIVE_INFINITY);
        System.out.println(g2.toJson(p2));
        // {"name":"David","weight":-Infinity}

        PersonWeight p3 = new PersonWeight("David", Float.NaN);
        System.out.println(g2.toJson(p3));
        // {"name":"David","weight":NaN}
    }
}
