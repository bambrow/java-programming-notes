package lombok_demo;

import lombok.Data;

@Data(staticConstructor = "create")
// this will make constructor private
// and create a static factory method called create
// so calling Course.create(String professor) will create a new instance
public class Course {
    private final String professor;
}
