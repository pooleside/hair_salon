import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;

public class StylistTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void all_emptyAtFirst() {
    assertEquals(Stylist.all().size(), 0);
  }

    @Test
    public void equals_returnsTrueIfNamesAretheSame() {
      Stylist firstStylist = new Stylist("Julie");
      Stylist secondStylist = new Stylist("Julie");
      assertTrue(firstStylist.equals(secondStylist));
    }
    @Test
    public void save_savesIntoDatabase_true() {
    Stylist myStylist = new Stylist("Julie");
    myStylist.save();
    assertTrue(Stylist.all().get(0).equals(myStylist));
  }
    @Test
    public void find_findStylistInDatabase_true() {
    Stylist myStylist = new Stylist("Julie");
    myStylist.save();
    Stylist savedStylist = Stylist.find(myStylist.getId());
    assertTrue(myStylist.equals(savedStylist));
  }
  @Test
  public void getClients_retreivesAllClientsFromDatabase_clientsList() {
    Stylist myStylist = new Stylist("Julie");
    myStylist.save();
    Client firstClient = new Client("Sam M", myStylist.getId());
    firstClient.save();
    Client secondClient = new Client("Melissa Z", myStylist.getId());
    secondClient.save();
    Client[] clients = new Client[] { firstClient, secondClient };
    assertTrue(myStylist.getClients().containsAll(Arrays.asList(clients)));

  }


  }
