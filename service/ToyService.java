package service;

import dto.Toy;
import repository.ToyRepository;

import java.util.List;
import java.util.Random;

public class ToyService {
    private final ToyRepository toyRepository;
    private final Random random;

    public ToyService(ToyRepository toyRepository) {
        this.toyRepository = toyRepository;
        this.random = new Random();
    }

    public Toy getRandomPrizeToy() {
        List<Toy> prizeToys = toyRepository.getPrizeToys();
        if (prizeToys.isEmpty()) {
            return null;
        }

        int totalWeight = prizeToys.stream().mapToInt(toy -> toy.getWeight()).sum();
        int randomWeight = random.nextInt(totalWeight);
        int cumulativeWeight = 0;

        for (Toy toy : prizeToys) {
            cumulativeWeight += toy.getWeight();
            if (randomWeight < cumulativeWeight) {
                toy.setQuantity(toy.getQuantity() - 1);
                toyRepository.updateToy(toy);
                return toy;
            }
        }

        return null;
    }
}
