package models;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class SightingTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

//    @Test
//    public void sighting_instantiatesCorrectly_true() {
//        Sighting testSighting = new Sighting(1, "George", "Zone B");
//        Assert.assertTrue(true);
//    }
//
//    @Test
//    public void sighting_instantiatesWithAnimalId_true() {
//        Sighting testSighting = new Sighting(1, "George", "Zone A");
//        assertEquals(1, testSighting.getAnimalId());
//    }
//
//    @Test
//    public void sighting_instantiatesCorrectlyWithLocation() {
//        Sighting testSighting = new Sighting(1, "George", "Zone C");
//        assertEquals("Zone C", testSighting.getLocation());
//    }
//
//    @Test
//    public void sighting_instantiatesCorrectlyWithRangerName_rangerName() {
//        Sighting testSighting = new Sighting(1, "George", "Zone C");
//        assertEquals("George", testSighting.getRangerName());
//    }
//
//    @Test
//    public void equals_returnsTrueIfAnimalIdRangerNameAndLocationAreTheSame_true() {
//        Sighting firstPerson = new Sighting(1, "George", "Zone A");
//        Sighting secondPerson = new Sighting(1, "George", "Zone A");
//        assertEquals(true, firstPerson.equals(secondPerson));
//    }
//
//    @Test
//    public void save_insertsObjectIntoDatabase_() {
//        Sighting testSighting = new Sighting(1, "George", "Zone B");
//        testSighting.save();
//        assertTrue(Sighting.all().get(0).equals(testSighting));
//    }
//
//
//    @Test
//    public void all_returnsAllInstancesOfSighting_true() {
//        Sighting firstSighting = new Sighting(1, "George", "Zone A");
//        firstSighting.save();
//        Sighting secondSighting = new Sighting(1, "Vivian", "Zone B");
//        secondSighting.save();
//        assertEquals(true, Sighting.all().get(0).equals(firstSighting));
//        assertEquals(true, Sighting.all().get(1).equals(secondSighting));
//    }

}
