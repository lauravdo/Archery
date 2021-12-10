package main.nl.hva.ict.se.sands;




import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Holds the name, archer-id and the points scored for 30 arrows.
 * <p>
 * Archers MUST be created by using one of the generator methods. That is way the constructor is private and should stay
 * private. You are also not allowed to add any constructor with an access modifier other then private unless it is for
 * testing purposes in which case the reason why you need that constructor must be contained in a very clear manner
 * in your report.
 */
public class Archer {

    public final static int MAX_ARROWS = 3;
    public final static int MAX_ROUNDS = 10;
    private static final AtomicInteger sequence = new AtomicInteger(135788);
    private static final Random randomizer = new Random();
    final private int id; // Once assigned a value this attribute is not allowed to change.
    private final String firstName;
    private final String lastName;

    private final int[][] scores = new int[MAX_ROUNDS][MAX_ARROWS];
    public static int[] dummyScores = {10,20,40};




    /**
     * Constructs a new instance of Archer and assigns a unique ID to the instance. The ID is not allowed to ever
     * change during the lifetime of the instance! For this you need to use the correct Java keyword. Each new instance
     * is a assigned a number that is 1 higher than the last one assigned. The first instance created should have
     * ID 135788;
     *
     * @param firstName the archers first name.
     * @param lastName  the archers surname.
     * @param id the archers id
     */
    protected Archer(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;


    }

    public static int getId() {

        return sequence.incrementAndGet();
    }



    /**
     * This methods creates a List of archers. This method takes care of assigning each arhcher
     * a first name, surname and lets them should 30 arrows.
     *
     * @param nrOfArchers the number of archers in the list.
     * @return a list of archers
     */
    public static List<Archer> generateArchers(int nrOfArchers) {
        List<Archer> archers = new ArrayList<>(nrOfArchers);
        for (int i = 0; i < nrOfArchers; i++) {
            Archer archer = new Archer(Names.nextFirstName(), Names.nextSurname(), getId());
            letArcherShoot(archer);
            archers.add(archer);
        }
        return archers;

    }


    public static void letArcherShoot(Archer archer) {

        for (int round = 0; round < MAX_ROUNDS; round++) {
            archer.registerScoreForRound(round,shootOneRound());

            // only uncomment this for unit testing so all archers can have their score controlled
           // archer.registerScoreForRound(round,dummyScores);
        }
    }

    private static int[] shootOneRound() {
        int[] points = new int[MAX_ARROWS];

        for (int arrow = 0; arrow < MAX_ARROWS; arrow++) {
            points[arrow] = shootArrow();
        }
        return points;
    }

    private static int shootArrow() {
        return 1 + randomizer.nextInt(10);
    }



    /*
    The code below is their for your own convenience. You don't have include it in your report.
     */

    /**
     * Registers the point for each of the three arrows that have been shot during a round. The <code>points</code>
     * parameter should hold the three points, one per arrow.
     *
     * @param round  the round for which to register the points, zero based.
     * @param points the points shot during the round.
     */
    public void registerScoreForRound(int round, int[] points) {
        assert points.length == MAX_ARROWS;
        scores[round] = points;

    }

    public int getTotalScore() {
        int accumulator = 0;

        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < MAX_ARROWS; j++) {
                accumulator += scores[i][j];
            }
        }

        return accumulator;
    }

    /**
     * Returns the number of 10's scored by this archer.
     *
     * @return the number of 10's for this archer.
     */
    public int getTens() {
        int ten = 10;
        int amountofTens = 0;
        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores[i].length; j++) {

                if (scores[i][j] == 10) {
                    amountofTens++;
                }
            }


        }
        return amountofTens;
    }
    /**
     * Returns the number of 9's scored by this archer.
     *
     * @return the number of 9's for this archer.
     */
    public int getNines() {
        int nine = 9;
        int amountofNines = 0;
        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores[i].length; j++) {

                if (scores[i][j] == 9) {
                    amountofNines++;
                }

            }

        }
        return amountofNines;
    }
    @Override
    public String toString() {
        return this.id + " " + "(" + this.getTotalScore() +")" + " " + this.firstName + " " + this.lastName;
    }
}

class scoringScheme implements Comparator<Archer> {
    public int compare(Archer a, Archer b) {

        if (a.getTotalScore() != b.getTotalScore()){
            return a.getTotalScore() - b.getTotalScore();
        }
        //if total score is a draw
        if (a.getTens() != b.getTens()){
            return a.getTens() - b.getTens();
        }
        //if total score is a draw and a b have equal tens
        if (a.getNines() != b.getNines()){
            return a.getNines() - b.getNines();
        }
        //total score draw, and has equal tens & nines
            return Archer.getId() - Archer.getId();
        }
    }

