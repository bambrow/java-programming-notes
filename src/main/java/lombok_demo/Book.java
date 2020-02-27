package lombok_demo;

import lombok.*;

@NoArgsConstructor(force = true) // force initialization with default value
@AllArgsConstructor
@RequiredArgsConstructor(staticName = "create") // use static factory method
@ToString
public class Book {
    private final long id;
    @NonNull private String name;
    private String author;
}
