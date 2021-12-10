package test;

import main.nl.hva.ict.se.sands.Archer;
import main.nl.hva.ict.se.sands.ChampionSelector;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class ChampionSelectorTest {
    protected Comparator<Archer> comparator;

    @BeforeEach
    public void createComparator() {
        // Instantiate your own comparator here...
        // comparator = new .....();


        comparator = new Comparator<Archer>() {
            @Override
            public int compare(Archer a, Archer b) {
                if (a.getTotalScore() != b.getTotalScore()) {
                    return a.getTotalScore() - b.getTotalScore();
                }
                //if total score is a draw
                if (a.getTens() != b.getTens()) {
                    return a.getTens() - b.getTens();
                }
                //if total score is a draw and a b have equal tens
                if (a.getNines() != b.getNines()) {
                    return a.getNines() - b.getNines();
                }
                //total score draw, and has equal tens & nines
                return Archer.getId() - Archer.getId();

            }

        };
    }



    @Test
    public void selInsSortAndCollectionSortResultInSameOrder() {
        List<Archer> unsortedArchersForSelIns = Archer.generateArchers(23);
        List<Archer> unsortedArchersForCollection = new ArrayList<>(unsortedArchersForSelIns);

        List<Archer> sortedArchersSelIns = ChampionSelector.selInsSort(unsortedArchersForSelIns, comparator);
        List<Archer> sortedArchersCollection = ChampionSelector.collectionSort(unsortedArchersForCollection, comparator);

        assertEquals(sortedArchersCollection, sortedArchersSelIns);
    }

}
