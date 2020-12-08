
import models.*;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;
public class App {
    public static void main(String[] args){

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/newVulnerable", (req, res)->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "EndangeredAnimalForm.hbs");
        }, new HandlebarsTemplateEngine());

        post("/endangeredAnimal", (request, response) ->{
            Map<String, Object> model = new HashMap<>();
            String animalName = request.queryParams("animalName");
            int age = Integer.parseInt(request.queryParams("age"));
            int animalId = Integer.parseInt(request.queryParams("animalId"));
            String animalGroupAge = request.queryParams("animalGroupAge");
            String animalCondition = request.queryParams("animalCondition");
            EndangeredAnimal newEndangeredAnimal = new EndangeredAnimal(animalName, animalGroupAge, animalCondition);
            model.put("newEndangeredAnimal", newEndangeredAnimal);
            return new ModelAndView(model, "AllAnimals.hbs");
        }, new HandlebarsTemplateEngine());

        get("/endangeredAnimal", (req, res)->{
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "AllAnimals.hbs");
        }, new HandlebarsTemplateEngine());


        get("/newNonExtinct", (req, res)->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "Non-ExtinctForm.hbs");
        }, new HandlebarsTemplateEngine());

        post("/newNonExtinct", (request, response) ->{
            Map<String, Object> model = new HashMap<>();
            String animalName = request.queryParams("animalName");
            int age = Integer.parseInt(request.queryParams("age"));
            int animalId = Integer.parseInt(request.queryParams("animalId"));
            String animalGroupAge = request.queryParams("animalGroupAge");
            String animalCondition = request.queryParams("animalCondition");
            NonEndangeredAnimal newNonEndangeredAnimal = new NonEndangeredAnimal(animalName, animalGroupAge, animalCondition);
            model.put("newNonEndangeredAnimal", newNonEndangeredAnimal);
            return new ModelAndView(model, "AllAnimals.hbs");
        }, new HandlebarsTemplateEngine());

    }
    }

