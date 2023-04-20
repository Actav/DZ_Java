import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1, num2, result;
        String operator;

        System.out.println("Simple Calculator");
        System.out.print("Enter the first number: ");
        num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        num2 = scanner.nextDouble();

        System.out.print("Enter the operator (+, -, *, /): ");
        operator = scanner.next();

        switch (operator) {
            case "+":
                result = num1 + num2;
                System.out.println("Result: " + result);
                break;
            case "-":
                result = num1 - num2;
                System.out.println("Result: " + result);
                break;
            case "*":
                result = num1 * num2;
                System.out.println("Result: " + result);
                break;
            case "/":
                if (num2 == 0) {
                    System.out.println("Error: division by zero");
                } else {
                    result = num1 / num2;
                    System.out.println("Result: " + result);
                }
                break;
            default:
                System.out.println("Error: invalid operator");
                break;
        }

        scanner.close();
    }
}
