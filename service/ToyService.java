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

    public Toy getRandomPrizeToy(List<Toy> prizeToys) {
        Toy prizeToy = findAvailableToy(prizeToys);

        if (prizeToy != null) {
            prizeToy.setQuantity(prizeToy.getQuantity() - 1);
            toyRepository.updateToy(prizeToy);

            return prizeToy;
        } else {
            System.out.println("Извините, временно нет доступных призовых игрушек.");

            return null;
        }
    }

    public List<Toy> getPrizeToys() {
        List<Toy> prizeToys = toyRepository.getAllToys();
        int totalRemainingToys = prizeToys.stream().mapToInt(Toy::getQuantity).sum();

        if (totalRemainingToys == 0) {
            return null;
        }

        return prizeToys;
    }

    private Toy findAvailableToy(List<Toy> toys) {
        int totalQuantity = toys.stream().mapToInt(Toy::getQuantity).sum();

        if (totalQuantity == 0) {
            return null;
        }

        Random random = new Random();
        int randomIndex = random.nextInt(totalQuantity);

        for (Toy toy : toys) {
            if (randomIndex < toy.getQuantity()) {
                return toy;
            }
            randomIndex -= toy.getQuantity();
        }

        return null;
    }
}
