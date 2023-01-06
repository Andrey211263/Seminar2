import java.util.Arrays;

public class Main {
// Дана строка sql-запроса "select * from students where ".
// Сформируйте часть WHERE этого запроса, используя StringBuilder.
// Данные для фильтрации приведены ниже в виде json строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia",
// "city":"Moscow", "age":"null"}

        public static void main(String[] args) {
            String json = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
            String[] newjson = json.replace("\"", "").replace(":", " ").replace(",", "").replace("{", "").replace("}", "").split(" ");
            System.out.println(Arrays.toString(newjson));
            StringBuilder stringBuilder = new StringBuilder("select * from students where ");
            for (int i = 0; i < newjson.length; i += 2) {
                if (!newjson[i + 1].equals("null")) {
                    stringBuilder.append(newjson[i]).append(" ").append(newjson[i + 1]).append(" ");
                    try {
                        if ((!newjson[i + 3].equals("null")) && (i + 2 != newjson.length)) {
                            stringBuilder.append("AND ");
                        }
                    }
                    catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }

                }
            }
            System.out.println(stringBuilder);

        }


    }