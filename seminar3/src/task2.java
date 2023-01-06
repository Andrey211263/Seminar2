import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class task2 {
    public static void main(String[] args) {
        ArrayList<String> planet = new ArrayList<>();
        planet.add("Земля");
        planet.add("Юпитер");
        planet.add("Сатурн");
        planet.add("Земля");
        planet.add("Нептун");
        planet.add("Земля");
        planet.add("Марс");
        planet.add("Юпитер");
        planet.add("Нептун");
        planet.add("Плутон");
        planet.add("Меркурий");
        planet.add("Венера");
        planet.add("Сатурн");
        planet.add("Уран");
        planet.add("Меркурий");
        planet.add("Земля");
        System.out.println(planet);
        Collections.sort(planet);
        System.out.println(planet);
                int count = 1;
        String item = planet.get(0);
        for (int i = 1; i <= planet.size() - 1; i++) {
            if (item.equals(planet.get(i)))
            {
                count++;
            }
            else
            {
                System.out.println(item + " " + count);
                item = planet.get(i);
                count = 1;
            }
        }
        Iterator<String> col = planet.iterator();
        while (col.hasNext()) {
            String current = col.next();
            if (Collections.frequency(planet, current) > 1) {
                col.remove();
            }
        }
        System.out.println(item + " " + count);
        System.out.println(planet);
    }
}