import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Arrays;

public class phones {
    public static void main(String[] args) {
        List<String> employees = Arrays.asList(
                "Ivan Ivanov",
                "Svetlana Petrova",
                "Kristina Belova",
                "Anna Musina",
                "Anna Krutova",
                "Ivan Yurin",
                "Pyotr Lykov",
                "Pavel Chernov",
                "Pyotr Chernyshov",
                "Maria Fedorova",
                "Marina Svetlova",
                "Maria Savina",
                "Maria Rykova",
                "Marina Lugova",
                "Anna Vladimirova",
                "Ivan Mechnikov",
                "Peter Petin",
                "Ivan Yezhov"
        );

        Map<String, Integer> nameToCount = new HashMap<>();

        for (String employee : employees) {
            String name = employee.split(" ")[0];
            nameToCount.put(name, nameToCount.getOrDefault(name, 0) + 1);
        }

        List<String> popularNames = nameToCount
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .map(entry -> entry.getKey() + " (" + entry.getValue() + ")")
                .toList();

        System.out.println("Duplicate names:");
        for (String name : popularNames) {
            System.out.println(name);
        }
    }
}
