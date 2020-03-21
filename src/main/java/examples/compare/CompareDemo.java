package examples.compare;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompareDemo {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(102, "David", 123456.78, LocalDate.of(2015,9,17)));
        list.add(new Employee(103, "Zach", 99999.99, LocalDate.of(2017,8,8)));
        list.add(new Employee(101, "Superman", 1235813.00, LocalDate.of(2019,12,21)));
        System.out.println(list);
        // [Employee(id=102, name=David, salary=123456.78, date=2015-09-17), Employee(id=103, name=Zach, salary=99999.99, date=2017-08-08), Employee(id=101, name=Superman, salary=1235813.0, date=2019-12-21)]
        Collections.sort(list); // this will use the compareTo method defined in Employee class
        System.out.println(list);
        // [Employee(id=101, name=Superman, salary=1235813.0, date=2019-12-21), Employee(id=102, name=David, salary=123456.78, date=2015-09-17), Employee(id=103, name=Zach, salary=99999.99, date=2017-08-08)]

        Comparator<Employee> sortByName = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        // same as: Comparator<Employee> sortByName = (o1, o2) -> o1.getName().compareTo(o2.getName());
        // also same as: Comparator<Employee> sortByName = Comparator.comparing(Employee::getName);
        list.sort(sortByName);
        System.out.println(list);
        // [Employee(id=102, name=David, salary=123456.78, date=2015-09-17), Employee(id=101, name=Superman, salary=1235813.0, date=2019-12-21), Employee(id=103, name=Zach, salary=99999.99, date=2017-08-08)]

        Comparator<Employee> sortByNameReversed = Comparator.comparing(Employee::getName).reversed();
        list.sort(sortByNameReversed);
        System.out.println(list);
        // [Employee(id=103, name=Zach, salary=99999.99, date=2017-08-08), Employee(id=101, name=Superman, salary=1235813.0, date=2019-12-21), Employee(id=102, name=David, salary=123456.78, date=2015-09-17)]

        Comparator<Employee> sortBySalaryThenDate = Comparator.comparingDouble(Employee::getSalary).thenComparing(Employee::getDate);
        list.sort(sortBySalaryThenDate);
        System.out.println(list);
        // [Employee(id=103, name=Zach, salary=99999.99, date=2017-08-08), Employee(id=102, name=David, salary=123456.78, date=2015-09-17), Employee(id=101, name=Superman, salary=1235813.0, date=2019-12-21)]
    }
}
