package edu.neu.coe.info6205.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertArrayEquals;

public class DualPivotQuickSortTest {

    @Test
    public void sortInteger0(){
        int n = 20;
        Integer[] input = new Integer[n];
        for (int i = 0; i < n; i++) {
            input[i] = ThreadLocalRandom.current().nextInt(100);
        }
        Integer[] expected = Arrays.copyOf(input,n);
        Arrays.sort(expected);
        new DualPivotQuicksort<Integer>().sort(input);
        assertArrayEquals(expected,input);
    }

    @Test
    public void sortEnglish0(){
        String[] input = new String[]{"c","b","a","f","d","e"};
        String[] expected = new String[]{"a","b","c","d","e","f"};
        new DualPivotQuicksort<String>().sort(input);
        assertArrayEquals(expected, input);
    }

}
