import java.util.LinkedList;

public class evensremove {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        listFill(list);

        list.removeIf(num -> num % 2 == 0);
        System.out.println(list);
    }

    private static void listFill(LinkedList<Integer> inputArray) {
        for (int i = 0; i < 20; i++) {
            inputArray.add(i);
        }
    }
}
