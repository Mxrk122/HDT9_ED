import org.junit.Test;

import static org.junit.Assert.*;

public class SplayTreeMapTest {

    @Test
    public void get() {
    }

    @Test
    public void put() {
        SplayTreeMap<String, String> splayTreeMap = new SplayTreeMap<String, String>();
        splayTreeMap.put("hola", "hello");
        splayTreeMap.put("adios", "bye");
        splayTreeMap.put("si", "yes");
        splayTreeMap.put("moneda", "coin");
        splayTreeMap.put("helado", "ice cream");
        String temp = splayTreeMap.get("helado");
        System.out.println(temp);
        assertEquals(temp, "ice cream");
    }

    @Test
    public void splay() {
    }
}