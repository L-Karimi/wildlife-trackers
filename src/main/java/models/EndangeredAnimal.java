package models;

import org.sql2o.Connection;

import java.util.List;

public class EndangeredAnimal {
    private int id;
    private String animalName;
    private String animalGroupAge;
    private String animalCondition;

    public static final String DATABASE_TYPE = "endangeredAnimal";

    public String type;

    public EndangeredAnimal(String animalName, String animalCondition, String animalGroupAge) {
        this.animalName = animalName;
        this.animalGroupAge= animalGroupAge;
        this.animalCondition = animalCondition;
        setType(DATABASE_TYPE);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalGroupAge() {
        return animalGroupAge;
    }

    public void setAnimalGroupAge(String animalGroupAge) {
        this.animalGroupAge = animalGroupAge;
    }

    public String getAnimalCondition() {
        return animalCondition;
    }

    public void setAnimalCondition(String animalCondition) {
        this.animalCondition = animalCondition;
    }

    public static String getDatabaseType() {
        return DATABASE_TYPE;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static List<EndangeredAnimal> all() {
        String sql = "SELECT * FROM animals WHERE type='endangeredAnimal';";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
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
        this.animalGroupAge = animalGroupAge;
        String sql ="UPDATE animals SET animalGroupAge=:animalGroupAge WHERE id=:id";
        try (Connection con = DB.sql2o.open()){
            con.createQuery(sql)
                    .addParameter("animalGroupAge", animalGroupAge)
                    .addParameter("id", this.id)
                    .executeUpdate();
        }
    }
    public void saveAnimalCondition(String animalCondition){
        this.animalCondition = animalCondition;
        String sql ="UPDATE animals SET animalCondition=:animalCondition WHERE id=:id";
        try (Connection con = DB.sql2o.open()){
            con.createQuery(sql)
                    .addParameter("animalCondition", animalCondition)
                    .addParameter("id", this.id)
                    .executeUpdate();
        }
    }

    public void saveEndangered() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (type, animalName, animalCondition, animalGroupAge) VALUES (:type,:animalName, :animalCondition, :animalGroupAge)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("type", this.type)
                    .addParameter("animalName", this.animalName)
                    .addParameter("animalCondition", this.animalCondition)
                    .addParameter("animalGroupAge", this.animalGroupAge)
                    .executeUpdate()
                    .getKey();
            setId(id);
        }
    }



}