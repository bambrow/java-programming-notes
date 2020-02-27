package lombok_demo;

import lombok.Data;

import java.util.List;

@Data
// provides everything needed for a POJO
// combines @ToString, @EqualsAndHashCode, @Getter and @Setter
// and also adds a public constructor that takes any @NonNull or final fields as parameters
public class Professor {
    private final String name; // included in constructor
    private final long id; // included in constructor
    private String course;
    private List<Student> students;
}
