package repository;

import dto.Toy;

import java.util.List;

public interface ToyRepository {
    List<Toy> getAllToys();
    void addPrizeToy(Toy toy);
    void updateToy(Toy toy);
}
