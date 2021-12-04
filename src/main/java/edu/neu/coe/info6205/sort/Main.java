package edu.neu.coe.info6205.sort;

import edu.neu.coe.info6205.benchmark.Benchmark_Timer;
import edu.neu.coe.info6205.sort.api.StringSortAPI;
import edu.neu.coe.info6205.sort.huskysort.HuskyCoderFactory;
import edu.neu.coe.info6205.sort.huskysort.PureHuskySort;
import edu.neu.coe.info6205.util.FileReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Locale;

public class Main {


    public static void main(String[] args) throws URISyntaxException, IOException {

        //read complete 4 million
        String[] input = FileReader.fileReader("shuffledChinese.txt");

        //Start benchmark with chinese
        benchmarkHuskySort(input);
        benchmarkTimSort(input,Locale.CHINESE);
        benchmarkDualPivotQuickSort(input,Locale.CHINESE);
        benchmarkLSDSort(input,true);
        benchmarkMSDSort(input,true);
        benchmarkThreeWayRadixSort(input,true);

    }



    private static void benchmarkHuskySort(String[] dataSet){
        Benchmark_Timer<String[]> benchmarkTimer = new Benchmark_Timer<>(
                "Husky Sort Test",
                array -> new PureHuskySort<>(HuskyCoderFactory.asciiCoder, false, false)
                        .sort(array));
        double randomSortTime = benchmarkTimer.runFromSupplier(dataSet::clone, 10);
        System.out.println("Husky Sort Average Sort Time for dataset of size "+dataSet.length+" = "+randomSortTime+" ms");
    }

    private static void benchmarkTimSort(String[] dataSet, Locale locale){
        Benchmark_Timer<String[]> benchmark_timer = new Benchmark_Timer<>(
                "Tim Sort Test",
                array -> new TimSort<String>()
                        .withLocale(locale)
                        .sort(array));
        double randomSortTime = benchmark_timer.runFromSupplier(dataSet::clone, 10);
        System.out.println("Tim Sort Average Sort Time for dataset of size "+dataSet.length+" = "+randomSortTime+" ms");
    }

    private static void benchmarkDualPivotQuickSort(String[] dataSet, Locale locale){
        Benchmark_Timer<String[]> benchmarkTimer = new Benchmark_Timer<>(
                "Dual Pivot Quick Sort Test",
                array ->new DualPivotQuicksort<String>()
                            .withLocale(locale)
                            .sort(array));
        double randomSortTime = benchmarkTimer.runFromSupplier(dataSet::clone, 10);
        System.out.println("Dual Pivot Quick Sort Average Sort Time for dataset of size "+dataSet.length+" = "+randomSortTime+" ms");
    }

    private static void benchmarkLSDSort(String[] dataSet, boolean isChinese){
        Benchmark_Timer<String[]> benchmarkTimer = new Benchmark_Timer<>(
                "LSD Sort Test",
                array -> new LSDStringSort()
                        .withUnaryOperator((isChinese)?StringSortAPI.PINYIN_STRING_SUPPLIER:null)
                        .sort(array));
        double randomSortTime = benchmarkTimer.runFromSupplier(dataSet::clone, 10);
        System.out.println("LSD String Sort Average Sort Time for dataset of size "+dataSet.length+" = "+randomSortTime+" ms");
    }

    private static void benchmarkMSDSort(String[] dataSet, boolean isChinese){
        ;
        Benchmark_Timer<String[]> benchmarkTimer = new Benchmark_Timer<>(
                "MSD Sort Test",
                array -> new MSDStringSort(array.length)
                        .withInsertionSortMSDOperator(InsertionSortMSD.PINYIN_CHAR_SUBSTRING_BINARY_OPERATOR)
                        .withUnaryOperator((isChinese)?StringSortAPI.PINYIN_STRING_SUPPLIER:null)
                        .sort(array));
        double randomSortTime = benchmarkTimer.runFromSupplier(dataSet::clone, 10);
        System.out.println("MSD String Sort Average Sort Time for dataset of size "+dataSet.length+" = "+randomSortTime+" ms");
    }

    private static void benchmarkThreeWayRadixSort(String[] dataSet, boolean isChinese){
        Benchmark_Timer<String[]> benchmarkTimer = new Benchmark_Timer<>(
                "Three Way Radix Sort",
                array -> new ThreeWayRadixQuicksort<String>()
                        .withUnaryOperator((isChinese)?StringSortAPI.PINYIN_STRING_SUPPLIER:null)
                        .sort(array));
        double randomSortTime = benchmarkTimer.runFromSupplier(dataSet::clone, 10);
        System.out.println("Three way radix Sort Average Sort Time for dataset of size "+dataSet.length+" = "+randomSortTime+" ms");
    }


}
