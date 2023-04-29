
import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = null;

        String regex = "([0-9,.-]+)?(.+?)([0-9,.-]+)?";
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);

        double num1, num2, result = 0;
        String operand;

        Stack<Double> operations = new Stack<>();

        while (true) {
            if (input == null) {
                System.out.println(
                        "Available Operations:\n" +
                        "\"+\" - addition\n" +
                        "\"*\" - multiplication\n" +
                        "\"/\" - division\n" +
                        "\"-\" - subtraction\n" +
                        "\"<\" - undo\n" +
                        "\"=\" - exit"
                );

                System.out.print("Input example: 2+2 >>");
            }
            input = scanner.nextLine().replaceAll(" ", "");
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                num1 = matcher.group(1) != null ? Double.parseDouble(matcher.group(1)) : result;
                operand = matcher.group(2);
                num2 = matcher.group(3) != null ? Double.parseDouble(matcher.group(3)) : 0;


                if (Objects.equals(operand, "=")) {
                    System.out.println("Result: " + result);
                    break;
                }

                if (Objects.equals(operand, "<")) {
                    if (!operations.empty()) {
                        result = operations.pop();
                        System.out.printf("Undo: %.2f%n", result);
                    } else {
                        System.out.println("No operations to undo!");
                    }
                } else {
                    operations.push(result);
                    switch (operand) {
                        case "+" -> result = num1 + num2;
                        case "-" -> result = num1 - num2;
                        case "*" -> result = num1 * num2;
                        case "/" -> {
                            if (num2 != 0) {
                                result = num1 / num2;
                            } else {
                                System.out.println("Cannot divide by zero!");
                            }
                        }
                        default -> System.out.println("Cannot operand!");
                    }
                }
            };

            System.out.printf(">>%.2f", result);
        }
    }
}
