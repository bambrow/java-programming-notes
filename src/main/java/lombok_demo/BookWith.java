package lombok_demo;

import lombok.*;

@AllArgsConstructor
@ToString
public class BookWith {
    private final long id;
    @NonNull @With private String name;
    // with works like scala case class copy method
    // create a new clone of object with one field changed
    // if the field assigned is same as the current, then directly return this
    @With(AccessLevel.PUBLIC) private String author;
}
