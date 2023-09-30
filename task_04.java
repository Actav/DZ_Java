import java.util.Scanner;

public class task_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите текст: ");
            String input = scanner.nextLine();

            if (input.isEmpty()) {
                throw new IllegalArgumentException("Пустые строки вводить нельзя");
            }

            // Далее можете обработать введенный текст по вашей логике
            System.out.println("Вы ввели: " + input);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
