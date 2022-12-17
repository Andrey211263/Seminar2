import java.io.*;
import java.util.Arrays;


/*Дана json строка (можно сохранить в файл и читать из файла)
[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{
"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
Написать метод(ы), который распарсит json и, используя StringBuilder,
создаст строки вида: Студент [фамилия] получил
[оценка] по предмету [предмет].
Пример вывода:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.
 */
public class task2 {
    public static void main(String[] args) throws IOException {
        StringBuilder res = new StringBuilder();
        String[] lst = new String[]{""};
        File file = new File("J:\\Java\\Seminar\\seminar2\\dz_sem2\\dz_s2\\src\\task2.json");
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
//                    cde = "Студент " + tmp[1];
                    res.append("Студент " + tmp[1]);
                }
                if (i == 1) {
                    cde = lst[i];
                    tmp = cde.split(":");
//                    cde = " получил " + tmp[1];
                    res.append(" получил " + tmp[1]);
                }
                if (i == 2) {
                    cde = lst[i];
                    tmp = cde.split(":");
                    t =  tmp[1];
                    tmp = t.split("}");
//                    cde = " по предмету " + tmp[0] + "\n";
                    res.append(" по предмету " + tmp[0] + "\n");
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
            FileWriter fl = new FileWriter("J:\\Java\\Seminar\\seminar2\\dz_sem2\\dz_s2\\src\\task2.txt");
            fl.write(line);
            fl.close();
        }
        catch (IOException e)
        {

        }

    }

}

