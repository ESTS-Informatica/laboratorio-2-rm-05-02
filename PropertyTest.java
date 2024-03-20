import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

/**
 * A classe de teste PropertyTest.
 *
 * @author  (seu nome)
 * @version (um número da versão ou uma data)
 */
public class PropertyTest
{
    private Property property1;
    
    @Test
    public void testConstructor() {
        assertEquals("T3 Monte Belo", this.property1.getDescription());
        assertEquals(150000.0, this.property1.getPrice());
    }
    
    @Test
    public void testToString() {
        String description = "T3 Monte Belo";
        double price = 150000.0;
        Property property1 = new Property(description, price);
        
        //Test
        assertEquals("Descricao: T3 Monte Belo" + "\nPreço: 150000.0 Euros", property1.toString());
    }
    
    /**
     * Construtor default para a classe de teste PropertyTest
     */
    public PropertyTest()
    {
    }

    /**
     * Define a 'fixture' do teste.
     *
     * Chamado antes de cada método de caso de teste.
     */
    @BeforeEach
    public void setUp()
    {
        String description = "T3 Monte Belo";
        double price = 150000.0;
        
        this.property1 = new Property("T3 Monte Belo", price);
    }

    /**
     * Desfaz a 'fixture' do teste.
     *
     * Chamado após cada método de teste de caso.
     */
    @AfterEach
    public void tearDown()
    {
    }
}
