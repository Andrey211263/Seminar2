// Дана строка sql-запроса "select * from students where ".
// Сформируйте часть WHERE этого запроса, используя StringBuilder.
// Данные для фильтрации приведены ниже в виде json строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia",
// "city":"Moscow", "age":"null"}


import java.io.*;
import java.util.Arrays;

public class task1 {
    public static void main(String[] args) throws IOException {
        StringBuilder res = new StringBuilder();
        String[] lst = new String[]{""};
        File file = new File("J:\\Java\\Seminar\\seminar2\\dz_sem2\\dz_s2\\src\\task1.json");
        FileReader f = new FileReader(file);
        BufferedReader reader = new BufferedReader(f);
        String line = "";
        String cde = "";
        String t = "";
        String[] tmp = new String[]{""};
        line = reader.readLine(); // считываем строку .json
        while (line != null){
            lst = line.split(",");
            int i = 0;
            while (i < lst.length){
                if (i == 0) {
                    cde = lst[i];
                    tmp = cde.split(":");
                    if (!tmp[1].equals("null")) {
                        res.append("select * from students where name " + tmp[1]);
                    }
                }
                if (i == 1) {
                    cde = lst[i];
                    tmp = cde.split(":");
                    if (!tmp[1].equals("null")) {
                        res.append(" AND country " + tmp[1]);
                    }
                }
                if (i == 2) {
                    cde = lst[i];
                    tmp = cde.split(":");


                    if (!tmp[1].equals("null")) {
                        res.append(" AND city " + tmp[1]);
                    }
                }
                if (i == 3) {
                    cde = lst[i];
                    tmp = cde.split(":");
                    t =  tmp[1];
                    tmp = t.split("}");
                    if (!tmp[0].equals("null")) {
                        res.append(" AND age " + tmp[0] + "\n");
                    }
                }
                i++;

            }
            line = reader.readLine(); // считываем строку .json

        }
        f.close();
        System.out.println(res);
        writelines(String.valueOf(res));



    }
    public static void writelines(String line) {

        try
        {
            FileWriter fl = new FileWriter("J:\\Java\\Seminar\\seminar2\\dz_sem2\\dz_s2\\src\\task1.txt");
            fl.write(line);
            fl.close();
        }
        catch (IOException e)
        {

        }

    }

}

