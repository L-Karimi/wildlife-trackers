package models;

import org.junit.*;

import static org.junit.Assert.*;

public class NonEndangeredAnimalTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Rule
    public DatabaseRule database = new DatabaseRule();

//    @Test
//    public void nonEndangeredAnimal_instantiatesCorrectlyWithObjects_true() {
//        NonEndangeredAnimal testNonEndangeredAnimal = new NonEndangeredAnimal("mongoose", "young", "adult");
//        Assert.assertTrue(true);
//    }
//    @Test
//    public void nonEndangeredAnimal_getsAnimalNameCorrectly_true() {
//        NonEndangeredAnimal testNonEndangeredAnimal = new NonEndangeredAnimal("Mongoose", "young", "healthy");
//        assertEquals("Mongoose",testNonEndangeredAnimal.getAnimalName());
//    }
//
//    @Test
//    public void nonEndangeredAnimal_getsAnimalAgeCorrectly_true() {
//        NonEndangeredAnimal testNonEndangeredAnimal = new NonEndangeredAnimal("Mongoose", "young", "healthy");
//        assertEquals("young", testNonEndangeredAnimal.getAnimalGroupAge());
//    }
//
//    @Test
//    public void NonEndangeredAnimal_instantiatesWithAnimalId_int() {
//        NonEndangeredAnimal testNonEndangeredAnimal = new NonEndangeredAnimal("Mongoose", "newborn", "healthy");
//        assertEquals("healthy", testNonEndangeredAnimal.getAnimalCondition());
//    }
//
//    @Test
//    public void save_successfullyAddsNonEndangeredAnimalToDatabase_List() {
//        NonEndangeredAnimal testNonEndangeredAnimal = new NonEndangeredAnimal("Mongoose","young", "healthy");
//        testNonEndangeredAnimal.save();
//        assertTrue(NonEndangeredAnimal.all().get(0).equals(testNonEndangeredAnimal));
//    }
//
//    @Test
//    public void save_assignsIdToNonEndangeredAnimal() {
//        NonEndangeredAnimal testNonEndangeredAnimal = new NonEndangeredAnimal("Mongoose", "young", "healthy");
//        testNonEndangeredAnimal.save();
//        NonEndangeredAnimal savedNonEndangeredAnimal = NonEndangeredAnimal.all().get(0);
//        assertEquals(savedNonEndangeredAnimal.getId(), testNonEndangeredAnimal.getId());
//    }
//
//    @Test
//    public void all_returnsAllInstancesOfNonEndangeredAnimal_true() {
//        NonEndangeredAnimal firstNonEndangeredAnimal = new NonEndangeredAnimal("Mongoose", "young", "healthy");
//        firstNonEndangeredAnimal.save();
//        NonEndangeredAnimal secondNonEndangeredAnimal = new NonEndangeredAnimal("Plain Zebra",  "young", "okay");
//        secondNonEndangeredAnimal.save();
//        assertEquals(true, NonEndangeredAnimal.all().get(0).equals(firstNonEndangeredAnimal));
//        assertEquals(true, NonEndangeredAnimal.all().get(1).equals(secondNonEndangeredAnimal));
//    }
//
//    @Test
//    public void find_returnsNonEndangeredAnimalWithSameId_secondNonEndangeredAnimal() {
//        NonEndangeredAnimal firstNonEndangeredAnimal = new NonEndangeredAnimal("Mongoose", "young", "healthy");
//        firstNonEndangeredAnimal.save();
//        NonEndangeredAnimal secondNonEndangeredAnimal = new NonEndangeredAnimal("Plain Zebra", "Adult", "ill");
//        secondNonEndangeredAnimal.save();
//        assertEquals(NonEndangeredAnimal.find(secondNonEndangeredAnimal.getId()), secondNonEndangeredAnimal);
//    }
//
//
}
