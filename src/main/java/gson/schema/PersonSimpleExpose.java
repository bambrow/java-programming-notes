package gson.schema;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PersonSimpleExpose {
    @Expose
    @SerializedName(value = "full-name", alternate = {"name", "username"})
    private String name;

    @Expose(serialize = false, deserialize = false)
    private int age;

    @Expose(serialize = false)
    private String gender;

    @Expose(deserialize = false)
    private String email;

    public PersonSimpleExpose(String name, int age, String gender, String email) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }

    @Override
    public String toString() {
        return "PersonSimpleExpose{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
