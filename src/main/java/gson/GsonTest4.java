package gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gson.schema.PersonSimple;

/**
 * Tests with null values.
 */

public class GsonTest4 {
    public static void main(String[] args) {
        Gson g1 = new Gson();
        PersonSimple p1 = new PersonSimple("Alice", 18, "F", null);
        System.out.println(g1.toJson(p1));
        // {"name":"Alice","age":18,"gender":"F"}

        PersonSimple p2 = g1.fromJson("{\"name\":\"Bob\",\"age\":23,\"gender\":\"M\"}", PersonSimple.class);
        System.out.println(p2);
        // PersonSimple{name='Bob', age=23, gender='M', email='null'}

        PersonSimple p3 = g1.fromJson("{\"name\":\"Cathy\"}", PersonSimple.class);
        System.out.println(p3);
        // PersonSimple{name='Cathy', age=0, gender='null', email='null'}

        GsonBuilder builder = new GsonBuilder();
        builder.serializeNulls();
        Gson g2 = builder.create();

        System.out.println(g2.toJson(p1));
        // {"name":"Alice","age":18,"gender":"F","email":null}
    }
}
