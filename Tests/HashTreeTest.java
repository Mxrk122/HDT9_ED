import org.junit.Test;
import static org.junit.Assert.*;

public class HashTreeTest {

    @Test
    public void get() {
        HashTree<String, String> hashMap = new HashTree<String, String>();
        hashMap.put("d'art", "de arte");
        hashMap.put("adios", "bye");
        hashMap.put("si", "yes");
        hashMap.put("algo", "coin");
        hashMap.put("helado", "ice cream");
        String temp = hashMap.get("algo");
        assertEquals("No se ingresa correctamenthashMape", temp, "coin");
    }

    @Test
    public void put() {
        HashTree<String, String> hashMap = new HashTree<String,String>();
        hashMap.put("d'art", "de arte");
        hashMap.put("adios", "bye");
        hashMap.put("si", "yes");
        hashMap.put("delta", "equis");
        hashMap.put("helado", "ice cream");
        String temp = hashMap.get("adios");
        assertEquals("No se ingresa correctamente", temp, "bye");
    }
}