import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserDataEntry {
    public static void main(String[] args) {
        Map<String, String> userData = getUserDataInput();
        if (userData == null) {
            System.out.println("Ошибка: введены некорректные данные.");

            return;
        }

        String combinedData = combineUserData(userData);
        writeToFile(userData.get("lastName"), combinedData);
    }

    private static Map<String, String> getUserDataInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ФИО, дату рождения, телефон и пол в произвольном порядке (разделенные пробелом):");
        String input = scanner.nextLine();

        return parseUserData(input);
    }

    private static Map<String, String> parseUserData(String input) {
        Map<String, String> userData = new HashMap<>();
        String[] parts = input.split(" ");

        for (String part : parts) {
            if (isValidDate(part)) {
                userData.put("birthDate", part);
            } else if (isValidGender(part)) {
                userData.put("gender", part);
            } else if (isValidPhoneNumber(part)) {
                userData.put("phoneNumber", part);
            } else {
                // Оставшиеся данные считаем ФИО
                if (userData.containsKey("fullName")) {
                    userData.put("fullName", userData.get("fullName") + " " + part);
                } else {
                    userData.put("lastName", part);
                    userData.put("fullName", part);
                }
            }
        }

        if (notValidUserData(userData)) {
            return null;
        }

        return userData;
    }

    private static String combineUserData(Map<String, String> userData) {
        return Stream.of("fullName", "birthDate", "phoneNumber", "gender")
                .map(userData::get)
                .collect(Collectors.joining(" "));
    }

    private static boolean notValidUserData(Map<String, String> userData) {
        return !(userData.size() == 5);
    }

    private static boolean isValidDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        dateFormat.setLenient(false); // Это гарантирует, что дата должна быть строго в формате "dd.MM.yyyy"
        try {
            dateFormat.parse(date);

            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private static boolean isValidGender(String gender) {
        return gender.equals("f") || gender.equals("m");
    }

    private static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("\\d+");
    }

    private static void writeToFile(String fileName, String combinedData) {
        try {
            FileWriter writer = new FileWriter(fileName + ".txt", true); // Добавление данных в конец файла
            writer.write(combinedData + "\n");
            writer.close();

            System.out.println("Данные успешно записаны в файл " + fileName + ".txt");
        } catch (IOException e) {
            System.out.println("Ошибка при записи данных в файл: " + e.getMessage());
        }
    }
}
