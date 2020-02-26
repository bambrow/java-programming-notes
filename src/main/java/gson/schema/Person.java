package gson.schema;

public class Person {
    private String firstName;
    private String lastName;
    private int personAge;
    private String personGender;
    private String userEmail;

    public Person(String firstName, String lastName, int personAge, String personGender, String userEmail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personAge = personAge;
        this.personGender = personGender;
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", personAge=" + personAge +
                ", personGender='" + personGender + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
