package models;

import org.junit.*;

import static org.junit.Assert.*;

public class EndangeredAnimalTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void endangeredAnimal_instantiatesCorrectlyWithObjects_true() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Eagle", "healthy", "young");
        Assert.assertTrue(true);
    }

    @Test
    public void endangeredAnimal_getsAnimalNameCorrectly_true() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Eagle", "healthy", "young");
        assertEquals("Eagle",testEndangeredAnimal.getAnimalName());
    }

    @Test
    public void endangeredAnimal_getsAnimalAgeCorrectly_true() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Eagle", "healthy", "young");
        assertEquals("young", testEndangeredAnimal.getAnimalGroupAge());
    }

    @Test
    public void endangeredAnimal_instantiatesWithAnimalCondition_true() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Eagle", "healthy", "young");
        assertEquals("healthy", testEndangeredAnimal.getAnimalCondition());
    }


    @Test
    public void save_successfullyAddsEndangeredAnimalToDatabase_List() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Eagle", "healthy", "young");
        testEndangeredAnimal.save();
        assertTrue(EndangeredAnimal.all().get(0).equals(testEndangeredAnimal));
    }

    @Test
    public void save_assignsIdToEndangeredAnimal() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Eagle", "health", "young");
        testEndangeredAnimal.save();
        EndangeredAnimal savedEndangeredAnimal = EndangeredAnimal.all().get(0);
        assertEquals(savedEndangeredAnimal.getId(), testEndangeredAnimal.getId());
    }

    @Test
    public void all_returnsAllInstancesOfEndangeredAnimal_true() {
        EndangeredAnimal firstEndangeredAnimal = new EndangeredAnimal("Eagle", "health", "young");
        firstEndangeredAnimal.save();
        EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("Lion", "health", "young");
        secondEndangeredAnimal.save();
        assertEquals(true, EndangeredAnimal.all().get(0).equals(firstEndangeredAnimal));
        assertEquals(true, EndangeredAnimal.all().get(1).equals(secondEndangeredAnimal));
    }

    @Test
    public void find_returnsEndangeredAnimalWithSameId_secondEndangeredAnimal() {
        EndangeredAnimal firstEndangeredAnimal = new EndangeredAnimal("Eagle", "health", "young");
        firstEndangeredAnimal.save();
        EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("Lion",  "health", "young");
        secondEndangeredAnimal.save();
        assertEquals(EndangeredAnimal.find(secondEndangeredAnimal.getId()), secondEndangeredAnimal);
    }
}
