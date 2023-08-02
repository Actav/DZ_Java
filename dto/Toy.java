package dto;

import java.io.Serializable;

public class Toy implements Serializable {
    private final String id;
    private final String name;
    private int quantity;
    private int weight;

    public Toy(String id, String name, int quantity, int weight) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }

    public String getId() {
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
}
