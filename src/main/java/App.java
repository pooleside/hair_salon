import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.List;


public class App {
    public static void main(String[] args) {
    	staticFileLocation("/public");
    	String layout = "templates/layout.vtl";

      get("/", (request, response) -> {
        HashMap<String, Object> model = new HashMap<String, Object>();
        model.put("stylists", Stylist.all());
        model.put("template", "templates/index.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      get("/hair_salon", (request, response) -> {
        HashMap<String, Object> model = new HashMap<String, Object>();
        String stylistName = request.queryParams("stylist");
        Stylist newStylist = new Stylist(stylistName);
        newStylist.save();
        model.put("stylists", Stylist.all());
        model.put("template", "templates/index.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      get("/clients/:id", (request, response) -> {
        HashMap<String, Object> model = new HashMap<String, Object>();
        String description = request.queryParams("description");
        int stylistId = Integer.parseInt(request.queryParams("stylistId"));
        Client newClient = new Client(description, stylistId);

        if (description != null){
          newClient.save();
        }

        model.put("stylists", Stylist.all());
        model.put("clients", Client.getClientsByStylistId(stylistId));
        model.put("stylist", Stylist.find(Integer.parseInt(request.params(":id"))));
        model.put("template", "templates/index.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      get("/stylists/:stylist_id/delete/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      int clientId = Integer.parseInt(request.params(":id"));
      Client.delete(clientId);
      Integer stylistId = Integer.parseInt(request.params(":stylist_id"));
      model.put("stylists", Stylist.all());
      model.put("stylist", Stylist.find(stylistId));
      model.put("clients", Client.getClientsByStylistId(stylistId));
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/delete/:stylistid", (request, response) -> {
        HashMap<String, Object> model = new HashMap<String, Object>();

        int stylistid = Integer.parseInt(request.params(":stylistid"));
        Stylist.delete(stylistid);
        model.put("stylists", Stylist.all());
        model.put("stylist", Stylist.find(stylistid));
        model.put("clients", Client.getClientsByStylistId(stylistid));
        model.put("template", "templates/index.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      get("/update/:stylist_id/:description/:id", (request, response) -> {
        HashMap<String, Object> model = new HashMap<String, Object>();
        Integer stylistid = Integer.parseInt(request.params(":stylist_id"));
        Client update = Client.find(Integer.parseInt(request.params(":id")));
        model.put("update", update);
        model.put("stylist", Stylist.find(stylistid));
        model.put("clients", Client.getClientsByStylistId(stylistid));
        model.put("stylitss", Stylist.all());
        model.put("template", "templates/index.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      get("/stylist/:stylist_id/update/:id", (request, response) -> {
        HashMap<String, Object> model = new HashMap<String, Object>();
        Integer stylistid = Integer.parseInt(request.params(":stylist_id"));
        String description = request.queryParams("description");
        Integer clientId = Integer.parseInt(request.params(":id"));
        Client.update(clientId, description);
        model.put("stylist", Stylist.find(stylistid));
        model.put("clients", Client.getClientsByStylistId(stylistid));
        model.put("stylists", Stylist.all());
        model.put("template", "templates/index.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

    }
}
