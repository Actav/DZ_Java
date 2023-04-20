import java.util.ArrayList;

public class program {
    public static void main(String[] args) {
        // System.out.println( treNum(3) );
        // System.out.println( factarial(5) );
        // printPrimeNumbers(primeNumbers(1000));
    }

    // Вычислить n-ое треугольного число (сумма чисел от 1 до n)
    static int treNum(int n) {
        int res = (int) (n / 2f * (n + 1));

        return res;
    }

    // n! (произведение чисел от 1 до n)
    static int factarial(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }

        return res;
    }

    // вывести все простые числа от 1 до 1000
    static ArrayList<Integer> primeNumbers(int n) {
        ArrayList<Integer> resp = new ArrayList<>(n / 4);
        int[] arrNums = new int[n - 1];
        int p = 2;

        for (int i = 0; i < arrNums.length; i++) {
            if (arrNums[i] != -1) {
                for (int j = i; j < arrNums.length; j += p) {
                    arrNums[j] = -1;
                    if (i == j) {
                        resp.add(p);
                    }
                }
            }
            p++;
        }

        return resp;
    }

    static void printPrimeNumbers(ArrayList<Integer> nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
