package lombok_demo;

import lombok.*;

@ToString(exclude = {"id"}) // can also use @ToString.Include and @ToString.Exclude
// @ToString(callSuper = false, exclude = {"id"}) // equivalent
// @ToString(of = {"name", "course", "grade"}) // equivalent
@EqualsAndHashCode // can also use @EqualsAndHashCode.Include and @EqualsAndHashCode.Exclude
// @EqualsAndHashCode(exclude = {}) // equivalent
public class Student {

    @Getter(AccessLevel.PUBLIC) // default
    @Setter(AccessLevel.PUBLIC) // default
    @NonNull
    private String name;

    @Getter(AccessLevel.PROTECTED)
    @Setter(AccessLevel.PRIVATE)
    @NonNull
    // @ToString.Exclude // equivalent to @ToString(exclude = {"id"}) on class
    private long id;

    @Getter
    @Setter(AccessLevel.PROTECTED)
    @EqualsAndHashCode.Exclude
    private String course;

    @Getter
    @Setter(AccessLevel.PACKAGE)
    @EqualsAndHashCode.Exclude
    private int grade;

}
