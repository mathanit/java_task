import java.util.stream.Stream;

public class StreamExample1 {
    public static void main(String[] args) {
        Stream.of("Mathan", "Arun", "Kumar", "Mohan")
              .filter(name -> name.startsWith("M"))
              .map(String::toUpperCase)
              .forEach(System.out::println); // Just print, no need for a List
    }
}
