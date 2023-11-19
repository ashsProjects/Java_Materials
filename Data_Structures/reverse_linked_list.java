import java.util.LinkedList;

public class reverse_linked_list {
    public static void main(String[] args) {
        LinkedList<String> str = new LinkedList<String>();
        str.add("1");
        str.add("2");
        str.add("3");
        str.add("4");
        str.add("5");
        str.add("6");

        System.out.print("Before reverse: ");
        for (String s : str) {
            System.out.print(s + " ");
        }

        reverseLinkedList(str);

        System.out.print("\nAfter reverse: ");
        for (String s : str) {
            System.out.print(s + " ");
        }

    }

    public static void reverseLinkedList(LinkedList<String> str) {
        String tempStart;
        String tempLast;
        for (int i = 0; i < str.size() / 2; i++) {
            tempStart = str.get(i);
            tempLast = str.get(str.size() - 1 - i);
            str.remove(i);
            str.remove(str.size() - 1 - i);
            str.add(i, tempLast);
            str.add(str.size() - i, tempStart);
        }

    }
}
