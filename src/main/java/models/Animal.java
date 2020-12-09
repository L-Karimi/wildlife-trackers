package models;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import java.util.List;
import java.util.Objects;
public class Animal {
    private int id;
    private String animalName;
    public String type;
    private final String DATABASE_TYPE = "animal";

    public Animal(String animalName) {
        this.animalName = animalName;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDATABASE_TYPE() {
        return DATABASE_TYPE;
    }

    @Override
    public boolean equals (Object otherAnimals){
        if (!(otherAnimals instanceof Animal)){
            return false;
        }else{
            Animal newAnimals = (Animal) otherAnimals;
            return this.getAnimalName().equals(newAnimals.getAnimalName()) &&
                    this.getId() == newAnimals.getId();
        }
    }
    public static List<Animal> getAllAnimals(){
        String sql = "SELECT * FROM animals where type='animal';";
        try (Connection con = DB.sql2o.open()){
            return   con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Animal.class);
        }
    }
    public void save() {
        try (Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO animals (animalName, type) VALUES (:animalName, :type)";
            this.id = (int) con.createQuery(sql,true)
                    .addParameter("animalName", this.animalName)
                    .addParameter("type", this.type)
                    .executeUpdate()
                    .getKey();
            setId(id);
        }
    }
    public void delete(){
        try (Connection con = DB.sql2o.open()){
            String sql = "DELETE FROM animals WHERE id =:id;";
            con.createQuery(sql)
                    .addParameter("id", this.id)
                    .executeUpdate();
        }
    }
}


















