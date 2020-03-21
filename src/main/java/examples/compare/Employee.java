package examples.compare;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@Getter @Setter @ToString
@EqualsAndHashCode
public class Employee implements Comparable<Employee> {

    @EqualsAndHashCode.Include private int id;
    private String name;
    private double salary;
    private LocalDate date;

    @Override
    public int compareTo(Employee that) {
        return this.id - that.id;
    }
}
