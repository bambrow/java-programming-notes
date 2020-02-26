package gson.schema;

public class PersonWeight {
    private String name;
    private float weight;

    public PersonWeight(String name, float weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "PersonWeight{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
