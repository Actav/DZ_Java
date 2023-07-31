package repository;

import dto.Toy;

import java.util.List;

public interface ToyRepository {
    List<Toy> getPrizeToys();

    void updateToy(Toy toy);

    void fillPrizeToys(List<Toy> toys);
}
