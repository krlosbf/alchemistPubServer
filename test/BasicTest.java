import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {
    @Before public void setup(){
        Fixtures.deleteDatabase();
    }
    @Test
    public void testClient() {
        // Create a new user and save it
        /*new Client("Bob","p1").save();

        // Retrieve the user with e-mail address bob@gmail.com
        Client bob = Client.find("byNom", "Bob").first();

        // Test
        assertNotNull(bob);
        assertEquals("Bob", bob.nom);*/
    }

}
