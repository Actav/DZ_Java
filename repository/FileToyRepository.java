package repository;

import dto.Toy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileToyRepository implements ToyRepository {
    private final String filename;

    public FileToyRepository(String filename) {
        this.filename = filename;
    }

    @Override
    public List<Toy> getPrizeToys() {
        return loadToysFromFile();
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

    @Override
    public void fillPrizeToys(List<Toy> toys) {
        saveToysToFile(toys);
    }

    private List<Toy> loadToysFromFile() {
        List<Toy> toys = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
            toys = (List<Toy>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return toys;
    }

    private void saveToysToFile(List<Toy> toys) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(toys);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
