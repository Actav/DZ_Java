import dto.Toy;
import generator.PrizeToyGenerator;
import repository.FileToyRepository;
import service.ToyService;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Указываем путь к файлу
        String filePath = "prize_toys.dat";

        // Создаем файл, если его не существует
        File file = new File(filePath);
        try {
            if (!file.exists()) {
                file.createNewFile()
                System.out.println("Файл создан: " + filePath);
            }
        } catch (IOException e) {
            e.printStackTrace();        }

        FileToyRepository toyRepository = new FileToyRepository(filePath);
        List<Toy> prizeToys = toyRepository.getPrizeToys();

        if (prizeToys.isEmpty()) {
            // Если автомат пуст, добавим несколько призовых игрушек
            List<Toy> initialPrizeToys = PrizeToyGenerator.createInitialPrizeToys();
            toyRepository.fillPrizeToys(initialPrizeToys);
        }

        System.out.println("Добро пожаловать в программу розыгрыша игрушек!");

        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.println("Чтобы разыграть призовую игрушку, введите 'r'. Для выхода из программы введите 'q':");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("r")) {
                ToyService toyService = new ToyService(toyRepository);
                Toy prizeToy = toyService.getRandomPrizeToy();
                if (prizeToy != null) {
                    System.out.println("Поздравляем! Вы получили призовую игрушку: " + prizeToy.getName());
                    toyRepository.updateToy(prizeToy); // Уменьшаем количество призовых игрушек в автомате
                } else {
                    System.out.println("Автомат с призовыми игрушками пуст. Приходите позже!");
                }
            }
        } while (!input.equalsIgnoreCase("q"));

        scanner.close();
    }
}
