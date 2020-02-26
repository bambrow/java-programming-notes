package gson.schema;

public class PersonWithAddress {
    private PersonSimple person;
    private Address address;

    public PersonWithAddress(PersonSimple person, Address address) {
        this.person = person;
        this.address = address;
    }

    @Override
    public String toString() {
        return "PersonWithAddress{" +
                "person=" + person +
                ", address=" + address +
                '}';
    }
}
