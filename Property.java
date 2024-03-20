
public class Property {

    private static int numberOfProperties = 0;
    private final String id;
    private String description;
    private double price;

    /**
     * Constructor of class Property
     *
     * @param description The property description.
     * @param price The property price.
     */
    public Property(String description, double price) {
        id = Integer.toString(++numberOfProperties);
        this.description = (description != null) ? description : "";
        this.price = (price > 0) ? price : 0.0;

    }

    /**
     * Id selector.
     */
    public String getId() {
        return id;
    }

    /**
     * Description selector.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Description modifier.
     * 
     * @param description The new description. Must not be null.
     */
    public void setDescription(String description) {
        if (description != null) {
            this.description = description;
        }
    }

    /**
     * Price selector.
     */
    public double getPrice() {
        return price;
    }
    
    /**
     * Price modifier.
     * 
     * @param price The new price. Must not be negative.
     */
    public void setPrice(double price) {
        if (price >= 0.0) {
            this.price = price;
        }
    }

    @Override
    public String toString() {
        return "Descricao\t\t: " + description + "\n"
             + "Preço\t\t: " + price + " Euros";
    }
}
