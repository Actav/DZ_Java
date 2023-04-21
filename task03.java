import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task03 {
    public static void main(String[] args) {
        final String regex = "\"fio\":\"(.*?)\\\",\"grade\":\"(.)\",\"subject\":\"(.*?)\"";
        final String string = "[{\"fio\":\"Ivanov\",\"grade\":\"5\",\"subject\":\"Mathematics\"},{\"fio\":\"Petrov\",\"grade\":\"4\",\"subject\":\"Informatics\"},{\"fio\":\"Krasnov\",\"grade\":\"5\",\"subject\":\"Physics\"}]";

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
                System.out.printf(
                        "Student %s got %s in a subject %s.\n",
                        matcher.group(1),
                        matcher.group(2),
                        matcher.group(3)
                );
        }
    }
}
