import java.util.Calendar;

public class Product {
    private String name;
    private String description;
    private String ID;
    private double cost;

    public Product(String name, String description, String ID, double cost) {
        this.name = name;
        this.description = description;
        this.ID = ID;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getID() {
        return ID;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public String toCSV() {
        return String.format("%s,%s,%s,%.2f", ID, name, description, cost);
    }

    public String toJSON() {
        return String.format("{\"ID\":\"%s\", \"name\":\"%s\", \"description\":\"%s\", \"cost\":%.2f}", ID, name, description, cost);
    }

    public String toXML() {
        return String.format("<Product><ID>%s</ID><Name>%s</Name><Description>%s</Description><Cost>%.2f</Cost></Product>",
                ID, name, description, cost);
    }
}

