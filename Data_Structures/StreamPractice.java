import java.util.stream.*;
public class StreamPractice {
    int ID;
    String name;
    double salary;

    public StreamPractice(int ID, String name, double salary) {
        this.ID = ID;
        this.name = name;
        this.salary = salary;
    }
    
    public static void main(String[] args) {
        StreamPractice[] arr = {
            new StreamPractice(1, "Jeff Bezos", 100000.0),
            new StreamPractice(2, "Bill Gates", 200000.0)
        };
        Stream.of(arr);

        
    }
}
