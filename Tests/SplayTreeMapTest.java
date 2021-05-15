import org.junit.Test;
import static org.junit.Assert.*;


public class SplayTreeMapTest {

    @Test
    public void get() {
        SplayTreeMap<String, String> splayTreeMap = new SplayTreeMap<String, String>();
        splayTreeMap.put("d'art", "de arte");
        splayTreeMap.put("adios", "bye");
        splayTreeMap.put("si", "yes");
        splayTreeMap.put("algo", "coin");
        splayTreeMap.put("helado", "ice cream");
        String temp = splayTreeMap.get("algo");
        assertEquals("No se obtiene correctamente", temp, "coin");
    }

    @Test
    public void put() {
        SplayTreeMap<String, String> splayTreeMap = new SplayTreeMap<String, String>();
        splayTreeMap.put("d'art", "de arte");
        splayTreeMap.put("adios", "bye");
        splayTreeMap.put("si", "yes");
        splayTreeMap.put("moneda", "coin");
        splayTreeMap.put("helado", "ice cream");
        String temp = splayTreeMap.get("d'art");
        assertEquals("No se ingresa correctamente", temp, "de arte");
    }
}