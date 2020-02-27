package lombok_demo;

import lombok.*;
import lombok.extern.java.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

@Log
public class LombokDemo {

    private static DateFormat format = new SimpleDateFormat("MM-dd-YYYY");

    public static void main(String[] args) {
        log.info("main function starts...");

        Course course = Course.create("David");
        System.out.println(course);
        // Course(professor=David)

        Professor professor = new Professor("David", 101);
        professor.setCourse("An Introduction to Zach");

        Student student = new Student();
        student.setName("David");
        student.setCourse("An Introduction to Zach");
        student.setGrade(100);
        System.out.println(student);
        // Student(name=David, course=An Introduction to Zach, grade=100)

        professor.setStudents(Collections.singletonList(student));
        System.out.println(professor);
        // Professor(name=David, id=101, course=An Introduction to Zach, students=[Student(name=David, course=An Introduction to Zach, grade=100)])

        System.out.println(new Book());
        // Book(id=0, name=null, author=null)
        System.out.println(new Book(101, "Zach's Life", "David"));
        // Book(id=101, name=Zach's Life, author=David)
        System.out.println(Book.create(102, "Zach's Alternative Life"));
        // Book(id=102, name=Zach's Alternative Life, author=null)

        Grade grade = new Grade("An Introduction to Zach", "David", 100);
        System.out.println(grade);
        // Grade(course=An Introduction to Zach, student=David, grade=100)

        BookBuilder book = BookBuilder.builder().id(101).name("An Introduction to Zach").author("David").build();
        System.out.println(book);
        // BookBuilder(id=101, name=An Introduction to Zach, author=David, lang=[])
        System.out.println(BookBuilder.builder().name("An Introduction to Zach").lang("English").lang("Chinese").lang("Japanese").build());
        // BookBuilder(id=0, name=An Introduction to Zach, author=null, lang=[English, Chinese, Japanese])

        BookWith bookWith = new BookWith(101, "An Introduction to Zach", "David");
        System.out.println(bookWith);
        // BookWith(id=101, name=An Introduction to Zach, author=David)
        System.out.println(bookWith.withName("A Detailed Overview of Zach"));
        // BookWith(id=101, name=A Detailed Overview of Zach, author=David)
        System.out.println(bookWith.withAuthor("David") == bookWith); // true
        System.out.println(bookWith.withAuthor("Zach").withAuthor("David") == bookWith); // false

        testCleanUp();
        // abc

        try {
            testNonNull(null);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        // test is marked non-null but is null

        testVal();
        // [a, b]
        // a

        testVar();
        // []
        // c

        Cached cached = new Cached();
        System.out.println(cached.getCached()); // this will sleep 5 seconds
        System.out.println(cached.getCached()); // but this will not

        log.info("main function exits...");
    }

    protected static void testCleanUp() {
        try {
            @Cleanup ByteArrayOutputStream baos = new ByteArrayOutputStream();
            baos.write(new byte[] {'a', 'b', 'c'});
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // from: https://objectcomputing.com/resources/publications/sett/january-2010-reducing-boilerplate-code-with-project-lombok
    // Using the synchronized keyword on a method can result in unfortunate effects.
    // The synchronized keyword will lock on the current object (this)
    // in the case of an instance method or on the class object for a static method,
    // which means that there is the potential for code outside of the control
    // of the developer to lock on the same object, resulting in a deadlock.
    // It is generally advisable to instead lock explicitly on a separate object
    // that is dedicated solely to that purpose and not exposed in such a way as to allow unsolicited locking.
    // Project Lombok provides the @Synchronized annotation for that very purpose.
    // Annotating an instance method with @Synchronized will prompt Lombok to
    // generate a private locking field named $lock on which the method will lock prior to executing.
    // Similarly, annotating a static method in the same way will generate a private static object
    // named $LOCK for the static method to use in an identical fashion.
    @Synchronized
    public static String synchronizedFormat(Date date) {
        return format.format(date);
    }

    // this will move away the unhandled exception error
    @SneakyThrows
    public static void testSneakyThrows() {
        throw new IllegalAccessException();
    }

    // otherwise, it is required to add throws declaration
    public static void testNoSneakyThrows() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    protected static void testNonNull(@NonNull String test) {
        System.out.println(test);
    }


    // val will be marked as final local variable
    protected static void testVal() {
        val list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        System.out.println(list);
        val foo = list.get(0);
        System.out.println(foo);
    }

    // var will be marked as non-final local variable
    protected static void testVar() {
        var list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        var foo = list.get(0);
        list = new ArrayList<String>();
        System.out.println(list);
        foo = "c";
        System.out.println(foo);
    }

}
