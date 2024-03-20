

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CompanyTest
{
    private User client1;
    private User client2;
    private User seller1;
    private User seller2;
    private Property property1;
    private Property property2;
    private Company company;
    
    /**
     * Default constructor for test class CompanyTest
     */
    public CompanyTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        client1 = new User("José Manuel", "911111111", "zemanel@yahoo.com");
        client2 = new User("António Francisco", "922222222", "tochico@hotmail.com");
        seller1 = new User("Fernando Fernandes", "966777101", "fefe@remax.pt");
        seller2 = new User("Rodrigo Rodrigues", "966777152", "roro@remax.pt");
        property1 = new Property("T3 Monte Belo", 150000.0);
        property2 = new Property("T1 Lisboa", 999999.0);
        company = new Company();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
    
    @Test
    public void testConstructor() {
        assertNotNull(company.getClients());
        assertNotNull(company.getSellers());
        assertNotNull(company.getProperties());
        assertNotNull(company.getSells());
    }
    
    /**
     * Test to register a client.
     * Should return true.
     */
    @Test
    public void testRegisterClient()
    {
        assertEquals(true, company.registerClient(client1));
    }
    
    /**
     * Test registering two clients.
     * Should return true.
     */
    @Test
    public void testRegisterClients()
    {
        assertEquals(true, company.registerClient(client1));
        assertEquals(true, company.registerClient(client2));
    }
    
    /**
     * Test attempt to register the same client twice.
     * Must not have duplicates. Should return false.
     */
    @Test
    public void testRegisterClientDuplicate()
    {
        assertEquals(true, company.registerClient(client1));
        assertEquals(false, company.registerClient(client1));
    }
    
    /**
     * Test attempt to register a null client.
     * Must not be null. Should return false.
     */
    @Test
    public void testRegisterClientNull()
    {
        assertEquals(false, company.registerClient(null));
    }
    
    /**
     * Test to register a seller.
     * Should return true.
     */
    @Test
    public void testRegisterSeller()
    {
        assertEquals(true, company.registerSeller(seller1));
    }
    
    /**
     * Test registering two sellers.
     * Should return true.
     */
    @Test
    public void testRegisterSellers()
    {
        assertEquals(true, company.registerSeller(seller1));
        assertEquals(true, company.registerSeller(seller2));
    }
    
    /**
     * Test attempt to register the same seller twice.
     * Must not have duplicates. Should return false.
     */
    @Test
    public void testRegisterSellerDuplicate()
    {
        assertEquals(true, company.registerSeller(seller1));
        assertEquals(false, company.registerSeller(seller1));
    }
    
    /**
     * Test attempt to register a null seller.
     * Must not be null. Should return false.
     */
    @Test
    public void testRegisterSellerNull()
    {
        assertFalse(company.registerSeller(null));
    }
    
    /**
     * Test to register a property.
     * Should return true.
     */
    @Test
    public void testRegisterProperty()
    {
        assertTrue(company.registerProperty(property1));
    }
    
    /**
     * Test registering two properties.
     * Should return true.
     */
    @Test
    public void testRegisterProperties()
    {
        assertEquals(true, company.registerProperty(property1));
        assertEquals(true, company.registerProperty(property2));
    }
    
    /**
     * Test attempt to register the same property twice.
     * Must not have duplicates. Should return false.
     */
    @Test
    public void testRegisterPropertyDuplicate()
    {
        assertEquals(true, company.registerProperty(property1));
        assertEquals(false, company.registerProperty(property1));
    }
    
    /**
     * Test attempt to register a null property.
     * Must not be null. Should return false.
     */
    @Test
    public void testRegisterVehicleNull()
    {
        assertEquals(false, company.registerProperty(null));
    }

    /**
     * ******* Nível 5 *********
     */
    /**
     * Test creation of a new sell (with sell registration).
     */
    @Test
    public void testCreateSale()
    {
        assertEquals(true, company.registerClient(client1));
        assertEquals(true, company.registerSeller(seller1));
        assertEquals(true, company.registerProperty(property1));
        assertEquals(true, company.createSell(client1, seller1, property1));
    }
    
    /**
     * Test calculation of the total number of sells within a provided year.
     */
    @Test
    public void testCalculateSellsOfTheYear()
    {
        assertEquals(true, company.registerClient(client1));
        assertEquals(true, company.registerClient(client2));
        assertEquals(true, company.registerSeller(seller1));
        assertEquals(true, company.registerSeller(seller2));
        assertEquals(true, company.registerProperty(property1));
        assertEquals(true, company.registerProperty(property2));
        assertEquals(true, company.createSell(client1, seller1, property1));
        assertEquals(true, company.createSell(client2, seller2, property2));
        assertEquals(2, company.calculateSellsOfTheYear(2023));
    }
    
    /**
     * Test the finding of the seller with more sells within a provided year.
     */
    @Test
    public void testFindSellerOfTheYear()
    {
        assertEquals(true, company.registerClient(client1));
        assertEquals(true, company.registerClient(client2));
        assertEquals(true, company.registerSeller(seller1));
        assertEquals(true, company.registerSeller(seller2));
        assertEquals(true, company.registerProperty(property1));
        assertEquals(true, company.registerProperty(property2));
        assertEquals(true, company.createSell(client1, seller1, property1));
        assertEquals(true, company.createSell(client2, seller2, property2));
        assertEquals(seller1.getName(), company.findSellerOfTheYear(2023));
    }
}
