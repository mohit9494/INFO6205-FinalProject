package edu.neu.coe.info6205.sort;

import edu.neu.coe.info6205.benchmark.Benchmark_Timer;
import edu.neu.coe.info6205.sort.api.StringSortAPI;
import edu.neu.coe.info6205.sort.huskysort.HuskyCoderFactory;
import edu.neu.coe.info6205.sort.huskysort.PureHuskySort;
import edu.neu.coe.info6205.util.FileReader;
import org.jetbrains.annotations.Nullable;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;

public class Main {



    public static void main(String[] args) throws URISyntaxException, IOException {

        StringBuilder ouputBuilder = new StringBuilder();
        ouputBuilder.append("SortName,").append("Array length,").append("Time in ms").append("\n");
        //read complete 4 million from chinese
        System.out.println("Starting benchmark on Chinese words");
        startBenchmarkOnSorts(FileReader.fileReader("shuffledChinese4M.txt"), Locale.CHINESE, true, ouputBuilder, "Chinese");

        System.out.println("Starting benchmark on English words");
        String[] engs1M = FileReader.fileReader("ENG_1M.txt");
        Collections.shuffle(Arrays.asList(engs1M));
        startBenchmarkOnSorts(engs1M, null, false, ouputBuilder, "English");

        System.out.println("Starting benchmark on Telugu words");
        startBenchmarkOnSorts(FileReader.fileReader("TeluguWords.txt"), null, false, ouputBuilder, "Telugu");

        try {
            PrintWriter writer = new PrintWriter("./src/main/resources/benchmarkOutput/benchmark.csv");
            writer.write(ouputBuilder.toString());
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void startBenchmarkOnSorts(String[] input, @Nullable Locale locale, boolean isChinese, StringBuilder stringBuilder, String language) {
        for (int i = 0; i < 4; i++) {
            String[] dataset = Arrays.copyOf(input, input.length / 4);
            System.out.printf("Starting Sort Benchmark on array of length %d%n", dataset.length);
            writeOutputLine(stringBuilder, "Husky Sort", language, dataset.length, benchmarkHuskySort(dataset));
            writeOutputLine(stringBuilder, "Tim Sort", language, dataset.length, benchmarkTimSort(dataset, locale));
            writeOutputLine(stringBuilder, "Dual Pivot Sort", language, dataset.length, benchmarkDualPivotQuickSort(dataset, locale));
            writeOutputLine(stringBuilder, "LSD Sort", language, dataset.length, benchmarkLSDSort(dataset, isChinese));
            writeOutputLine(stringBuilder, "MSD Sort", language, dataset.length, benchmarkMSDSort(dataset, isChinese));
            writeOutputLine(stringBuilder, "Three Way Radix Sort", language, dataset.length, benchmarkThreeWayRadixSort(dataset, isChinese));
            stringBuilder.append("\n").append("\n");
        }
    }


    private static double benchmarkHuskySort(String[] dataSet) {
        Benchmark_Timer<String[]> benchmarkTimer = new Benchmark_Timer<>(
                "Husky Sort Test",
                array -> new PureHuskySort<>(HuskyCoderFactory.asciiCoder, false, false)
                        .sort(array));
        double randomSortTime = benchmarkTimer.runFromSupplier(dataSet::clone, 10);
        System.out.println("Husky Sort Average Sort Time for dataset of size " + dataSet.length + " = " + randomSortTime + " ms");
        return randomSortTime;
    }

    private static double benchmarkTimSort(String[] dataSet, Locale locale) {
        Benchmark_Timer<String[]> benchmark_timer = new Benchmark_Timer<>(
                "Tim Sort Test",
                array -> new TimSort<String>()
                        .withLocale(locale)
                        .sort(array));
        double randomSortTime = benchmark_timer.runFromSupplier(dataSet::clone, 10);
        System.out.println("Tim Sort Average Sort Time for dataset of size " + dataSet.length + " = " + randomSortTime + " ms");
        return randomSortTime;
    }

    private static double benchmarkDualPivotQuickSort(String[] dataSet, Locale locale) {
        Benchmark_Timer<String[]> benchmarkTimer = new Benchmark_Timer<>(
                "Dual Pivot Quick Sort Test",
                array -> new DualPivotQuicksort<String>()
                        .withLocale(locale)
                        .sort(array));
        double randomSortTime = benchmarkTimer.runFromSupplier(dataSet::clone, 10);
        System.out.println("Dual Pivot Quick Sort Average Sort Time for dataset of size " + dataSet.length + " = " + randomSortTime + " ms");
        return randomSortTime;
    }

    private static double benchmarkLSDSort(String[] dataSet, boolean isChinese) {
        Benchmark_Timer<String[]> benchmarkTimer = new Benchmark_Timer<>(
                "LSD Sort Test",
                array -> new LSDStringSort()
                        .withUnaryOperator((isChinese) ? StringSortAPI.PINYIN_STRING_SUPPLIER : null)
                        .sort(array));
        double randomSortTime = benchmarkTimer.runFromSupplier(dataSet::clone, 10);
        System.out.println("LSD String Sort Average Sort Time for dataset of size " + dataSet.length + " = " + randomSortTime + " ms");
        return randomSortTime;
    }

    private static double benchmarkMSDSort(String[] dataSet, boolean isChinese) {
        ;
        Benchmark_Timer<String[]> benchmarkTimer = new Benchmark_Timer<>(
                "MSD Sort Test",
                array -> new MSDStringSort(array.length)
                        .withInsertionSortMSDOperator((isChinese) ? InsertionSortMSD.PINYIN_CHAR_SUBSTRING_BINARY_OPERATOR : InsertionSortMSD.SUBSTRING_BINARY_OPERATOR)
                        .withUnaryOperator((isChinese) ? StringSortAPI.PINYIN_STRING_SUPPLIER : null)
                        .sort(array));
        double randomSortTime = benchmarkTimer.runFromSupplier(dataSet::clone, 10);
        System.out.println("MSD String Sort Average Sort Time for dataset of size " + dataSet.length + " = " + randomSortTime + " ms");
        return randomSortTime;
    }

    private static double benchmarkThreeWayRadixSort(String[] dataSet, boolean isChinese) {
        Benchmark_Timer<String[]> benchmarkTimer = new Benchmark_Timer<>(
                "Three Way Radix Sort",
                array -> new ThreeWayRadixQuicksort<String>()
                        .withUnaryOperator((isChinese) ? StringSortAPI.PINYIN_STRING_SUPPLIER : null)
                        .sort(array));
        double randomSortTime = benchmarkTimer.runFromSupplier(dataSet::clone, 10);
        System.out.println("Three way radix Sort Average Sort Time for dataset of size " + dataSet.length + " = " + randomSortTime + " ms");
        return randomSortTime;
    }

    private static void writeOutputLine(StringBuilder stringBuilder, String sortName, String language, int arrayLength, double time) {
        stringBuilder.append(sortName).append(",")
                .append(language).append(",")
                .append(arrayLength).append(",")
                .append(time).append("\n");
    }


}
