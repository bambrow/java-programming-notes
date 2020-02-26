package gson;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gson.schema.Person;

import java.lang.reflect.Field;

/**
 * Tests with FieldNamingPolicy and FieldNamingStrategy.
 */

public class GsonTest6 {
    public static void main(String[] args) {
        GsonBuilder builder1 = new GsonBuilder();
        builder1.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY);
        Gson g1 = builder1.create();

        Person p1 = new Person("Alice", "A", 22, "F", "a@a.com");
        System.out.println(g1.toJson(p1));
        // {"firstName":"Alice","lastName":"A","personAge":22,"personGender":"F","userEmail":"a@a.com"}

        GsonBuilder builder2 = new GsonBuilder();
        builder2.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        Gson g2 = builder2.create();

        System.out.println(g2.toJson(p1));
        // {"first_name":"Alice","last_name":"A","person_age":22,"person_gender":"F","user_email":"a@a.com"}

        GsonBuilder builder3 = new GsonBuilder();
        builder3.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES);
        Gson g3 = builder3.create();

        System.out.println(g3.toJson(p1));
        // {"first-name":"Alice","last-name":"A","person-age":22,"person-gender":"F","user-email":"a@a.com"}

        GsonBuilder builder4 = new GsonBuilder();
        builder4.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE);
        Gson g4 = builder4.create();

        System.out.println(g4.toJson(p1));
        // {"FirstName":"Alice","LastName":"A","PersonAge":22,"PersonGender":"F","UserEmail":"a@a.com"}

        GsonBuilder builder5 = new GsonBuilder();
        builder5.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE_WITH_SPACES);
        Gson g5 = builder5.create();

        System.out.println(g5.toJson(p1));
        // {"First Name":"Alice","Last Name":"A","Person Age":22,"Person Gender":"F","User Email":"a@a.com"}

        GsonBuilder builder6 = new GsonBuilder();
        builder6.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DOTS);
        Gson g6 = builder6.create();

        System.out.println(g6.toJson(p1));
        // {"first.name":"Alice","last.name":"A","person.age":22,"person.gender":"F","user.email":"a@a.com"}

        FieldNamingStrategy customStrategy = new FieldNamingStrategy() {
            @Override
            public String translateName(Field field) {
                return field.getName().toUpperCase();
            }
        };

        GsonBuilder builder7 = new GsonBuilder();
        builder7.setFieldNamingStrategy(customStrategy);
        Gson g7 = builder7.create();

        System.out.println(g7.toJson(p1));
        // {"FIRSTNAME":"Alice","LASTNAME":"A","PERSONAGE":22,"PERSONGENDER":"F","USEREMAIL":"a@a.com"}
    }
}
