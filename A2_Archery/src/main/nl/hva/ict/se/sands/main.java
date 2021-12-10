package main.nl.hva.ict.se.sands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class main {


    public static final void main(String[] arg) {
        long start, end;
        List<Archer> archerList = Archer.generateArchers(100);
        List<Archer> archerList1 = new ArrayList<Archer>(archerList);
        List<Archer> archerList2 = new ArrayList<Archer>(archerList);

        //    System.out.println(archerList);
        //   System.out.println(archerList1);
        //  System.out.println(archerList2);
        scoringScheme scoringScheme = new scoringScheme();
//
//        long totalRuntimeQuickSort = 0;
//        for (int i = 0; i < 10; i++) {
//
//            start = System.currentTimeMillis();
//            List<Archer> sortedArcherlist = ChampionSelector.quickSort(archerList1, scoringScheme);
//            end = System.currentTimeMillis();
//            totalRuntimeQuickSort += (end - start);
//            Collections.shuffle(archerList);
//            //    System.out.println(sortedArcherlist);
//        }
//        System.out.println("Quicksort on average took " + totalRuntimeQuickSort / 10 + " Miliseconds");
//
//        long totalRuntimeInsertionSort = 0;
//        for (int i = 0; i < 10; i++) {
//            start = System.currentTimeMillis();
//            ChampionSelector.selInsSort(archerList, scoringScheme);
//            end = System.currentTimeMillis();
//            totalRuntimeInsertionSort += (end - start);
//            Collections.shuffle(archerList1);
//
//        }
//        System.out.println("Insertion sort on average took: " + totalRuntimeInsertionSort / 10 + " Miliseconds");
//
        long totalRuntimeCollectionSort = 0;
        for (int i = 0; i < 10; i++) {
            start = System.currentTimeMillis();
            ChampionSelector.collectionSort(archerList2, scoringScheme);
            end = System.currentTimeMillis();
            totalRuntimeCollectionSort += (end - start);
            Collections.shuffle(archerList2);


        }
        System.out.println("collection sort on average took: " + totalRuntimeCollectionSort / 10 + " Miliseconds");
//
//    }

    }
}