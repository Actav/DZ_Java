package repository;

import dto.Toy;
import repository.ToyRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileToyRepository implements ToyRepository {
    private static final String FILE_NAME = "prize_toys.dat";

    @Override
    public List<Toy> getAllToys() {
        return loadToysFromFile();
    }

    @Override
    public void addPrizeToy(Toy toy) {
        List<Toy> prizeToys = loadToysFromFile();
        prizeToys.add(toy);
        saveToysToFile(prizeToys);
    }

    @Override
    public void updateToy(Toy toy) {
        List<Toy> prizeToys = loadToysFromFile();
        for (int i = 0; i < prizeToys.size(); i++) {
            if (prizeToys.get(i).getId().equals(toy.getId())) {
                prizeToys.set(i, toy);
                break;
            }
        }
        saveToysToFile(prizeToys);
    }

    private List<Toy> loadToysFromFile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Toy>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Если файл не найден или возникла ошибка чтения, возвращаем пустой список
            return new ArrayList<>();
        }
    }

    private void saveToysToFile(List<Toy> prizeToys) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            outputStream.writeObject(prizeToys);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deletePrizeToysFile() {
        File file = new File("prize_toys.dat");
        if (file.exists()) {
            file.delete();
        }
    }

}
