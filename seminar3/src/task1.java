
import java.util.ArrayList;
import java.util.Collections;

public class task1 {
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
        System.out.println(planet);
        Collections.sort(planet);
        System.out.println(planet);
        int count = 1;
        String item = planet.get(0);
        for (int i = 1; i <= planet.size()-1; i++) {
            if (item.equals(planet.get(i))) {
                count++;
            } else if (count > 0) {

                System.out.println(item + " " + count);
                item = planet.get(i);
                count = 1;

            }

        }
        System.out.println(item + " "+count);
    }
}