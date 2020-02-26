package gson.schema;

import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;

public class PersonSimpleVersion {
    private String name;
    @Since(1.0) @Until(1.1) private int age;
    @Since(1.1) @Until(1.2) private String gender;
    @Since(1.2) private String email;

    public PersonSimpleVersion(String name, int age, String gender, String email) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }

    @Override
    public String toString() {
        return "PersonSimpleVersion{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
