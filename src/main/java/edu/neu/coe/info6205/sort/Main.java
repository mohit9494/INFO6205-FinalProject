package edu.neu.coe.info6205.sort;

import edu.neu.coe.info6205.util.FileReader;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {

    public static void main(String[] args) throws URISyntaxException, IOException {

        String fileName = "shuffledChinese.txt";
        System.out.println("******** tEST **********");
        String[] k = FileReader.fileReader(fileName);
        String[] a = FileReader.fileReader(fileName);
        // String[] k = {"Zebra", "Copper", "Kela", "Coward"};
        DualPivotQuicksort.sort(k);
        // MSDStringSort.sort(k);
        System.out.println(k[0]);
        System.out.println(k[1]);
        System.out.println(k[2]);
        System.out.println(k[3]);
        System.out.println(k[4]);

        System.out.println();
        ThreeWayRadixQuicksort.sort(a);

        System.out.println(a[0]);
        System.out.println(a[1]);
        System.out.println(a[2]);
        System.out.println(a[3]);
        System.out.println(a[4]);


     /*   Arrays.sort(k, Collator.getInstance(Locale.CHINA));
        System.out.println(k[0]);
        System.out.println(k[1]);
        System.out.println(k[2]);
        System.out.println(k[3]);
        System.out.println(k[400]);
        String second = k[400];*/

        // System.out.println(first == second);


    }


}
