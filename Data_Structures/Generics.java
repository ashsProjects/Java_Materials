public class Generics {
    public static void main(String[] args) {
        Integer[] arr = { 1, 2, 3, 4, 5 };
        String[] str = { "Bob", "Sally", "John", "James", "Jim" };
        Character[] c = { 'a', 'b', 'c', 'd', 'e', 'f' };

        GenericClass<Integer, String> n = new GenericClass<>(1000, "AS");
        System.out.println(n.getKey() + ": " + n.getValue());

        displayArray(arr);
        displayArray(str);
        displayArray(c);

        System.out.println(getFirst(arr));
        System.out.println(getFirst(str));
        System.out.println(getFirst(c));

    }

    // generic method
    public static <T> void displayArray(T[] array) {
        for (T x : array)
            System.out.print(x + " ");
        System.out.println("");
    }

    public static <T> T getFirst(T[] array) {
        return array[0];
    }
}
