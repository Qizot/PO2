package pl.edu.agh.to.lab4;

import org.junit.Test;
import pl.edu.agh.to.lab4.provider.PrisonersDatabase;

import static org.junit.Assert.assertEquals;

public class PrisonerDatabaseTest {

    private PrisonersDatabase prisonersDatabase = new PrisonersDatabase();

    @Test
    public void testThereAreThreeJails() {
        assertEquals(3, prisonersDatabase.getAllPrisons().size());
    }
}
