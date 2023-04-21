/*
Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя
StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
Если значение null, то параметр не должен попадать в запрос.
Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
 */

public class buildsql {
    public static void main(String[] args) {
        StringBuilder sql = new StringBuilder("select * from students where ");
        String jsonStr = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";

        String str = jsonStr.replaceAll("(,?\\s*?\".\\w*?\":\"null\",?)|[{\"}\\s]", "")
                .replace(":", "=")
                .replace(",", " AND ");

        sql.append(str);
        System.out.println(sql);
    }
}
