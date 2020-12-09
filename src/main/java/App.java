import models.Animal;
import models.EndangeredAnimal;
import models.Sighting;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

    public Sql2o sql2o = new Sql2o ("jdbc:postgresql://localhost:5432/wildlife_trackers", "moringa", "wangeci");
    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        staticFileLocation("/public");

            get("/", (request, response) -> {
                Map<String, Object> model = new HashMap<>();
                return new ModelAndView(model, "index.hbs");
            }, new HandlebarsTemplateEngine());

            get("/newVulnerable", (req, res) -> {
                Map<String, Object> model = new HashMap<>();
                return new ModelAndView(model, "EndangeredAnimalForm.hbs");
            }, new HandlebarsTemplateEngine());


        get("/Animals", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("nonEndangeredAnimals", Animal.getAllAnimals());
            return new ModelAndView(model, "Animals.hbs");
        }, new HandlebarsTemplateEngine());



        post("/endangeredAnimal", (request, response) -> {
                Map<String, Object> model = new HashMap<>();
                String animalName = request.queryParams("animalName");
                String animalGroupAge = request.queryParams("animalGroupAge");
                String animalCondition = request.queryParams("animalCondition");
                EndangeredAnimal newEndangeredAnimal = new EndangeredAnimal(animalName, animalGroupAge, animalCondition);
                newEndangeredAnimal.saveEndangered();
                model.put("newEndangeredAnimal", newEndangeredAnimal);
                return new ModelAndView(model, "AllAnimals.hbs");
            }, new HandlebarsTemplateEngine());

            get("/endangeredAnimal", (req, res) -> {
                Map<String, Object> model = new HashMap<>();
                model.put("endangeredAnimals", EndangeredAnimal.all());
                return new ModelAndView(model, "AllAnimals.hbs");
            }, new HandlebarsTemplateEngine());


            get("/newNonExtinct", (req, res) -> {
                Map<String, Object> model = new HashMap<>();
                return new ModelAndView(model, "Non-ExtinctForm.hbs");
            }, new HandlebarsTemplateEngine());

            post("/newNonExtinct", (request, response) -> {
                Map<String, Object> model = new HashMap<>();
                String animalName = request.queryParams("animalName");
                Animal animal = new Animal(animalName);
                animal.save();
                model.put("newNonEndangeredAnimal", animal);
                return new ModelAndView(model, "AllAnimals.hbs");
            }, new HandlebarsTemplateEngine());


            get("/sighting", (req, res) -> {
                Map<String, Object> model = new HashMap<>();
                return new ModelAndView(model, "Sightings-form.hbs");
            }, new HandlebarsTemplateEngine());

            post("/newSighting", (request, response) -> {
                Map<String, Object> model = new HashMap<>();
                String location = request.queryParams("location");
                String rangerName = request.queryParams("rangerName");
                Sighting newSighting = new Sighting(rangerName, location);
                newSighting.save();
                model.put("newSighting", newSighting);
                return new ModelAndView(model, "AllAnimals.hbs");
            }, new HandlebarsTemplateEngine());
        }

}


