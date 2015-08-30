import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Rule;

public class ClientTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void all_emptyAtFirst() {
    assertEquals(Client.all().size(), 0);
  }
  @Test
  public void equals_returnsTrueIfDescriptionsAreTheSame() {
    Client firstClient = new Client("John B", 1);
    Client secondClient = new Client("John B", 1);
    assertTrue(firstClient.equals(secondClient));
  }
  @Test
  public void save_returnsTrueIfDescriptionsAreTheSame() {
    Client myClient = new Client("John B", 1);
    myClient.save();
    assertTrue(Client.all().get(0).equals(myClient));
  }
  @Test
  public void save_assignsIdToObject() {
    Client myClient = new Client("John B", 1);
    myClient.save();
    Client savedClient = Client.all().get(0);
    assertEquals(myClient.getId(), savedClient.getId());
  }

  @Test
  public void find_findsClientInDatabase_true() {
    Client myClient = new Client("John B", 1);
    myClient.save();
    Client savedClient = Client.find(myClient.getId());
    assertTrue(myClient.equals(savedClient));
  }

  @Test
  public void save_savesStylistIdIntoDB_true() {
    Stylist myStylist = new Stylist("Julie");
    myStylist.save();
    Client myClient = new Client("John B", myStylist.getId());
    myClient.save();
    Client savedClient = Client.find(myClient.getId());
    assertEquals(savedClient.getStylistId(), myStylist.getId());
  }

  @Test
  public void update_newClientDescription() {
    Stylist myStylist = new Stylist("Julie");
    myStylist.save();
    Client myClient = new Client("John B", myStylist.getId());
    myClient.save();
    Client update = new Client("John Bell", myStylist.getId());
    myClient.update(update.getId(), update.getDescription());
    assertTrue(update.getDescription() == "John Bell");
  }

  @Test
  public void delete_deletesClientById_true() {
    Stylist myStylist = new Stylist("Julie");
    myStylist.save();
    Client myClient = new Client("John B", myStylist.getId());
    myClient.save();
    Client.delete(myClient.getId());
    assertTrue(Client.all().size() == 0);
}


 }
