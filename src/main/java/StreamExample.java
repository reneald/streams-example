import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamExample {


    public static void main(String[] args) {

        Stream<String> generatedStream = Stream.generate(() -> "example").limit(10);

        IntStream intStream = IntStream.range(1, 42); //last element == 41
        LongStream longStream = LongStream.rangeClosed(1, 41); //last element ==41

        List<Student> students = new ArrayList<>();
        List<String> studentNamesStartingWithA = students.stream() // source
                .map(x -> x.getFirstName()) // intermediate operation
                .filter(firstName -> firstName.startsWith("A")) //intermediate operation
                .collect(Collectors.toList()); // terminal operation

        List<String> shortenedNamesSkippedTwo = students.stream()
                .skip(2)
                .map(Student::getLastName)
                .map(name -> name.substring(0, 2))
                .collect(Collectors.toList());

        Optional<String> optionalNameStartingWithA = students.stream()
                .map(Student::getLastName)
                .filter(name -> name.startsWith("A"))
                .findFirst();

        // intermediate operations which reduce the size of the stream
        // should be placed before operations which are applying to each element.

        OptionalInt reduced =
                IntStream.range(1, 4).reduce((a, b) -> a + b); // without identity(initial value)

        int reducedTwoParams =
                IntStream.range(1, 4).reduce(10, (a, b) -> a + b);

    }
}
