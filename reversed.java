import java.util.Arrays;
import java.util.LinkedList;

public class reversed {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(5, 4, 3, 2, 1));

        LinkedList<Integer> reversed = reverseList(list);
        System.out.println(reversed);
    }

    public static LinkedList<Integer> reverseList(LinkedList<Integer> list) {
        LinkedList<Integer> reversed = new LinkedList<>();
        for (Integer item : list) {
            reversed.addFirst(item);
        }

        return reversed;
    }
}
