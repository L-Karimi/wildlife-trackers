package models;

import org.sql2o.Connection;

import java.util.List;

public class NonEndangeredAnimal extends Animal implements DatabaseManagement {

    public static final String HEALTHY ="healthy";
    public static final String OKAY ="okay";
    public static final String ILL ="ill";
    public static final String NEWBORN ="newborn";
    public static final String YOUNG ="young";
    public static final String ADULT ="adult";

    private String animalGroupAge;
    private String animalCondition;

    public static final String DATABASE_TYPE = "NonEndangeredAnimal";

    public NonEndangeredAnimal(String animalName, String animalGroupAge, String animalCondition) {
        this.animalName = animalName;
        this.animalGroupAge = animalGroupAge;
        this.animalCondition = animalCondition;
        type = DATABASE_TYPE;
    }

    public String getAnimalGroupAge() {
        return animalGroupAge;
    }

    public String getAnimalCondition() {
        return animalCondition;
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


    public static List<NonEndangeredAnimal> all() {
        String sql = "SELECT * FROM animals WHERE type='NonEndangeredAnimal';";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(NonEndangeredAnimal.class);
        }
    }

    public static NonEndangeredAnimal find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals where id=:id";
            NonEndangeredAnimal animal = con.createQuery(sql)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(NonEndangeredAnimal.class);
            return animal;
        }
    }
}