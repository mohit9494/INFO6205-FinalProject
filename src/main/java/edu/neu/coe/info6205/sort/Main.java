package edu.neu.coe.info6205.sort;

import edu.neu.coe.info6205.benchmark.Benchmark_Timer;
import edu.neu.coe.info6205.util.FileReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Locale;

public class Main {


    public static void main(String[] args) throws URISyntaxException, IOException {

        String[] input = FileReader.fileReader("shuffledChinese.txt");
        Benchmark_Timer<String[]> benchmark_timer = new Benchmark_Timer<>(
                "Tim Sort Test",
                array -> new TimSort<String>().withLocale(Locale.CHINA).sort(array));
        double randomSortTime = benchmark_timer.runFromSupplier(input::clone, 10);
        System.out.println(randomSortTime);
    }


}
