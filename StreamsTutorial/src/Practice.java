import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.*;

public class Practice {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Ayush", "Isabelle", "Justin", "Eric"));
        ArrayList<String> newList = new ArrayList<>();

        list.stream()
            .sorted()
            .findFirst()
            .ifPresent(x -> newList.add(x));
        newList.forEach(System.out::println);

    }
}
