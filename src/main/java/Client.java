import java.util.List;
import org.sql2o.*;

public class Client {
  private int id;
  private int stylistId;
  private String description;

  public int getId() {
      return id;
    }

    public int getStylistId(){
      return stylistId;
    }

    public String getDescription() {
      return description;
    }
}
