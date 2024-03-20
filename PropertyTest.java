// Source code is decompiled from a .class file using FernFlower decompiler.
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PropertyTest {
   public PropertyTest() {
   }

   @BeforeEach
   public void setUp() {
   }

   @AfterEach
   public void tearDown() {
   }

   @Test
   public void testConstructor() {
      Property property1 = new Property("T3 Monte Belo", 150000.0);
      Assertions.assertEquals("T3 Monte Belo", property1.getDescription());
      Assertions.assertEquals(150000.0, property1.getPrice());
      Assertions.assertEquals("1", property1.getId());
   }
}
