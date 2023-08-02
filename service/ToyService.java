package service;

import dto.Toy;
import repository.ToyRepository;

import java.util.List;
import java.util.Random;

public class ToyService {
    private final ToyRepository toyRepository;

    public ToyService(ToyRepository toyRepository) {
        this.toyRepository = toyRepository;
    }

    public Toy getRandomPrizeToy() {
        List<Toy> prizeToys = toyRepository.getAllToys();
        if (prizeToys.isEmpty()) {
            System.out.println("Извините, призовых игрушек в автомате нет.");
            return null;
        }

        Random random = new Random();
        int index = random.nextInt(prizeToys.size());
        Toy prizeToy = prizeToys.get(index);

        // Проверяем, что количество игрушек больше 0
        if (prizeToy.getQuantity() > 0) {
            prizeToy.setQuantity(prizeToy.getQuantity() - 1);
            toyRepository.updateToy(prizeToy);
            return prizeToy;
        } else {
            System.out.println("Извините, данной игрушки временно нет в наличии.");
            return null;
        }
    }
}
