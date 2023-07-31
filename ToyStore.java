import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Toy {
    private final int id;
    private final String name;
    private int quantity;
    private double weight;

    public Toy(int id, String name, int quantity, double weight) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Quantity: " + quantity + ", Weight: " + weight + "%";
    }
}

public class ToyStore {
    private final List<Toy> toys;
    private final List<Toy> prizeToys;
    private final Random random;

    public ToyStore() {
        toys = new ArrayList<>();
        prizeToys = new ArrayList<>();
        random = new Random();
    }

    public void addToy(int id, String name, int quantity, double weight) {
        Toy toy = new Toy(id, name, quantity, weight);
        toys.add(toy);
    }

    public void updateWeight(int id, double weight) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toy.setWeight(weight);
                break;
            }
        }
    }

    public void play() {
        double totalWeight = toys.stream().mapToDouble(Toy::getWeight).sum();
        double rand = random.nextDouble() * totalWeight;
        for (Toy toy : toys) {
            rand -= toy.getWeight();
            if (rand <= 0) {
                toy.setQuantity(toy.getQuantity() - 1);
                prizeToys.add(toy);
                break;
            }
        }
    }

    public Toy getPrizeToy() {
        if (!prizeToys.isEmpty()) {
            Toy prizeToy = prizeToys.remove(0);
            saveToFile(prizeToy);
            return prizeToy;
        }
        return null;
    }

    private void saveToFile(Toy toy) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("prize_toys.txt", true)))) {
            writer.println(toy.getId() + "," + toy.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();
        toyStore.addToy(1, "Teddy Bear", 5, 30.0);
        toyStore.addToy(2, "Toy Car", 8, 20.0);
        toyStore.addToy(3, "Doll", 4, 15.0);

        toyStore.updateWeight(1, 40.0);
        toyStore.updateWeight(2, 10.0);
        toyStore.updateWeight(3, 35.0);

        toyStore.play();
        Toy prizeToy = toyStore.getPrizeToy();
        if (prizeToy != null) {
            System.out.println("Congratulations! You won: " + prizeToy.getName());
            System.out.println("Remaining quantity of the toy: " + prizeToy.getQuantity());
        } else {
            System.out.println("Sorry, no prize toy available.");
        }
    }
}
