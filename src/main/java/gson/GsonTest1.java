package gson;

import com.google.gson.Gson;
import gson.schema.Address;
import gson.schema.PersonSimple;
import gson.schema.PersonWithAddress;

/**
 * Tests for class and nested class.
 */

public class GsonTest1 {
    public static void main(String[] args) {
        Gson gson = new Gson();
        PersonSimple p1 = new PersonSimple("Alice", 18, "F", "alice@alice.com");
        System.out.println(gson.toJson(p1));
        // {"name":"Alice","age":18,"gender":"F","email":"alice@alice.com"}

        PersonSimple p2 = gson.fromJson("{\"name\":\"Bob\",\"age\":23,\"gender\":\"M\",\"email\":\"bob@bob.com\"}", PersonSimple.class);
        System.out.println(p2.toString());
        // PersonSimple{name='Bob', age=23, gender='M', email='bob@bob.com'}

        PersonWithAddress p3 = new PersonWithAddress(
                new PersonSimple("Alice", 18, "F", "alice@alice.com"),
                new Address("Canada", "Toronto")
        );
        System.out.println(gson.toJson(p3));
        // {"person":{"name":"Alice","age":18,"gender":"F","email":"alice@alice.com"},"address":{"country":"Canada","city":"Toronto"}}

        PersonWithAddress p4 = gson.fromJson(
                "{\"person\":{\"name\":\"Bob\",\"age\":23,\"gender\":\"M\",\"email\":\"bob@bob.com\"},\"address\":{\"country\":\"France\",\"city\":\"Paris\"}}",
                PersonWithAddress.class
        );
        System.out.println(p4.toString());
        // PersonWithAddress{person=PersonSimple{name='Bob', age=23, gender='M', email='bob@bob.com'}, address=Address{country='France', city='Paris'}}
    }
}
