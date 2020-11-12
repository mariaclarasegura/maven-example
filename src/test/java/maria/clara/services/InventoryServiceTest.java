package maria.clara.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryServiceTest {

    InventoryService serviceForTest = new InventoryService();

    @Test
    public void getInventoryForHamburgerEquals3() {
        assertEquals(3, serviceForTest.obtainInventory("Hamburger"));
    }

    @Test
    public void getInventoryForMuffinEquals3() {
        assertEquals(3, serviceForTest.obtainInventory("Muffin"));
    }

    @Test
    public void getInventoryForCakeEquals1() {
        assertEquals(1, serviceForTest.obtainInventory("Cake"));
    }

    @Test
    public void getInventoryForPizzaEquals2() {
        assertEquals(2, serviceForTest.obtainInventory("Pizza"));
    }
}