package maria.clara.servicios;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServicioInventarioTest {

    ServicioInventario servicioParaTest = new ServicioInventario();

    @Test
    public void getInventarioForHamburguesaEquals3() {
        assertEquals(3, servicioParaTest.obtenerInventario("Hamburguesa"));
    }

    @Test
    public void getInventarioForMuffinEquals3() {
        assertEquals(3, servicioParaTest.obtenerInventario("Muffin"));
    }

    @Test
    public void getInventarioForTortaEquals1() {
        assertEquals(1, servicioParaTest.obtenerInventario("Torta"));
    }

    @Test
    public void getInventarioForPizzaEquals2() {
        assertEquals(2, servicioParaTest.obtenerInventario("Pizza"));
    }
}