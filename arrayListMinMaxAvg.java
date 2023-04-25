import java.util.ArrayList;
import java.util.Random;

public class arrayListMinMaxAvg {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        listFill(list);

        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : list) {
            sum += num;
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }

        double avg = (double) sum / list.size();

        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        System.out.println("Avg: " + avg);
    }

    private static void listFill(ArrayList<Integer> inputArray) {
        Random rn = new Random();
        for (int i = 0; i < 10; i++) {
            inputArray.add(rn.nextInt(-100, 100));
        }
    }
}
