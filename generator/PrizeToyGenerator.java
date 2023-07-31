package generator;

import dto.Toy;
import java.util.ArrayList;
import java.util.List;

public class PrizeToyGenerator {
    public static List<Toy> createInitialPrizeToys() {
        List<Toy> prizeToys = new ArrayList<>();

        prizeToys.add(new Toy("1", "Мяч", 1, 20));
        prizeToys.add(new Toy("2", "Кукла", 1, 15));
        prizeToys.add(new Toy("3", "Машинка", 1, 10));

        return prizeToys;
    }
}
