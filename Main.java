import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Set<Notebook> notebooks = new HashSet<>();
        notebooks.add(new Notebook("Asus", "ZenBook UA125", 16, 512, "Windows 10", "Grey", 1099.99));
        notebooks.add(new Notebook("Dell", "Inspiron 15", 8, 512, "Windows 10", "Black", 699.99));
        notebooks.add(new Notebook("Apple", "MacBook Air", 8, 256, "macOS", "Gold", 999.99));
        notebooks.add(new Notebook("Lenovo", "ThinkPad X1 Carbon", 16, 1000, "Windows 10", "Black", 1499.99));
        notebooks.add(new Notebook("Asus", "ZenBook UX425", 16, 512, "Windows 10", "Grey", 1199.99));
        notebooks.add(new Notebook("HP", "Spectre x360", 16, 512, "Windows 10", "Silver", 1349.99));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter filter criteria:");
        System.out.println("1 - RAM");
        System.out.println("2 - Hard disk space");
        System.out.println("3 - Operating system");
        System.out.println("4 - Color");

        Map<String, Object> criteria = new HashMap<>();
        int choice;
        do {
            System.out.print("Enter a number (0 - Complete entry): ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Minimum RAM (in GB): ");
                    criteria.put("minRam", scanner.nextInt());
                    System.out.print("Maximum RAM (in GB): ");
                    criteria.put("maxRam", scanner.nextInt());
                    break;
                case 2:
                    System.out.print("Minimum HDD space (in GB): ");
                    criteria.put("minStorage", scanner.nextInt());
                    System.out.print("Maximum HDD capacity (in GB): ");
                    criteria.put("maxStorage", scanner.nextInt());
                    break;
                case 3:
                    System.out.print("Operating system: ");
                    criteria.put("os", scanner.next());
                    break;
                case 4:
                    System.out.print("Color: ");
                    criteria.put("color", scanner.next());
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid input.");
            }
        } while (choice != 0);

        List<Notebook> filteredNotebooks = Notebook.laptopFilter(notebooks, criteria);

        if (filteredNotebooks.isEmpty()) {
            System.out.println("There are no laptops matching your criteria.");
        } else {
            System.out.println("Laptops found:");
            for (Notebook notebook : filteredNotebooks) {
                notebook.printInfo();
            }
        }
    }
}

class Notebook {
    private String brand;
    private String model;
    private int ram;
    private int storageCapacity;
    private String os;
    private String color;
    private double price;

    public Notebook(String brand, String model, int ram, int storageCapacity, String os, String color, double price) {
        this.brand = brand;
        this.model = model;
        this.ram = ram;
        this.storageCapacity = storageCapacity;
        this.os = os;
        this.color = color;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }

    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void printInfo() {
        System.out.println(
                "Brand: " + brand + "," +
                " Model: " + model + "," +
                " RAM: " + ram + " GB," +
                " Storage Capacity: " + storageCapacity + " GB," +
                " OS: " + os + "," +
                " Color: " + color + "," +
                " Price: $" + price);
    }


    public boolean meetsCriteria(Map<String, Object> criteria) {
        if (criteria.containsKey("minRam") && ram < (int) criteria.get("minRam")) {
            return false;
        }
        if (criteria.containsKey("maxRam") && ram > (int) criteria.get("maxRam")) {
            return false;
        }
        if (criteria.containsKey("minStorage") && storageCapacity < (int) criteria.get("minStorage")) {
            return false;
        }
        if (criteria.containsKey("maxStorage") && storageCapacity > (int) criteria.get("maxStorage")) {
            return false;
        }
        if (criteria.containsKey("os") && !os.equals(criteria.get("os"))) {
            return false;
        }
        if (criteria.containsKey("color") && !color.equals(criteria.get("color"))) {
            return false;
        }
        return true;
    }

    public static List<Notebook> laptopFilter(Set<Notebook> notebooks, Map<String, Object> criteria) {
        Set<Notebook> filteredNotebooks = new HashSet<>();
        for (Notebook notebook : notebooks) {
            if (notebook.meetsCriteria(criteria)) {
                filteredNotebooks.add(notebook);
            }
        }

        return filteredNotebooks.stream()
                .sorted(new NotebookComparator())
                .collect(Collectors.toList());
    }
}

class NotebookComparator implements Comparator<Notebook> {
    @Override
    public int compare(Notebook n1, Notebook n2) {
        int result = n1.getBrand().compareTo(n2.getBrand());
        if (result == 0) {
            result = n1.getModel().compareTo(n2.getModel());
        }
        return result;
    }
}


