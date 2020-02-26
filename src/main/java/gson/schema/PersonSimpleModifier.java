package gson.schema;

public class PersonSimpleModifier {
    private final String name;
    public int age;
    protected String gender;
    private transient String email;

    public PersonSimpleModifier(String name, int age, String gender, String email) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }

    @Override
    public String toString() {
        return "PersonSimpleModifier{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
