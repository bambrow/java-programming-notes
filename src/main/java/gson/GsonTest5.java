package gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gson.schema.PersonSimpleExpose;

/**
 * Tests with @Expose and @SerializedName annotations.
 */

public class GsonTest5 {
    public static void main(String[] args) {
        GsonBuilder builder = new GsonBuilder();
        builder.excludeFieldsWithoutExposeAnnotation();
        Gson gson = builder.create();

        PersonSimpleExpose p1 = new PersonSimpleExpose("Alice", 18, "F", "alice@alice.com");
        System.out.println(gson.toJson(p1));
        // {"full-name":"Alice","email":"alice@alice.com"}

        PersonSimpleExpose p2 = gson.fromJson("{\"name\":\"Bob\",\"age\":23,\"gender\":\"M\",\"email\":\"bob@bob.com\"}", PersonSimpleExpose.class);
        System.out.println(p2);
        // PersonSimpleExpose{name='Bob', age=0, gender='M', email='null'}

        PersonSimpleExpose p3 = gson.fromJson("{\"full-name\":\"Cathy\",\"age\":18,\"gender\":\"F\",\"email\":\"cathy@cathy.com\"}", PersonSimpleExpose.class);
        System.out.println(p3);
        // PersonSimpleExpose{name='Cathy', age=0, gender='F', email='null'}

        PersonSimpleExpose p4 = gson.fromJson("{\"full-name\":\"Bob\",\"name\":\"David\",\"username\":\"Fred\",\"age\":23,\"gender\":\"M\",\"email\":\"anyone@anyone.com\"}", PersonSimpleExpose.class);
        System.out.println(p4);
        // PersonSimpleExpose{name='Fred', age=0, gender='M', email='null'}
    }
}
