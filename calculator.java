import com.sun.tools.javac.Main;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class calculator {
    static Logger LOGGER;

    static {
        try {
            FileHandler fh = new FileHandler("./logger_calc.log", true);
            fh.setFormatter(new SimpleFormatter());
            LOGGER = Logger.getLogger(Main.class.getName());
            LOGGER.addHandler(fh);
            LOGGER.setUseParentHandlers(false);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1, num2, result = 0;
        String operator;
        String error = null;

        System.out.println("Simple Calculator");
        System.out.print("Enter the first number: ");
        num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        num2 = scanner.nextDouble();

        System.out.print("Enter the operator (+, -, *, /): ");
        operator = scanner.next();

        switch (operator) {
            case "+" -> result = num1 + num2;
            case "-" -> result = num1 - num2;
            case "*" -> result = num1 * num2;
            case "/" -> {
                if (num2 == 0) {
                    error = "Error: division by zero";
                } else {
                    result = num1 / num2;
                }
            }
            default -> error = "Error: invalid operator";
        }

        if (error == null) {
            System.out.println("Result: " + result);
            LOGGER.log(Level.INFO, "Result: " + result);
        } else {
            System.out.println("ERROR: " + error);
            LOGGER.log(Level.WARNING, "ERROR: " + result);
        }

        scanner.close();
    }
}