import dto.Toy;
import repository.FileToyRepository;
import repository.ToyRepository;
import service.ToyService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ToyRepository toyRepository = new FileToyRepository();
        initializePrizeToysIfNeeded(toyRepository);

        Scanner scanner = new Scanner(System.in);
        ToyService toyService = new ToyService(toyRepository);

        System.out.println("Добро пожаловать в программу розыгрыша игрушек!");
        while (true) {
            System.out.println("Чтобы разыграть призовую игрушку, введите 'r'. Для выхода из программы введите 'q':");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                System.out.println("Выход из программы.");
                break;
            } else if (input.equalsIgnoreCase("r")) {
                Toy prizeToy = toyService.getRandomPrizeToy();
                if (prizeToy != null) {
                    System.out.println("Поздравляем! Вы получили призовую игрушку: " + prizeToy.getName());
                }
            } else {
                System.out.println("Неверная команда. Пожалуйста, введите 'r' или 'q'.");
            }
        }
    }

    private static void initializePrizeToysIfNeeded(ToyRepository toyRepository) {
        if (toyRepository.getAllToys().isEmpty()) {
            // Если список призовых игрушек пуст, добавляем начальные данные
            toyRepository.addPrizeToy(new Toy("1", "Мяч", 1, 20));
            toyRepository.addPrizeToy(new Toy("2", "Кукла", 1, 15));
            toyRepository.addPrizeToy(new Toy("3", "Машинка", 1, 10));
        }
    }
}
