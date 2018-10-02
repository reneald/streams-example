import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamExample {


    public static void main(String[] args) {

        Stream<String> generatedStream = Stream.generate(() -> "example").limit(10);
        List<String> collect = generatedStream.collect(Collectors.toList());
        System.out.println(collect);

        IntStream intStream = IntStream.range(1, 42); //last element == 41
        System.out.println(intStream.reduce((x, y) -> x + y).toString());

        LongStream longStream = LongStream.rangeClosed(1, 41); //last element ==41
        System.out.println(longStream.reduce((x, y) -> x + y).toString());
        System.out.println(longStream.reduce(10, (x, y) -> x + y));

        List<Student> students = generateStudentList();
        List<String> studentNamesStartingWithV = students.stream() // source
                .map(x -> x.getLastName()) // intermediate operation
                .filter(firstName -> firstName.startsWith("V")) //intermediate operation
                .collect(Collectors.toList()); // terminal operation
        System.out.println(studentNamesStartingWithV); // shows that order of items is retained

        List<String> shortenedNamesSkippedTwo = students.stream()
                .skip(2)
                .map(Student::getLastName)
                .map(name -> name.substring(0, 2))
                .collect(Collectors.toList());
        System.out.println(shortenedNamesSkippedTwo);

        Optional<String> optionalNameStartingWithA = students.stream()
                .map(Student::getLastName)
                .filter(name -> name.startsWith("A"))
                .findFirst();
        System.out.println(optionalNameStartingWithA);

        // intermediate operations which reduce the size of the stream
        // should be placed before operations which are applying to each element.

    }

    private static List<Student> generateStudentList() {
        Student willem = new Student("Willem", "Peeters", 5, 95);
        Student julien = new Student("Julien", "Serbruyns", 1, 75);
        Student cedric = new Student("Cedric", "Vanginderachter", 3, 80);
        Student jan = new Student("Jan", "Van Achte", 10, 85);
        Student maxime = new Student("Maxime", "Ramaekers", 1, 76);
        Student jo = new Student("Jo", "Vanpaeschen", 4, 65);
        Student chiHow = new Student("Chi How", "Chu", 8, 84);
        Student brecht = new Student("Brecht", "Deschoenmaeker", 7, 52);
        Student leander = new Student("Leander", "Van Reeth", 1, 75);
        Student maarten = new Student("Maarten", "Redant", 1, 80);
        Student paul = new Student("Paul", "McCartney", 2, 74);
        Student john = new Student("John", "Lennon", 3, 72);
        Student ringo = new Student("Ringo", "Starr", 2, 81);
        Student george = new Student("George", "Harrison", 2, 98);
        Student miley = new Student("Miley", "Cyrus", 1, 83);
        Student hannah = new Student("Hannah", "Montana", 1, 65);
        Student gwen = new Student("Gwen", "Stefani", 6, 79);
        Student liliane = new Student("Liliane", "St-Pierre", 11, 74);
        Student dana = new Student("Dana", "Winner", 7, 73);
        Student ann = new Student("Ann", "Christie", 15, 90);

        return Arrays.asList(willem, julien, cedric, jan, maxime, jo, chiHow, brecht, leander, maarten, paul, john, ringo,
        george, miley, hannah, gwen, liliane, dana, ann);
    }
}
