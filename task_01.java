import java.util.Scanner;

public class task_01 {
    public static float getInputFloat() {
        Scanner scanner = new Scanner(System.in);
        float result = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Введите дробное число: ");
                String userInput = scanner.nextLine().trim().replace(",", ".");
                result = Float.parseFloat(userInput);
                validInput = true; // Если конвертация прошла успешно, устанавливаем флаг в true
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Введено некорректное число. Пожалуйста, повторите ввод.");
            }
        }

        return result;
    }

    public static void main(String[] args) {
        float inputNumber = getInputFloat();
        System.out.println("Вы ввели: " + inputNumber);
    }
}
