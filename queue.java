import java.util.LinkedList;

public class queue {
    public static void main(String[] args) {
        MyQueue<String> queue = new MyQueue<>();

        queue.enqueue("element 1");
        queue.print();

        System.out.println(queue.first());
        queue.print();

        System.out.println(queue.dequeue());
        queue.print();
    }
}

class MyQueue<T> {
    private final LinkedList<T> list;

    public MyQueue() {
        list = new LinkedList<>();
    }

    public void enqueue(T item) {
        list.addLast(item);
    }

    public T dequeue() {
        return list.removeFirst();
    }

    public T first() {
        return list.getFirst();
    }

    public void print() {
        if (list.size() > 0) {
            list.forEach(System.out::println);
        } else {
            System.out.println("List EMPTY");
        }
        System.out.println();
    }
}