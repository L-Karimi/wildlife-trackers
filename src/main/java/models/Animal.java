package models;

import org.sql2o.Connection;

import java.util.Objects;

public abstract class Animal {
    public String animalName;
    public String type;
    public int id;


    public String getAnimalName() {
        return animalName;
    }


    public int getId() {
        return id;
    }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (animalName, type) VALUES (:animalName, :type)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("animalName", this.animalName)
                    .addParameter("type", this.type)
                    .executeUpdate()
                    .getKey();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return animalName.equals(animal.animalName) &&
                type.equals(animal.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(animalName, type);
    }

    public void delete() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "DELETE FROM animals WHERE id = :id;";
            con.createQuery(sql)
                    .addParameter("id", this.id)
                    .executeUpdate();
        }
    }

}