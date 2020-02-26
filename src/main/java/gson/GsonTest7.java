package gson;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gson.schema.PersonSimple;
import gson.schema.PersonSimpleModifier;

import java.lang.reflect.Modifier;

/**
 * Tests with generic exclusion strategies.
 */

public class GsonTest7 {
    public static void main(String[] args) {
        GsonBuilder builder1 = new GsonBuilder();
        builder1.setExclusionStrategies(new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes fieldAttributes) {
                return fieldAttributes.getName().equalsIgnoreCase("email");
            }

            @Override
            public boolean shouldSkipClass(Class<?> aClass) {
                return aClass == int.class;
            }
        });
        Gson g1 = builder1.create();

        PersonSimple p1 = new PersonSimple("Alice", 18, "F", "alice@alice.com");
        System.out.println(g1.toJson(p1));
        // {"name":"Alice","gender":"F"}

        PersonSimple p2 = g1.fromJson("{\"name\":\"Bob\",\"age\":23,\"gender\":\"M\",\"email\":\"bob@bob.com\"}", PersonSimple.class);
        System.out.println(p2);
        // PersonSimple{name='Bob', age=0, gender='M', email='null'}

        GsonBuilder builder2 = new GsonBuilder();
        builder2.addSerializationExclusionStrategy(new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes fieldAttributes) {
                return fieldAttributes.getName().equalsIgnoreCase("gender");
            }

            @Override
            public boolean shouldSkipClass(Class<?> aClass) {
                return aClass == int.class;
            }
        });
        builder2.addDeserializationExclusionStrategy(new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes fieldAttributes) {
                return fieldAttributes.getName().equalsIgnoreCase("name");
            }

            @Override
            public boolean shouldSkipClass(Class<?> aClass) {
                return false;
            }
        });
        Gson g2 = builder2.create();

        System.out.println(g2.toJson(p1));
        // {"name":"Alice","email":"alice@alice.com"}

        PersonSimple p3 = g2.fromJson("{\"name\":\"Bob\",\"age\":23,\"gender\":\"M\",\"email\":\"bob@bob.com\"}", PersonSimple.class);
        System.out.println(p3);
        // PersonSimple{name='null', age=23, gender='M', email='bob@bob.com'}

        GsonBuilder builder3 = new GsonBuilder();
        builder3.excludeFieldsWithModifiers(Modifier.PUBLIC, Modifier.PROTECTED);
        // this will ignore transient as it is not added in the above modifier list
        Gson g3 = builder3.create();

        PersonSimpleModifier p4 = new PersonSimpleModifier("Alice", 18, "F", "alice@alice.com");
        System.out.println(g3.toJson(p4));
        // {"name":"Alice","email":"alice@alice.com"}

        PersonSimpleModifier p5 = g3.fromJson("{\"name\":\"Bob\",\"age\":23,\"gender\":\"M\",\"email\":\"bob@bob.com\"}", PersonSimpleModifier.class);
        System.out.println(p5);
        // PersonSimpleModifier{name='Bob', age=0, gender='null', email='bob@bob.com'}
    }
}
