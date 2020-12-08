package models;

import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

public class Sighting implements DatabaseManagement{
    private int animalId;
    private String location;
    private String rangerName;
    private int id;
    private Timestamp time;


    public Sighting(int animalId, String rangerName, String location) {
        this.animalId = animalId;
        this.rangerName = rangerName;
        this.location = location;
    }

    public int getAnimalId() {
        return animalId;
    }

    public String getLocation() {
        return location;
    }

    public String getRangerName() {
        return rangerName;
    }

    public Timestamp getTime() {
        return time;
    }

    public static List<Sighting> all() {
        String sql = "SELECT * FROM sightings;";
        try(Connection con = DB.sql2o.open()) {
            System.out.println(con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Sighting.class));
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Sighting.class);
        }
    }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sightings (animalId, rangerName, location, time) VALUES (:animalId, :rangerName, :location, now())";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("animalId", this.animalId)
                    .addParameter("rangerName", this.rangerName)
                    .addParameter("location", this.location)
                    .executeUpdate()
                    .getKey();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sighting sighting = (Sighting) o;
        return animalId == sighting.animalId &&
                location.equals(sighting.location) &&
                rangerName.equals(sighting.rangerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(animalId, location, rangerName);
    }

    public static Sighting find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sightings where id=:id";
            Sighting sighting = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Sighting.class);
            return sighting;
        }
    }

    public void delete() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "DELETE FROM sightings WHERE id = :id;";
            con.createQuery(sql)
                    .addParameter("id", this.id)
                    .executeUpdate();
        }
    }

}