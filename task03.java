/*
4) ** (Для преподавателя: если не успели выполнить задание 7, дать наводку из этого задания) Дана json-строка
(можно сохранить в файл и читать из файла)
[
    {"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
    {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
    {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}
]

Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида:
Студент [фамилия] получил [оценка] по предмету [предмет].

Пример вывода:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task03 {
    public static void main(String[] args) {
        final String regex = "\"fio\":\"(.*?)\",\"grade\":\"(.)\",\"subject\":\"(.*?)\"";
        final String string = "[" +
                "{\"fio\":\"Ivanov\",\"grade\":\"5\",\"subject\":\"Mathematics\"}," +
                "{\"fio\":\"Petrov\",\"grade\":\"4\",\"subject\":\"Informatics\"}," +
                "{\"fio\":\"Krasnov\",\"grade\":\"5\",\"subject\":\"Physics\"}" +
                "]";

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            System.out.printf(
                    "Student %s got %s in a subject %s\n",
                    matcher.group(1),
                    matcher.group(2),
                    matcher.group(3)
            );
        }
    }
}
