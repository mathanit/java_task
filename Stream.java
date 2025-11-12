import java.util.List;
import java.util.ArrayList;

public class Stream{
    public static void main(String[] args) {
        List<Integer> array =new ArrayList<>();
        array.add(10);
        array.add(1);
        array.add(2);
        array.add(3);
        array.stream()
        .filter(n->n>3)
        .forEach(System.out::println);

    }
}