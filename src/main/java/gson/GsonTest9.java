package gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gson.schema.PersonSimpleVersion;

/**
 * Tests version control and pretty printing.
 */

public class GsonTest9 {
    public static void main(String[] args) {
        Gson g1 = new Gson();
        PersonSimpleVersion p1 = new PersonSimpleVersion("Alice", 18, "F", "alice@alice.com");
        System.out.println(g1.toJson(p1));
        // {"name":"Alice","age":18,"gender":"F","email":"alice@alice.com"}

        Gson g2 = new GsonBuilder().setVersion(1.0).create();
        System.out.println(g2.toJson(p1));
        // {"name":"Alice","age":18}

        Gson g3 = new GsonBuilder().setVersion(1.1).create();
        System.out.println(g3.toJson(p1));
        // {"name":"Alice","gender":"F"}

        Gson g4 = new GsonBuilder().setVersion(1.2).create();
        System.out.println(g4.toJson(p1));
        // {"name":"Alice","email":"alice@alice.com"}

        Gson g5 = new GsonBuilder().setVersion(1.15).create();
        System.out.println(g5.toJson(p1));
        // {"name":"Alice","gender":"F"}

        Gson g6 = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(g6.toJson(p1));
        /*
        {
          "name": "Alice",
          "age": 18,
          "gender": "F",
          "email": "alice@alice.com"
        }
         */
    }
}
