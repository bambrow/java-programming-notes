package lombok_demo;

import lombok.Value;
import lombok.experimental.NonFinal;
import lombok.experimental.PackagePrivate;

@Value
// immutable variant of @Data
// all fields are made private and final by default
// setters are not generated
// this class itself is also made final by default
public class Grade {
    String course;
    @PackagePrivate String student;
    @NonFinal int grade;
}
