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

    public Client(String description, int stylistId) {
    this.description = description;
    this.stylistId = stylistId;
  }

  @Override
    public boolean equals(Object otherClient) {
      if(!(otherClient instanceof Client)) {
        return false;
      } else {
        Client newClient = (Client) otherClient;
        return this.getDescription().equals(newClient.getDescription()) &&
              this.getId() == newClient.getId() &&
              this.getStylistId() == newClient.getStylistId();
    }
  }

      public static List<Client> all() {
        String sql = "SELECT id, description, stylistid FROM clients";
        try (Connection con = DB.sql2o.open()) {
          return con.createQuery(sql).executeAndFetch(Client.class);
    }
  }

      public void save() {
        try(Connection con = DB.sql2o.open()) {
          String sql = "INSERT INTO clients (description, stylistid) VALUES (:description, :stylistid)";
          this.id = (int) con.createQuery(sql, true)
          .addParameter("description", this.description)
          .addParameter("stylistid", this.stylistId)
          .executeUpdate()
          .getKey();
    }
  }
      public static Client find(int id) {
        try(Connection con = DB.sql2o.open()) {
          String sql = "SELECT * FROM clients WHERE id=:id";
          Client client = con.createQuery(sql)
            .addParameter("id", id)
            .executeAndFetchFirst(Client.class);
          return client;
    }
  }

      public static void update(int id, String description) {
        try(Connection con = DB.sql2o.open()) {
          String sql = "UPDATE clients SET description = :description WHERE id = :id";
          con.createQuery(sql)
          .addParameter("description", description)
          .addParameter("id", id)
          .executeUpdate();
    }
  }
      public static void delete (int id) {
        try (Connection con = DB.sql2o.open()) {
          String sql = "DELETE FROM clients WHERE id=:id;";
          con.createQuery(sql)
          .addParameter("id", id)
          .executeUpdate();
    }
  }

      public static List<Client> getClientsByStylistId(int stylistId) {
        String sql = "SELECT * FROM clients WHERE stylistid=" + stylistId;
        try (Connection con = DB.sql2o.open()) {
        return con.createQuery(sql).executeAndFetch(Client.class);
    }
  }

}
