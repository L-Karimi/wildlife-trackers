package models;

import org.sql2o.Connection;

import java.util.List;

public class EndangeredAnimal extends Animal implements DatabaseManagement{
    private String animalGroupAge;
    private String animalCondition;

    public static final String DATABASE_TYPE = "endangeredAnimal";

    public EndangeredAnimal(String animalName, String animalCondition, String animalGroupAge) {
        this.animalName = animalName;
        this.animalCondition = animalCondition;
        this.animalGroupAge = animalGroupAge;
        type = DATABASE_TYPE;
    }

    public String getAnimalGroupAge() {
        return animalGroupAge;
    }

    public String getAnimalCondition() {
        return animalCondition;
    }

    public static List<EndangeredAnimal> all() {
        String sql = "SELECT * FROM animals WHERE type='endangeredAnimal';";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(EndangeredAnimal.class);
        }
    }

    public static EndangeredAnimal find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals where id=:id";
            EndangeredAnimal animal = con.createQuery(sql)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(EndangeredAnimal.class);
            return animal;
        }
    }

    public void  saveAnimalGroupAge(String animalGroupAge){
        String sql ="UPDATE animals SET animalGroupAge=:animalGroupAge WHERE id=:id";
        try (Connection con = DB.sql2o.open()){
            con.createQuery(sql)
                    .addParameter("animalGroupAge", animalGroupAge)
                    .addParameter("id", this.id)
                    .executeUpdate();
        }
    }
    public void saveAnimalCondition(String animalCondition){
        String sql ="UPDATE animals SET animalCondition=:animalCondition WHERE id=:id";
        try (Connection con = DB.sql2o.open()){
            con.createQuery(sql)
                    .addParameter("animalCondition", animalCondition)
                    .addParameter("id", this.id)
                    .executeUpdate();
        }
    }



}