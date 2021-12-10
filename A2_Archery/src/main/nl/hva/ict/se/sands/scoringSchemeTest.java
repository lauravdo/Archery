package main.nl.hva.ict.se.sands;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class scoringSchemeTest {
    scoringScheme scoringScheme = new scoringScheme();

    @Test
    public void testEqual() {
        List<Archer> archerListTest = Archer.generateArchers(2);
        System.out.println(archerListTest);


        assertEquals(scoringScheme.compare(archerListTest.get(0), archerListTest.get(1)), -1);
      //  assertEquals(scoringScheme.compare(archerListTest.get(0), archerListTest.get(1)), 0);
  //      assertEquals(scoringScheme.compare(archerListTest.get(0), archerListTest.get(1)), 1);
    }

}

