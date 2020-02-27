package lombok_demo;

import lombok.Builder;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

import java.util.Set;

@Builder
@ToString
// allows builder functionality such as
// BookBuilder.builder().id(...).name(...).author(...)...build();
public class BookBuilder {
    private final long id;
    @NonNull private String name;
    private String author;
    @Builder.Default @ToString.Exclude private long created = System.currentTimeMillis(); // assign default value
    @Singular(value = "lang") private Set<String> lang;
    // treats builder node as collection
    // BookBuilder.builder()...lang(...).lang(...).lang(...).build();
}
