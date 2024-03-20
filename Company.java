
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

public class Company {

    // Clients registry
    private ArrayList<User> clients;
    // Sellers registry
    private ArrayList<User> sellers;
    // Properties registry
    private ArrayList<Property> properties;
    // Sells registry
    private ArrayList<Sell> sells;

    /**
     * Constructor of class Company
     */
    public Company() {
        clients = new ArrayList<>();
        sellers = new ArrayList<>();
        properties = new ArrayList<>();
        sells = new ArrayList<>();
    }

    /**
     * Get the list of clients.
     *
     * @return This stand clients.
     */
    public List<User> getClients() {
        return clients;
    }

    /**
     * Get the list of sellers.
     *
     * @return This stand sellers.
     */
    public List<User> getSellers() {
        return sellers;
    }

    /**
     * Get the list of properties.
     *
     * @return This company's properties.
     */
    public List<Property> getProperties() {
        return properties;
    }

    /**
     * Get the list of sells.
     *
     * @return This company sells.
     */
    public List<Sell> getSells() {
        return sells;
    }

    /**
     * Register a client.
     *
     * @param client to register. Must not be null. Must not be registered.
     * @return true If the registration succeeds, false otherwise.
     */
    public boolean registerClient(User client) {
        if (client != null && !clients.contains(client)) {
            clients.add(client);
            return true;
        }
        return false;
    }

    /**
     * Register a seller.
     *
     * @param seller to register. Must not be null. Must not be registered.
     * @return true If the registration succeeds, false otherwise.
     */
    public boolean registerSeller(User seller) {
        if (seller != null && !sellers.contains(seller)) {
            sellers.add(seller);
            return true;
        }
        return false;
    }

    /**
     * Register a property.
     *
     * @param property to register. Must not be null. Must not be registered.
     * @return true If the registration succeeds, false otherwise.
     */
    public boolean registerProperty(Property property) {
        if (property != null && !properties.contains(property)) {
            properties.add(property);
            return true;
        }
        return false;
    }

    /**
     * Register a sell.
     *
     * @param sell to register. Must not be null. Must not be registered.
     * @return true If the registration succeeds, false otherwise.
     */
    public boolean registerSell(Sell sell) {
        if (sell != null && !sells.contains(sell)) {
            sells.add(sell);
            return true;
        }
        return false;
    }

    /**
     * Generate a new sell and register that sell.
     *
     * @param client Must be already registered.
     * @param seller Must be already registered.
     * @param property Must be already registered.
     * @return true If the request succeeds, false otherwise.
     */
    public boolean createSell(User client, User seller, Property property) {
        if (client != null && clients.contains(client) && seller != null && sellers.contains(seller)) {
            if (property != null && properties.contains(property)) {
                registerSell(new Sell(client, seller, property));
                return true;
            }
        }
        return false;
    }

    /**
     * Display all clients.
     */
    public void showClients() {
        if (clients.isEmpty()) {
            System.out.println("\nA imobiliaria ainda não tem clientes adicionados.");
        } else {
            System.out.println("\nNúmero de clientes: " + clients.size());
            System.out.println("\n+++ Lista de clientes +++");
            for (User u : clients) {
                u.show();
            }
            System.out.println();
        }
    }

    /**
     * Display all sellers.
     */
    public void showSellers() {
        if (sellers.isEmpty()) {
            System.out.println("\nA imobiliaria ainda não tem vendedores adicionados.");
        } else {
            System.out.println("\nNúmero de vendedores: " + sellers.size());
            System.out.println("\n+++ Lista de vendedores +++");
            for (User u : sellers) {
                u.show();
            }
            System.out.println();
        }
    }

    /**
     * Display all properties.
     */
    public void showProperties() {
        if (properties.isEmpty()) {
            System.out.println("\nA imobiliaria ainda não tem imoveis adicionados.");
        } else {
            System.out.println("\nNúmero de imoveis: " + properties.size());
            System.out.println("\n+++ Lista de imoveis +++");
            for (Property p : properties) {
                System.out.println(p + "\n");
            }
            System.out.println();
        }
    }

    /**
     * Display all sells.
     */
    public void showSells() {
        if (sells.isEmpty()) {
            System.out.println("\nA imobiliaria ainda não realizou vendas.");
        } else {
            System.out.println("\nNúmero de vendas: " + sells.size());
            System.out.println("\n+++ Lista de vendas +++");
            for (Sell s : sells) {
                System.out.println(s + "\n");
            }
            System.out.println();
        }
    }

    /**
     * Calculates the total number of sells within the provided year.
     *
     * @param year
     * @return The total number of sells in the year.
     */
    public int calculateSellsOfTheYear(int year) {
        int numberOfSells = 0;
        for (Sell s : sells) {
            if (s.getDate().getYear() == year) {
                numberOfSells++;
            }
        }
        return numberOfSells;
    }

    /**
     * Find the seller with more sells within the provided year.
     *
     * @param year
     * @return The name of the seller of the year.
     */
    public String findSellerOfTheYear(int year) {
        String bestSellerName = "";
        int bestSellerNumberOfSells = 0;
        for (User u : sellers) {
            int currentSellerNumberOfSells = 0;
            for (Sell s : sells) {
                if (s.getDate().getYear() == year) {
                    if (s.getSeller().getId().equals(u.getId())) {
                        currentSellerNumberOfSells++;
                    }
                }
            }
            if (currentSellerNumberOfSells > bestSellerNumberOfSells) {
                bestSellerNumberOfSells = currentSellerNumberOfSells;
                bestSellerName = u.getName();
            }
        }
        return bestSellerName;
    }

}
