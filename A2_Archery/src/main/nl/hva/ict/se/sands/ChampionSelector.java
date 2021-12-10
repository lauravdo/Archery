package main.nl.hva.ict.se.sands;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.*;


/**
 * Given a list of Archer's this class can be used to sort the list using one of three sorting algorithms.
 * Note that you are NOT allowed to change the signature of these methods! Adding method is perfectly fine.
 */
public class ChampionSelector {
    /**
     * This method uses either selection sort or insertion sort for sorting the archers.
     */
    public static List<Archer> selInsSort(List<Archer> archers, Comparator<Archer> scoringScheme) {
        // first we set the loop to loop through the entire list of archers
        for (int i = 1; i < archers.size(); i++) {
            Archer elt_i = archers.get(i);
            int j = i;
            // if element is bigger than 0 we can proceed, this is because in insertion sort we assume that the first element is already sorted
            while (j > 0) {
                //pick next element and store it in key
                Archer elt_j = archers.get(j - 1);
                //compare key with all elements in sorted array if its smaller move to next element otherwise shift greater elements to the right
                if (scoringScheme.compare(elt_i, elt_j) <= 0)

                break;
                //inset the value
                archers.set(j, elt_j);
                j--;
            }
            /* now we repeat until the array is sorted */
            archers.set(j, elt_i);
        }
        // return sorted archers
    return archers;
    }

    private static int partition (List<Archer> list, Comparator<Archer> scoringScheme, int begin, int end) {
        //pick an archer from the list to be the pivot
        Archer pivot = list.get(end);
        int i = begin - 1;

        for (int j = begin; j < end; j++){
            //if current element is bigger than pivot ( we do this so the list sorts in descending order )
            if(scoringScheme.compare(list.get(j), pivot) > 0 ){


                    i++; //increment index of element
                    Archer swapTemp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, swapTemp);


        }
        }
        Archer swapTemp = list.get(i+1);
        list.set(i+1, list.get(end));
        list.set(end,swapTemp);

        return i+1;
    }






    public static List<Archer> quickSort(List<Archer> archers, Comparator<Archer> scoringScheme) {
        int begin = 0;
        int end = archers.size() - 1;

        List<Archer> result = new ArrayList<Archer>(archers);
        qsort(result,scoringScheme,begin,end);

        return result;
    }

    /**
     * This method uses the Java collections sort algorithm for sorting the archers.
     */
    public static List<Archer> collectionSort(List<Archer> archers, Comparator<Archer> scoringScheme) {
      Collections.sort(archers,Collections.reverseOrder(new scoringScheme()));
       return archers;
    }

    private static void qsort (List<Archer> archers, Comparator<Archer> scoringScheme, int begin, int end){
        if(begin < end){
            int partitionIndex = partition(archers,scoringScheme,begin,end); // partitioning index
            qsort(archers,scoringScheme,begin,partitionIndex-1);
            qsort(archers,scoringScheme,partitionIndex + 1, end);

        }
    }



}
