/*
    try {
       int d = 0;
       double catchedRes1 = intArray[8] / d;
       System.out.println("catchedRes1 = " + catchedRes1);
    } catch (ArithmeticException e) {
       System.out.println("Catching exception: " + e);
    }
 */

public class task_02 {
    public static void main(String[] args) {


        double[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        try {
            int d = 0;
            if (d != 0) { // Проверяем, что d не равно нулю, чтобы избежать деления на ноль
                double catchedRes1 = intArray[8] / d;
                System.out.println("catchedRes1 = " + catchedRes1);
            } else {
                System.out.println("Деление на ноль не допустимо.");
            }
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
    }
}
