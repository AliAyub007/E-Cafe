import main.java.Menu;
import org.junit.Test;


import static main.java.main.getTime;
import static main.java.main.isOpen;
import static org.junit.Assert.assertTrue;

public class cafeTest {

    static String time;

    @Test
    public void testSalutationMessage() {
        Menu menu = new Menu();
        time = getTime();
        boolean check = isOpen();
        String[] timeBreak = time.split(":");
        if(Integer.parseInt(timeBreak[0]) >= 11 && Integer.parseInt(timeBreak[0]) < 22){
            assertTrue(check);
        }

    }
}
