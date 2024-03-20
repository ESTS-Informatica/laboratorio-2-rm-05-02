

/**
 * A property to sell.
 *
 * @author POO
 * @version 03/2024
 */
public class Property {

    private static int NUMBER_OF_PROPERTIES = 0;
    private final String id;
    private String model;
    private double price;
    private String description;

    /**
     * Constructor of class Property
     *
     * @param description The property description.
     * @param price The property price.
     */
    public Property(String description, double price) {
        this.id = null;
        this.description = description;
        this.price = -1;
    }

    /**
     * Id selector.
     */
    public String getId() {
        return null;
    }
    
    /**
     * Description selector.
     */
    public String getDescription() {
        return null;
    }

    /**
     * Description modifier.
     * 
     * @param description The new description. Must not be null.
     */
    public void setDescription(String description) {
        if (description != null){
            this.description = description;
        }
    }

    /**
     * Price selector.
     */
    public double getPrice() {
        return -1;
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
        return null;
    }
}
